package github.beeclimb.spot.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpotOssApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpotOssApplication.class, args);
    }

}
