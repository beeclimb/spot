package github.beeclimb.spot.admin.education.controller;


import github.beeclimb.spot.admin.education.service.ChapterService;
import github.beeclimb.spot.admin.education.vo.ChapterVo;
import github.beeclimb.spot.common.util.api.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author baomidou
 * @since 2022-07-03
 */
@RestController
@RequestMapping("/education/chapter")
public class ChapterController {

    @Autowired
    ChapterService chapterService;

    @GetMapping("/getChapterVideoByCourseId/{courseId}")
    public Response<Map<String, List<ChapterVo>>> getChapterVideoByCourseId(@PathVariable String courseId) {
        List<ChapterVo> chapterVideoList = chapterService.getChapterVideoByCourseId(courseId);
        Map<String, List<ChapterVo>> result = new HashMap<>(1);
        result.put("chapterVideoList", chapterVideoList);
        return Response.success(result);
    }


}

