package com.dilip.job.task;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.dilip.job.beans.JobInfo;

@Service
public class EmailManagerServiceImpl {

	public void submitEmailJob(JobInfo jobInfo, Map<String, String> status) {
		status.put(jobInfo.getName(), "running");
		try {
			
			Thread.sleep(8000);
			System.out.println("hello job is running");
			
		} catch (Exception e) {
			System.out.println("handel exception");
			System.out.println("roll back");
		} finally {
			System.out.println("clean the resources");
		}
	}

}