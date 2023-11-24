package sgsits.cse.dis.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableSwagger2
public class UserApplication {

  public static void main(String[] args) {
    SpringApplication.run(UserApplication.class, args);
  }

  //use fixedRate
  //	@Scheduled(initialDelay = 1000L, fixedDelayString = "${SchedulingJob.enrollment-update-delay}")
  //	void someJob() throws InterruptedException{
  //		System.out.println("Hello from Scheduler**********************");
  //
  //		//Wait for 2 seconds
  //		Thread.sleep(1000L);
  //	}
}

//@Configuration
//@EnableScheduling
//@ConditionalOnProperty(name = "scheduling.enabled", matchIfMissing = true)
//class SchedulingConfiguration{
//
//}


