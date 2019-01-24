package com.dilip.job.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.dilip.job.beans.JobInfo;

@Component
public class Scheduler {

	@Autowired
	JobManagerService jobManager;
	JobInfo jobInfo = new JobInfo();

	@Scheduled(cron = "${cone.value}")
	public void sumitscheduleJob() {
		// get the job data from some location
		System.out.println("Schedular started");
		jobManager.sumitscheduleJob(jobInfo);

	}
}