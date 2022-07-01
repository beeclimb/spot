package github.beeclimb.spot.admin.education.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author jun.ma
 * @date 2022/7/1/ 22:42:00
 */
@Data
public class SubjectData {

    @ExcelProperty(index = 0)
    private String oneLevelSubject;

    @ExcelProperty(index = 1)
    private String twoLevelSubject;

}
