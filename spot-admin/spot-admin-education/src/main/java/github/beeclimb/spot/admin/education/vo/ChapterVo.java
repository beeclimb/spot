package github.beeclimb.spot.admin.education.vo;

import lombok.Data;

import java.util.List;

/**
 * @author jun.ma
 * @date 2022/7/5 17:05:00
 */
@Data
public class ChapterVo {

    private String id;

    private String title;

    private List<VideoVo> videoInChapter;

}
