package github.beeclimb.spot.oss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Jun Ma
 * @date 2022/6/22 22:16:00
 */
public interface FileUploadService {

    String uploadFile(MultipartFile file);

}
