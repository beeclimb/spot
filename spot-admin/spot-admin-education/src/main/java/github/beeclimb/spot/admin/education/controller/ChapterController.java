package github.beeclimb.spot.admin.education.controller;


import github.beeclimb.spot.admin.education.entity.Chapter;
import github.beeclimb.spot.admin.education.service.ChapterService;
import github.beeclimb.spot.admin.education.vo.ChapterVo;
import github.beeclimb.spot.common.util.api.Response;
import github.beeclimb.spot.common.util.api.ResponseCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/addChapter")
    public Response addChapter(@RequestBody Chapter chapter) {
        chapterService.save(chapter);
        return Response.success();
    }

    @PostMapping("/updateChapter")
    public Response updateChapter(@RequestBody Chapter chapter) {
        chapterService.updateById(chapter);
        return Response.success();
    }

    @GetMapping("/getChapterById/{chapterId}")
    public Response<Map<String, Chapter>> gerChapterById(@PathVariable String chapterId) {
        Chapter chapter = chapterService.getById(chapterId);
        Map<String, Chapter> data = new HashMap<>(1);
        data.put("chapter", chapter);
        return Response.success(data);
    }

    @DeleteMapping("/deleteChapter/{chapterId}")
    public Response deleteChapter(@PathVariable String chapterId) {
        return chapterService.deleteChapterById(chapterId) ? Response.success() : Response.fail(ResponseCodeEnum.FAILED_INVALID_OPERATION);
    }


}

