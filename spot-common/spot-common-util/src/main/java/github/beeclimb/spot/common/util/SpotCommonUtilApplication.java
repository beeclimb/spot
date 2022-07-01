package github.beeclimb.spot.common.util;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpotCommonUtilApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpotCommonUtilApplication.class, args);
    }

}
