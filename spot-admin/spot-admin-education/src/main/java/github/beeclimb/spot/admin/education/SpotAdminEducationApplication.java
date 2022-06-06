package github.beeclimb.spot.admin.education;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"github.beeclimb.spot.admin", "github.beeclimb.spot.common"})
public class SpotAdminEducationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpotAdminEducationApplication.class, args);
    }
}
