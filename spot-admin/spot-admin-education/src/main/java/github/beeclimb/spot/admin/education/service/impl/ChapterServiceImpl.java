package github.beeclimb.spot.admin.education.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import github.beeclimb.spot.admin.education.entity.Chapter;
import github.beeclimb.spot.admin.education.entity.Video;
import github.beeclimb.spot.admin.education.mapper.ChapterMapper;
import github.beeclimb.spot.admin.education.service.ChapterService;
import github.beeclimb.spot.admin.education.service.VideoService;
import github.beeclimb.spot.admin.education.vo.ChapterVo;
import github.beeclimb.spot.admin.education.vo.VideoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author baomidou
 * @since 2022-07-03
 */
@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter> implements ChapterService {

    @Autowired
    VideoService videoService;

    @Override
    public List<ChapterVo> getChapterVideoByCourseId(String courseId) {
        QueryWrapper<Chapter> chapterWrapper = new QueryWrapper<>();
        chapterWrapper.eq("course_id", courseId);
        List<Chapter> chaptersList = baseMapper.selectList(chapterWrapper);

        QueryWrapper<Video> videoWrapper = new QueryWrapper<>();
        videoWrapper.eq("course_id", courseId);
        List<Video> videosList = videoService.list(videoWrapper);

        List<ChapterVo> chapterVoList = new LinkedList<>();

        for (Chapter chapter : chaptersList) {
            ChapterVo chapterVo = new ChapterVo();
            BeanUtils.copyProperties(chapter, chapterVo);
            chapterVoList.add(chapterVo);

            Iterator<Video> videoIterator = videosList.iterator();
            List<VideoVo> videoVoList = new LinkedList<>();

            while (videoIterator.hasNext()) {
                Video video = videoIterator.next();
                if (video.getChapterId().equals(chapter.getId())) {
                    VideoVo videoVo = new VideoVo();
                    BeanUtils.copyProperties(video, videoVo);
                    videoVoList.add(videoVo);
                }
            }
            chapterVo.setVideoInChapter(videoVoList);
        }
        return chapterVoList;
    }
}
