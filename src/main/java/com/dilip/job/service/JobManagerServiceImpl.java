package com.dilip.job.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.dilip.job.beans.JobInfo;
import com.dilip.job.task.EmailManagerServiceImpl;

@Service
public class JobManagerServiceImpl implements JobManagerService {

	@Autowired
	EmailManagerServiceImpl emailManagerServiceImpl;
	Map<String, String> status = new HashMap<String, String>();

	// Queue<JobInfo> queue = new PriorityQueue<JobInfo>();
	PriorityBlockingQueue<JobInfo> queue = new PriorityBlockingQueue<>();

	@Override
	@Async
	public void sumitJob(JobInfo jobInfo) {

		System.out.println("Adding to queue");
		queue.add(jobInfo);
		status.put(jobInfo.getName(), "INQUEUE");
		// status.put("jobType", jobInfo.getJobType());

		Thread thread = new Thread(() -> {
			System.out.println("Polling...");
			while (true) {
				try {
					Thread.sleep(8000);
					System.out.println(queue.size());
					JobInfo poll = queue.take();
					// here we need to put some condition what is job name
					if (jobInfo.getName().equalsIgnoreCase("EMAIL")) {
						status.put(jobInfo.getName(), "staretd");
						emailManagerServiceImpl.submitEmailJob(poll, status);
						status.put(jobInfo.getName(), "completed");
					}
					System.out.println("Polled: " + poll);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		thread.start();

	}

	@Override

	public void sumitJobImmediately(JobInfo jobInfo) {
		System.out.println("immediate job");
		status.put("dddd", "INQUEUE");
		// here we need to put some condition what is job name

	}

	@Override
	public void sumitscheduleJob(JobInfo jobInfo) {
		// here we need to put some condition what is job name
		System.out.println("sumitscheduleJob");

	}

	public Map<String, String> getStatus() {
		return status;
	}	

}