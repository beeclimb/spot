package github.beeclimb.spot.admin.education.vo;

import lombok.Data;

import java.util.List;

/**
 * @author jun.ma
 * @date 2022/7/2 22:04:00
 */
@Data
public class FirstSubjectVo {

    private String id;

    private String title;

    private List<SecondSubjectVo> secondSubjectList;

}
