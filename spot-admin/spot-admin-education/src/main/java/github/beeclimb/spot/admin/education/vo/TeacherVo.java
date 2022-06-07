package github.beeclimb.spot.admin.education.vo;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author jun.ma
 * @date 2022/6/7 17:05:00
 */
@Data
public class TeacherVo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 讲师名称
     */
    private String name;

    /**
     * 职业级别
     */
    private Integer level;

    /**
     * 查询开始时间
     */
    private String startTime;

    /**
     * 查询结束时间
     */
    private String endTime;

}
