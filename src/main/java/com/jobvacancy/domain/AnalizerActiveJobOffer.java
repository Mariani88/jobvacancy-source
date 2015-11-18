package com.jobvacancy.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class AnalizerActiveJobOffer {

	private Timer cronometer = new Timer ();
	private TimerTask analizerActiveTask= new AnalizerPublishedDateTask ();
	private static List <JobOffer> jobOffers = new LinkedList <JobOffer> ();
	
	public AnalizerActiveJobOffer (List <JobOffer> offers){
		jobOffers = offers;
	}
	
	public void runAnalizerActiveOffers (){
		
		long day = 1000 * 3600 * 24;
		this.cronometer.schedule(this.analizerActiveTask, 100, day);
		
	}

	public static List <JobOffer> getJobOffers() {
		return jobOffers;
	}	
}