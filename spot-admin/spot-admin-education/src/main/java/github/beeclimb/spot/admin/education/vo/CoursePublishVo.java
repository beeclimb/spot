package github.beeclimb.spot.admin.education.vo;

import lombok.Data;

/**
 * @author jun.ma
 * @date 2022/7/7 10:09:00
 */
@Data
public class CoursePublishVo {
    private static final long serialVersionUID = 1L;

    private String id;
    private String title;
    private String cover;
    private String price;
    private Integer lessonNum;

    private String subjectLevelOne;
    private String subjectLevelTwo;

    private String teacherName;

    private String description;

}
