package com.jobvacancy.domain.util;

import java.util.Date;
import org.junit.Assert;
import org.junit.Test;

import com.jobvacancy.domain.JobOffer;

public class AnalizerDateJobOfferTest {

	
	@SuppressWarnings("deprecation")
	@Test
	public void analizerActiveDateMustDoFalseActiveJobOfferMajorDateToMonth() {

		AnalizerDateJobOffer analizerDate = new AnalizerDateJobOffer();

		JobOffer jobOfferOld = createJobOfferForTest(new Date(2015, 10, 17));

		boolean desactive = analizerDate.shouldDesactive(jobOfferOld);
		
		Assert.assertFalse(jobOfferOld.getActive());
		Assert.assertTrue(desactive);
	}
	
	@Test
	public void analizerActiveDateMustDoTrueActiveJobOfferWithDateMinorToMesOld() {

		AnalizerDateJobOffer analizerDate = new AnalizerDateJobOffer();

		@SuppressWarnings("deprecation")
		JobOffer jobOfferNew = createJobOfferForTest (new Date (2015,11,17));

		boolean desactive = analizerDate.shouldDesactive(jobOfferNew);

		Assert.assertTrue(jobOfferNew.getActive() );
		Assert.assertFalse (desactive);
		
	}
	
	
	private JobOffer createJobOfferForTest ( Date date){
		
		JobOffer jobOffer = new JobOffer ();
		jobOffer.setCreationDate(date);
		jobOffer.setActive(true);
		
		return jobOffer;
	}
	
}
