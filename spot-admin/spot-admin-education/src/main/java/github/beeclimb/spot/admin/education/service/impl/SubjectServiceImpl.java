package github.beeclimb.spot.admin.education.service.impl;

import github.beeclimb.spot.admin.education.entity.Subject;
import github.beeclimb.spot.admin.education.mapper.SubjectMapper;
import github.beeclimb.spot.admin.education.service.SubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author baomidou
 * @since 2022-06-28
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {

    @Override
    public void saveSubject(MultipartFile file) {


    }

}
