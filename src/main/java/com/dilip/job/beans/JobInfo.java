package com.dilip.job.beans;

public class JobInfo implements Comparable<JobInfo> {

	private String name;
	private String jobType;
	private int jobpriority;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public int getJobpriority() {
		return jobpriority;
	}
	public void setJobpriority(int jobpriority) {
		this.jobpriority = jobpriority;
	}
	
	
	@Override
	public String toString() {
		return "JobInfo [name=" + name + ", jobType=" + jobType + ", jobpriority=" + jobpriority + "]";
	}
	@Override
	public int compareTo(JobInfo b) {
		if(jobpriority>b.jobpriority){  
	        return 1;  
	    }else if(jobpriority<b.jobpriority){  
	        return -1;  
	    }else{  
	    return 0;  
	    }  
	}

	

}
