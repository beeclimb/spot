package github.beeclimb.spot.admin.education.service;

import com.baomidou.mybatisplus.extension.service.IService;
import github.beeclimb.spot.admin.education.entity.Chapter;
import github.beeclimb.spot.admin.education.vo.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author baomidou
 * @since 2022-07-03
 */
public interface ChapterService extends IService<Chapter> {

    List<ChapterVo> getChapterVideoByCourseId(String courseId);

}
