package github.beeclimb.spot.admin.education.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import github.beeclimb.spot.admin.education.entity.Subject;
import github.beeclimb.spot.admin.education.entity.excel.SubjectData;
import github.beeclimb.spot.admin.education.service.SubjectService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author jun.ma
 * @date 2022/7/2 12:43:00
 */
@Slf4j
public class SubjectExcelListener extends AnalysisEventListener<SubjectData> {
    public SubjectService subjectService;

    public SubjectExcelListener() {
    }

    public SubjectExcelListener(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @Override
    public void invoke(SubjectData subjectData, AnalysisContext analysisContext) {
        Subject oneSubject = this.existOneLevelSubject(subjectService, subjectData.getOneLevelSubject());
        if (oneSubject == null) {
            oneSubject = new Subject();
            oneSubject.setParentId("0");
            oneSubject.setTitle(subjectData.getOneLevelSubject());
            subjectService.save(oneSubject);
        }

        String pid = oneSubject.getId();
        Subject twoSubject = this.existTwoLevelSubject(subjectService, subjectData.getTwoLevelSubject(), pid);
        if (twoSubject == null) {
            twoSubject = new Subject();
            twoSubject.setParentId(pid);
            twoSubject.setTitle(subjectData.getTwoLevelSubject());
            subjectService.save(twoSubject);
        }
    }

    private Subject existOneLevelSubject(SubjectService subjectService, String title) {
        QueryWrapper<Subject> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id", "0").eq("title", title);
        return subjectService.getOne(wrapper);
    }

    private Subject existTwoLevelSubject(SubjectService subjectService, String title, String parentId) {
        QueryWrapper<Subject> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id", parentId).eq("title", title);
        return subjectService.getOne(wrapper);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("read finished");
    }
}
