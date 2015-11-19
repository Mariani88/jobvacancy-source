package com.jobvacancy.domain.util;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.jobvacancy.domain.JobOffer;

public class AnalizerDateJobOfferTest {

	
	@SuppressWarnings("deprecation")
	@Test
	public void analizerActiveDateMustDoFalseActiveJobOfferMajorDateToMonth() {

		AnalizerDateJobOffer analizerDate = new AnalizerDateJobOffer();

		JobOffer jobOfferOld = createJobOfferForTest(new Date(2015, 10, 17));

		analizerDate.analize(jobOfferOld);
		
		Assert.assertFalse(jobOfferOld.getActive());
	}
	
	@Test
	public void analizerActiveDateMustDoTrueActiveJobOfferWithDateMinorToMesOld() {

		AnalizerDateJobOffer analizerDate = new AnalizerDateJobOffer();

		@SuppressWarnings("deprecation")
		JobOffer jobOfferNew = createJobOfferForTest (new Date (2015,11,17));

		analizerDate.analize(jobOfferNew);

		Assert.assertTrue(jobOfferNew.getActive() );
		
	}
	
	
	private JobOffer createJobOfferForTest ( Date date){
		
		JobOffer jobOffer = new JobOffer ();
		jobOffer.setCreationDate(date);
		jobOffer.setActive(true);
		
		return jobOffer;
	}
	
}
