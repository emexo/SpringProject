package com.bugtracking.listener;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

public class JobCompletionListener extends JobExecutionListenerSupport {

	@Override
	public void afterJob(JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			System.out.println("BATCH JOB COMPLETED SUCCESSFULLY: "+ jobExecution.getStatus());
		}
	}

	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println("BATCH JOB STATUS: "+ jobExecution.getStatus());
	}

}
