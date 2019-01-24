package com.dilip.job.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dilip.job.beans.JobInfo;
import com.dilip.job.service.JobManagerService;

@RestController

public class JobManagerController {

	@Autowired
	JobManagerService jobManager;

	@RequestMapping(value = "/getstatus", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public List<Map<String, String>> getStatus() {
		
		List<Map<String, String>> jobstatusList = new ArrayList<Map<String, String>>();
		jobstatusList.add(jobManager.getStatus());
		return jobstatusList;

	}

	@RequestMapping(value = "/sumitjob", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public void sumitJob(@RequestBody JobInfo jobInfo) {
		jobManager.sumitJob(jobInfo);
	}

	@RequestMapping(value = "/sumitimmediatejob", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public void sumitImmediateJob(@RequestBody JobInfo jobInfo) {
		jobManager.sumitJobImmediately(jobInfo);
	}

	// @RequestMapping(value="/pow", method=RequestMethod.GET)
	// (@RequestParam(value="base") int base1)

	// @RequestMapping("/sqrt/{num}")
	// public double sqrt(@PathVariable(value="num") int num1)
}
