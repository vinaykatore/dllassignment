package com.accenture.dll.main;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {

	public static void main(String[] args) {

		Launcher obj = new Launcher();
		obj.run();

	}

	private void run() {

		String[] springConfig = { "context.xml", "dll-jobs.xml" };

		ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);

		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		Job job = (Job) context.getBean("doorToggler");

		try {

			JobExecution execution = jobLauncher.run(job, new JobParameters());

		} catch (Exception e) {
			e.printStackTrace();

		}


	}

}
