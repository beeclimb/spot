package github.beeclimb.spot.admin.education.service;

import com.baomidou.mybatisplus.extension.service.IService;
import github.beeclimb.spot.admin.education.entity.Subject;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author baomidou
 * @since 2022-06-28
 */
public interface SubjectService extends IService<Subject> {

    void saveSubject(MultipartFile file);

}
