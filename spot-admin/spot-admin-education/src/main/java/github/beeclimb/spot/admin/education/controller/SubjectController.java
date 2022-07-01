package github.beeclimb.spot.admin.education.controller;


import github.beeclimb.spot.admin.education.service.SubjectService;
import github.beeclimb.spot.common.util.api.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author baomidou
 * @since 2022-06-28
 */
@RestController
@RequestMapping("/education/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping("/addSubject")
    public Response addSubject(MultipartFile file) {

        subjectService.saveSubject(file);
        return Response.success();

    }


}

