package com.jobvacancy.domain.util;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jobvacancy.domain.JobOffer;
import com.jobvacancy.repository.JobOfferRepository;

@Component
@Transactional
public class ScannerJobOfferDate {

	@Inject
    private JobOfferRepository jobOfferRepository;
	private AnalizerDateJobOffer analizerDate = new AnalizerDateJobOffer();
	
	public void scanJobOffers() {
		
		List <JobOffer> jobOffers = this.jobOfferRepository.findAll();
		Iterator <JobOffer> iterator = jobOffers.iterator();
		boolean desactive = false;
		
		while ( iterator.hasNext() ){
			JobOffer jobOffer = iterator.next();
			desactive = this.analizerDate.shouldDesactive(jobOffer);
			
			if (desactive){
				this.jobOfferRepository.save(jobOffer);
			}
		}
	}
}