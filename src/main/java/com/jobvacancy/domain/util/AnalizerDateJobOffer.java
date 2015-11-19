package com.jobvacancy.domain.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.jobvacancy.domain.JobOffer;

public class AnalizerDateJobOffer {
		
	private long monthInMilliseconds;
	private Date todayDate;
	
	@SuppressWarnings("deprecation")
	public AnalizerDateJobOffer() {

		this.monthInMilliseconds = 1000 * 3600 * 24 * 30;
		Calendar calendar = new GregorianCalendar();

		this.todayDate = new Date(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE));
	}

	public void analize(JobOffer jobOffer) {

		long timeSinceCreation = this.todayDate.getTime() - jobOffer.getCreationDate().getTime();

		if (timeSinceCreation > this.monthInMilliseconds) {

			jobOffer.setActive(false);
		}
	}
}