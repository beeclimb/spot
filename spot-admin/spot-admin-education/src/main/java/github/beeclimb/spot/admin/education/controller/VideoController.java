package github.beeclimb.spot.admin.education.controller;


import github.beeclimb.spot.admin.education.entity.Video;
import github.beeclimb.spot.admin.education.service.VideoService;
import github.beeclimb.spot.common.util.api.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author baomidou
 * @since 2022-07-03
 */
@RestController
@RequestMapping("/education/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @PostMapping("/addVideo")
    public Response addVideo(@RequestBody Video video) {
        videoService.save(video);
        return Response.success();
    }

    // TODO 删除小节时，同时把里面的视频删掉

    @DeleteMapping("/deleteVideo/{videoId}")
    public Response deleteVideo(@PathVariable String videoId) {
        videoService.removeById(videoId);
        return Response.success();
    }

    @GetMapping("/getVideoById/{videoId}")
    public Response<Map<String, Video>> getVideoById(@PathVariable String videoId) {
        Video video = videoService.getById(videoId);
        Map<String, Video> data = new HashMap<>(1);
        data.put("video", video);
        return Response.success(data);
    }

    @PostMapping("/updateVideo")
    public Response updateVideo(@RequestBody Video video) {
        videoService.updateById(video);
        return Response.success();
    }

}

