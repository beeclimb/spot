package github.beeclimb.spot.admin.education.controller;


import github.beeclimb.spot.admin.education.service.SubjectService;
import github.beeclimb.spot.admin.education.vo.FirstSubjectVo;
import github.beeclimb.spot.common.util.api.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        subjectService.saveSubject(file, subjectService);
        return Response.success();
    }

    @GetMapping("/getAllSubjects")
    public Response<Map<String, List<FirstSubjectVo>>> getAllSubjects() {
        List<FirstSubjectVo> allSubjectsList = subjectService.getAllSubjects();
        Map<String, List<FirstSubjectVo>> resultMap = new HashMap<>(1);
        resultMap.put("allSubjects", allSubjectsList);
        return Response.success(resultMap);
    }


}

