package github.beeclimb.spot.admin.education.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author jun.ma
 * @date 2022/7/3 14:25:00
 */
@Data
public class CourseInfoVo {
    private static final long serialVersionUID = 1L;

    private String id;

    private String teacherId;

    private String subjectParentId;

    private String subjectId;

    private String title;

    private BigDecimal price;

    private Integer lessonNum;

    private String cover;

    private String description;

}
