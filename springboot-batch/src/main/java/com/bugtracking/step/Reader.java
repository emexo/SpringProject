package com.bugtracking.step;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;


public class Reader implements ItemReader<String> {


	@BeforeStep
	public void beforeStep(final StepExecution stepExecution) {
		JobParameters jobParameters = stepExecution.getJobParameters();

	}

	private String[] messages = { "Welcome to eMexo Technologies",
			"Welcome to Spring Batch Example",
			"We use H2 Database for this example" };

	private int count = 0;

	@Override
	public String read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {


		if (count < messages.length) {
			return messages[count++];
		} else {
			count = 0;
		}
		return null;
	}

}