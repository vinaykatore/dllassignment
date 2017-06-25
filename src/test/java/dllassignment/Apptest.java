package dllassignment;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:dll-jobs.xml",
    "classpath:context.xml",
    "classpath:test-dll-context.xml"})
public class Apptest {

    @Autowired
    private JobLauncherTestUtils launcher;

    @Test
    public void testDllJobs() throws Exception {

        JobExecution jobExecution = launcher.launchJob();

        assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());

    }
}