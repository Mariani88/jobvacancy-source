package com.jobvacancy.domain;

import java.util.List;
import java.util.TimerTask;

public class AnalizerPublishedDateTask extends TimerTask{

	@Override
	public void run() {
		
		List <JobOffer> offers =   AnalizerActiveJobOffer.getJobOffers();
	
		//modificar active si cumple o no con un mes de publicacion
		
		
		
	}
}