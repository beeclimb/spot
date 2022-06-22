package github.beeclimb.spot.oss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import github.beeclimb.spot.oss.service.FileUploadService;
import github.beeclimb.spot.oss.util.PropertiesUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author jun.ma
 * @date 2022/6/22 22:17:00
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Override
    public String uploadFile(MultipartFile file) {
        // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
        String endpoint = PropertiesUtil.END_POINT;
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。
        String accessKeyId = PropertiesUtil.ACCESS_KEY_ID;
        String accessKeySecret = PropertiesUtil.ACCESS_KEY_SECRET;
        // 填写Bucket名称，例如examplebucket。
        String bucketName = PropertiesUtil.BUCKET_NAME;
        // 填写Object完整路径，例如exampledir/exampleobject.txt。Object完整路径中不能包含Bucket名称。
        String objectName = file.getOriginalFilename();


        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        String url = "";
        try {
            ossClient.putObject(bucketName, objectName, file.getInputStream());
            url = "https://" + bucketName + "." + endpoint + "/" + objectName;
        } catch (OSSException | IOException ioe) {
            throw new RuntimeException();
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return url;
    }

}
