package github.beeclimb.spot.admin.education.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import github.beeclimb.spot.admin.education.entity.Subject;
import github.beeclimb.spot.admin.education.entity.excel.SubjectData;
import github.beeclimb.spot.admin.education.listener.SubjectExcelListener;
import github.beeclimb.spot.admin.education.mapper.SubjectMapper;
import github.beeclimb.spot.admin.education.service.SubjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author baomidou
 * @since 2022-06-28
 */
@Service
@Slf4j
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {

    @Override
    public void saveSubject(MultipartFile file, SubjectService subjectService) {
        try {
            EasyExcel.read(file.getInputStream(), SubjectData.class,
                    new SubjectExcelListener(subjectService)).sheet().doRead();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

}
