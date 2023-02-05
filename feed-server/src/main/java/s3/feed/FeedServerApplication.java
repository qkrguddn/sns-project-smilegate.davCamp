package s3.feed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FeedServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(FeedServerApplication.class, args);
	}

}
