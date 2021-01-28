package mk.ukim.finki.seminarska.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    void saveImageFile(String username, MultipartFile file);

}
