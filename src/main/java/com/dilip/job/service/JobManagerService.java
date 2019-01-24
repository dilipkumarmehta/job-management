package com.dilip.job.service;

import java.util.Map;

import com.dilip.job.beans.JobInfo;

public interface JobManagerService {

	public void sumitJob(JobInfo jobInfo);

	public Map<String, String> getStatus();

	public void sumitJobImmediately(JobInfo jobInfo);

	public void sumitscheduleJob(JobInfo jobInfo);

}