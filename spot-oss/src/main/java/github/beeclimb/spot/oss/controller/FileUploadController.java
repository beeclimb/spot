package github.beeclimb.spot.oss.controller;

import github.beeclimb.spot.common.util.api.Response;
import github.beeclimb.spot.oss.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jun.ma
 * @date 2022/6/22 22:15:00
 */
@RestController
@RequestMapping("/education/oss")
public class FileUploadController {

    @Autowired
    FileUploadService fileUploadService;

    @PostMapping("/uploadFile")
    public Response<Map<String, String>> uploadAvatar(@RequestParam("file") MultipartFile file) {
        String url = fileUploadService.uploadFile(file);
        Map<String, String> map = new HashMap<>(1);
        map.put("avatarUrl", url);
        return Response.success(map);
    }


}
