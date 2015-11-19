package com.jobvacancy.domain.util;

import java.util.Date;
import javax.inject.Inject;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;
import com.jobvacancy.domain.JobOffer;
import com.jobvacancy.repository.JobOfferRepository;

public class ScannerJobOfferDateTest {

	/*@Inject
    private JobOfferRepository jobOfferRepository;
	
	@SuppressWarnings("deprecation")
	@Test
	@Transactional
	public void scanCreationDateMustUpdateJobOffersActives (){
		
		JobOffer jobOfferNew = createJobOfferForTest (new Date(2015, 11, 17), new Long (1) );
		JobOffer jobOfferOld = createJobOfferForTest (new Date(2015, 10, 17), new Long (2) );
		
		this.jobOfferRepository.save(jobOfferNew);
		this.jobOfferRepository.save(jobOfferOld);
		
		ScannerJobOfferDate scanner = new ScannerJobOfferDate ();
		scanner.scanJobOffers ();
		
		JobOffer jobOffer = this.jobOfferRepository.findOne( new Long (1) );
		JobOffer jobOffer2 = this.jobOfferRepository.findOne( new Long (2) );
		
		Assert.assertTrue( jobOffer.getActive());
		Assert.assertFalse( jobOffer2.getActive());
	}
	
	
	private JobOffer createJobOfferForTest (Date date, Long id){
		
		JobOffer jobOffer = new JobOffer ();
		
		jobOffer.setId(id);
		jobOffer.setCreationDate(date );
		jobOffer.setActive(true);
		
		return jobOffer;
	}*/
}