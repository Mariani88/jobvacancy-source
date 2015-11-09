package com.jobvacancy.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.jobvacancy.domain.JobOffer;
import com.jobvacancy.repository.JobOfferRepository;
import com.jobvacancy.service.MailService;
import com.jobvacancy.web.rest.dto.JobApplicationDTO;
import com.jobvacancy.web.rest.dto.utils.ValidatorJobApplicationData;
import com.jobvacancy.web.rest.util.HeaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.inject.Inject;
import javax.validation.Valid;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api")
public class JobApplicationResource {

	private final Logger log = LoggerFactory.getLogger(JobOfferResource.class);
	private ValidatorJobApplicationData validator = new ValidatorJobApplicationData();

	@Inject
	private JobOfferRepository jobOfferRepository;

	@Inject
	private MailService mailService;

	private MappingJackson2HttpMessageConverter jacksonMessageConverter = new MappingJackson2HttpMessageConverter ();

	private PageableHandlerMethodArgumentResolver pageableArgumentResolver = new PageableHandlerMethodArgumentResolver();

	private JobOfferResource jobOfferResource = new JobOfferResource();

	private MockMvc restJobOfferMockMvc = MockMvcBuilders.standaloneSetup(jobOfferResource)
			.setCustomArgumentResolvers(pageableArgumentResolver).setMessageConverters(jacksonMessageConverter).build();

	/**
	 * POST /Application -> Create a new jobOffer.
	 * 
	 * @throws Exception
	 * @throws IOException
	 */
	@RequestMapping(value = "/Application", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@Timed
	public ResponseEntity<JobOffer> createJobApplication(@Valid @RequestBody JobApplicationDTO jobApplication)
			throws IOException, Exception {
		log.debug("REST request to save JobApplication : {}", jobApplication);

		if (this.validator.validate(jobApplication.getEmail(), "mail")) {

			if (this.validator.validate(jobApplication.getLink(), "link")) {
				modifyOffersPostulationsAndSendEmail(jobApplication);

				return ResponseEntity.accepted()
						.headers(HeaderUtil.createAlert("Application created and sent offer's owner", "")).body(null);
			}
		} else {
			String bodyAlert = "INVALID EMAIL:" + jobApplication.getEmail()
					+ ", nothing was saved!!!. please check your email and try again";

			return ResponseEntity.badRequest().headers(HeaderUtil.createAlert(bodyAlert, "")).body(null);
		}
		String bodyAlert = "INVALID LINK:" + jobApplication.getLink()
				+ ", nothing was saved!!!. please check your link and try again";

		return ResponseEntity.badRequest().headers(HeaderUtil.createAlert(bodyAlert, "")).body(null);
	}

	
	private void modifyOffersPostulationsAndSendEmail(JobApplicationDTO jobApplication) throws Exception, IOException {
		
		JobOffer jobOffer = jobOfferRepository.findOne(jobApplication.getOfferId());
		jobOffer.setPostulations(new Long (jobOffer.getPostulations() + 1 ));
		jobOfferRepository.save(jobOffer);
		
		this.mailService.sendApplication(jobApplication.getEmail(), jobOffer, jobApplication.getLink());
	}
}