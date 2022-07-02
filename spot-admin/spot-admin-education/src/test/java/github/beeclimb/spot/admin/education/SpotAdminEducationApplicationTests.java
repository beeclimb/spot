package github.beeclimb.spot.admin.education;

import github.beeclimb.spot.admin.education.entity.Subject;
import github.beeclimb.spot.admin.education.vo.SecondSubjectVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpotAdminEducationApplicationTests {

    @Test
    void contextLoads() {
        SecondSubjectVo secondSubjectVo = new SecondSubjectVo();
        secondSubjectVo.setTitle("aaa");
        secondSubjectVo.setId("111");

        Subject subject = new Subject();
        subject.setTitle("bbb");
        subject.setId("222");

        BeanUtils.copyProperties(subject, secondSubjectVo);

        System.out.println(secondSubjectVo.toString());

        Subject subject1 = new Subject();
        subject1.setTitle("ccc");
        subject1.setId("333");

        BeanUtils.copyProperties(subject1, secondSubjectVo);

        System.out.println(secondSubjectVo.toString());


    }

}
