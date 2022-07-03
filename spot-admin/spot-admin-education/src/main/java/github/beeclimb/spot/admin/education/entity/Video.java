package github.beeclimb.spot.admin.education.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 课程视频
 * </p>
 *
 * @author baomidou
 * @since 2022-07-03
 */
@TableName("edu_video")
@ApiModel(value = "Video对象", description = "课程视频")
public class Video implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("视频ID")
    private String id;

    @ApiModelProperty("课程ID")
    private String courseId;

    @ApiModelProperty("章节ID")
    private String chapterId;

    @ApiModelProperty("节点名称")
    private String title;

    @ApiModelProperty("云端视频资源")
    private String videoSourceId;

    @ApiModelProperty("原始文件名称")
    private String videoOriginalName;

    @ApiModelProperty("排序字段")
    private Integer sort;

    @ApiModelProperty("播放次数")
    private Long playCount;

    @ApiModelProperty("是否可以试听：0收费 1免费")
    private Integer isFree;

    @ApiModelProperty("视频时长（秒）")
    private Float duration;

    @ApiModelProperty("Empty未上传 Transcoding转码中  Normal正常")
    private String status;

    @ApiModelProperty("视频源文件大小（字节）")
    private Long size;

    @ApiModelProperty("乐观锁")
    private Long version;

    @ApiModelProperty("创建时间")
    private Date gmtCreate;

    @ApiModelProperty("更新时间")
    private Date gmtModified;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getChapterId() {
        return chapterId;
    }

    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideoSourceId() {
        return videoSourceId;
    }

    public void setVideoSourceId(String videoSourceId) {
        this.videoSourceId = videoSourceId;
    }

    public String getVideoOriginalName() {
        return videoOriginalName;
    }

    public void setVideoOriginalName(String videoOriginalName) {
        this.videoOriginalName = videoOriginalName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Long getPlayCount() {
        return playCount;
    }

    public void setPlayCount(Long playCount) {
        this.playCount = playCount;
    }

    public Integer getIsFree() {
        return isFree;
    }

    public void setIsFree(Integer isFree) {
        this.isFree = isFree;
    }

    public Float getDuration() {
        return duration;
    }

    public void setDuration(Float duration) {
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return "Video{" +
        "id=" + id +
        ", courseId=" + courseId +
        ", chapterId=" + chapterId +
        ", title=" + title +
        ", videoSourceId=" + videoSourceId +
        ", videoOriginalName=" + videoOriginalName +
        ", sort=" + sort +
        ", playCount=" + playCount +
        ", isFree=" + isFree +
        ", duration=" + duration +
        ", status=" + status +
        ", size=" + size +
        ", version=" + version +
        ", gmtCreate=" + gmtCreate +
        ", gmtModified=" + gmtModified +
        "}";
    }
}
