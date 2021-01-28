package mk.ukim.finki.seminarska.service.impl;

import mk.ukim.finki.seminarska.model.ApplicationUser;
import mk.ukim.finki.seminarska.repository.ApplicationUserRepository;
import mk.ukim.finki.seminarska.service.ImageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
public class ImageServiceImpl implements ImageService {
    private final ApplicationUserRepository applicationUserRepository;

    public ImageServiceImpl(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    @Transactional
    public void saveImageFile(String username, MultipartFile file) {

        try {
            ApplicationUser user = applicationUserRepository.findByUsername(username);

            byte[] byteObjects = new byte[file.getBytes().length];

            int i = 0;

            for (byte b : file.getBytes()){
                byteObjects[i++] = b;
            }

            user.getUserDetails().setProfilePicture(byteObjects);

            applicationUserRepository.save(user);
        } catch (Exception e) {
            //todo handle better

            e.printStackTrace();
        }
    }
}
