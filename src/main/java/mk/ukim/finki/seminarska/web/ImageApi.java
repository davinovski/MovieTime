package mk.ukim.finki.seminarska.web;

import mk.ukim.finki.seminarska.model.ApplicationUser;
import mk.ukim.finki.seminarska.model.UserDetails;
import mk.ukim.finki.seminarska.service.ImageService;
import mk.ukim.finki.seminarska.service.impl.UserDetailsServiceImpl;
import org.apache.commons.io.IOUtils;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path="/api/images")
public class ImageApi {
    public final ImageService imageService;
    public final UserDetailsServiceImpl userDetailsService;

    public ImageApi(ImageService imageService, UserDetailsServiceImpl userDetailsService) {
        this.imageService = imageService;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/image")
    public String handleImagePost(@AuthenticationPrincipal String username, @RequestParam("image") MultipartFile file){

        imageService.saveImageFile(username, file);

        return "redirect:/api/images/user/" + username + "/show";
    }

    @Transactional
    @GetMapping("/user/{username}/show")
    public void renderImageFromDB(@PathVariable String username, HttpServletResponse response) throws IOException {
        ApplicationUser user = userDetailsService.loadUser(username);

        if (user.getUserDetails().getProfilePicture()!= null) {
            byte[] byteArray = new byte[user.getUserDetails().getProfilePicture().length];
            int i = 0;

            for (Byte wrappedByte : user.getUserDetails().getProfilePicture()){
                byteArray[i++] = wrappedByte; //auto unboxing
            }

            response.setContentType("image/jpeg");
            InputStream is = new ByteArrayInputStream(byteArray);
            IOUtils.copy(is, response.getOutputStream());
        }
    }

    /*@Transactional
    @GetMapping("/user/{username}/image")
    public UserDetails getUserDetails(@PathVariable String username) throws IOException {
        ApplicationUser user = userDetailsService.loadUser(username);

        if (user.getUserDetails().getProfilePicture()!= null) {
            byte[] byteArray = new byte[user.getUserDetails().getProfilePicture().length];
            int i = 0;

            for (Byte wrappedByte : user.getUserDetails().getProfilePicture()){
                byteArray[i++] = wrappedByte; //auto unboxing
            }

            InputStream is = new ByteArrayInputStream(byteArray);
            IOUtils.copy(is, user.getUserDetails().getProfilePicture());
        return user.getUserDetails();
        }*/






}
