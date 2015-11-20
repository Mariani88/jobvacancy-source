package com.jobvacancy.domain.util;

import java.util.Date;
import javax.inject.Inject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.jobvacancy.Application;
import com.jobvacancy.domain.JobOffer;
import com.jobvacancy.repository.JobOfferRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
@Transactional
public class ScannerJobOfferDateTest {

	@Inject
    private JobOfferRepository jobOfferRepository;
	
	@Inject
	private ScannerJobOfferDate scanner;
	
	@SuppressWarnings("deprecation")
	@Test
	@Transactional
	public void scanCreationDateMustUpdateJobOffersActives (){
		
		JobOffer jobOfferNew = createJobOfferForTest (new Date(2015, 11, 17), new Long (1) );
		JobOffer jobOfferOld = createJobOfferForTest (new Date(2015, 10, 17), new Long (2) );
		
		this.jobOfferRepository.save(jobOfferNew);
		this.jobOfferRepository.save(jobOfferOld);
		
		scanner.scanJobOffers ();
		
		JobOffer jobOffer = this.jobOfferRepository.findOne( new Long (1) );
		JobOffer jobOffer2 = this.jobOfferRepository.findOne( new Long (2) );
		
		Assert.assertTrue( jobOffer.getActive());
		Assert.assertFalse( jobOffer2.getActive());
	}
	
	@Test
	@Transactional
	public void scanCreationDateMustNothingIfDatabaseIsEmpty (){
		
		scanner.scanJobOffers ();
		
		Assert.assertEquals( 0 , this.jobOfferRepository.findAll().size());
	}
	
	private JobOffer createJobOfferForTest (Date date, Long id){
		
		JobOffer jobOffer = new JobOffer ();
		
		jobOffer.setId(id);
		jobOffer.setCreationDate(date );
		jobOffer.setTitle("title");
		jobOffer.setActive(true);
		
		return jobOffer;
	}
}