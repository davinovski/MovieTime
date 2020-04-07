package mk.ukim.finki.seminarska.web;

import mk.ukim.finki.seminarska.model.ApplicationUser;
import mk.ukim.finki.seminarska.repository.ApplicationUserRepository;
import mk.ukim.finki.seminarska.service.impl.UserDetailsServiceImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/users")
public class UserController {

    private ApplicationUserRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserDetailsServiceImpl userDetailsService;

    public UserController(ApplicationUserRepository applicationUserRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailsServiceImpl userDetailsService) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/register")
    public void signUp(@RequestBody ApplicationUser user) {

        if (!IsEmailAvailable(user.getUsername()))
        {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            applicationUserRepository.save(user);
        }
    }

    @GetMapping("/{email}")
    public ApplicationUser getUser(@PathVariable String email)
    {
        return userDetailsService.loadUser(email);
    }

    private boolean IsEmailAvailable(String email)
    {
        return applicationUserRepository.findByUsername(email) != null;
    }
}
