package github.beeclimb.spot.admin.education.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import github.beeclimb.spot.admin.education.entity.Subject;
import github.beeclimb.spot.admin.education.entity.excel.SubjectData;
import github.beeclimb.spot.admin.education.listener.SubjectExcelListener;
import github.beeclimb.spot.admin.education.mapper.SubjectMapper;
import github.beeclimb.spot.admin.education.service.SubjectService;
import github.beeclimb.spot.admin.education.vo.FirstSubjectVo;
import github.beeclimb.spot.admin.education.vo.SecondSubjectVo;
import github.beeclimb.spot.common.util.api.ResponseCodeEnum;
import github.beeclimb.spot.common.util.exception.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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
            throw new ApiException(ResponseCodeEnum.FAILED);
        }
    }

    @Override
    public List<FirstSubjectVo> getAllSubjects() {
        QueryWrapper<Subject> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("parent_id", "0");
        List<Subject> allFirstSubjects = baseMapper.selectList(wrapper1);

        QueryWrapper<Subject> wrapper2 = new QueryWrapper<>();
        wrapper2.ne("parent_id", "0");
        List<Subject> allSecondSubjects = baseMapper.selectList(wrapper2);

        List<FirstSubjectVo> firstSubjectsList = new LinkedList<>();

        for (Subject firstSubject : allFirstSubjects) {
            FirstSubjectVo firstSubjectVo = new FirstSubjectVo();
            BeanUtils.copyProperties(firstSubject, firstSubjectVo);
            firstSubjectsList.add(firstSubjectVo);

            Iterator<Subject> subjectIterator = allSecondSubjects.iterator();
            List<SecondSubjectVo> secondSubjectsList = new LinkedList<>();

            while (subjectIterator.hasNext()) {
                Subject secondSubject = subjectIterator.next();
                if (secondSubject.getParentId().equals(firstSubject.getId())) {
                    SecondSubjectVo secondSubjectVo = new SecondSubjectVo();
                    BeanUtils.copyProperties(secondSubject, secondSubjectVo);
                    secondSubjectsList.add(secondSubjectVo);
                    subjectIterator.remove();
                }
            }
            firstSubjectVo.setSecondSubjectList(secondSubjectsList);
        }
        return firstSubjectsList;
    }

}
