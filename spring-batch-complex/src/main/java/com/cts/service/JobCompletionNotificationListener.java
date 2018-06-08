package com.cts.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Service;

import com.cts.repository.PersonRepository;

@Service
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

	private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);;

	private final PersonRepository personRepo;

	public JobCompletionNotificationListener(PersonRepository personRepo) {
		this.personRepo = personRepo;
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
			log.info("!!! JOB FINISHED! Time to verify the results");
			personRepo.findAll().forEach(person -> log.info("Found <" + person + "> in the database."));
		}
	}
}
