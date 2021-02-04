package mk.ukim.finki.seminarska.web;

import mk.ukim.finki.seminarska.model.ApplicationUser;
import mk.ukim.finki.seminarska.model.DTOs.UserDTO;
import mk.ukim.finki.seminarska.model.DTOs.UserInTable;
import mk.ukim.finki.seminarska.model.Movie;
import mk.ukim.finki.seminarska.model.UserDetails;
import mk.ukim.finki.seminarska.model.exceptions.NotEnoughPermissions;
import mk.ukim.finki.seminarska.repository.ApplicationUserRepository;
import mk.ukim.finki.seminarska.service.MovieUserService;
import mk.ukim.finki.seminarska.service.impl.UserDetailsServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/users")
public class UserController {

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserDetailsServiceImpl userDetailsService;
    private final MovieUserService movieUserService;

    public UserController(BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailsServiceImpl userDetailsService, MovieUserService movieUserService) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userDetailsService = userDetailsService;
        this.movieUserService = movieUserService;
    }

    @PostMapping("/register")
    public void signUp(@RequestBody UserDTO user) {

        if (!IsEmailAvailable(user.getUsername()))
        {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userDetailsService.registerUser(user);
        }
    }
    /*
    @PostMapping("/deactivate/{userId}")
    public void deactivate(@PathVariable long userId){
        userDetailsService.deactivateUser(userId);
    }*/

    @PostMapping("/changePassword")
    public ResponseEntity<String> changePassword(@AuthenticationPrincipal String username,
                                         @RequestParam("oldPassword") String oldPassword,
                                        @RequestParam("newPassword") String newPassword)
    {
        return this.userDetailsService.changePassword(username, oldPassword, newPassword);
    }
    @GetMapping("/{email}")
    public ApplicationUser getUser(@PathVariable String email)
    {
        return userDetailsService.loadUser(email);
    }

    private boolean IsEmailAvailable(String email)
    {
        return this.userDetailsService.IsEmailAvailable(email);
    }

    @GetMapping("/paged")
    public Page<UserInTable> getAllUsers(@RequestParam("pageSize") int pageSize,
                                         @RequestParam("pageNumber") int pageNumber,
                                         @RequestParam(value = "searchTerm", required = false, defaultValue = "") String searchTerm){
        return userDetailsService.findAll(PageRequest.of(pageNumber-1,pageSize, Sort.by("username")), searchTerm);
    }

    @PostMapping("/{userId}/favourites/{movieId}")
    public ApplicationUser addNewFavourite(@PathVariable("userId") long userId,
                                           @PathVariable("movieId") int movieId){
        ApplicationUser app = userDetailsService.AddFavourite(userId,movieId);
        return app;
    }

    @PostMapping("/watched/{movieId}")
    public boolean addNewWatched(@AuthenticationPrincipal String username,
                                @PathVariable("movieId") int movieId){

        return movieUserService.AddWatched(username, movieId);
    }

    @PostMapping("/changeDetails")
    public UserDetails changeUserDetails(@AuthenticationPrincipal String username,
                                        @RequestParam("firstName") String firstName,
                                        @RequestParam("lastName") String lastName,
                                         @RequestParam("description") String description){
        return this.userDetailsService.changeUserDetails(username, firstName, lastName, description);
    }

    @GetMapping("/{movieId}/isWatched")
    public boolean isWatched(@AuthenticationPrincipal String username, @PathVariable int movieId){
        return this.userDetailsService.isMovieWatched(username, movieId);
    }
    @GetMapping("/isAdmin")
    public boolean isAdmin(@AuthenticationPrincipal String username) {
        return userDetailsService.loadUser(username).isAdmin();
    }

    @PostMapping("/{userId}/promote")
    public ApplicationUser promoteUser(@AuthenticationPrincipal String username,
                               @PathVariable long userId) {
        if(this.isAdmin(username)){
            return this.userDetailsService.promoteUser(userId);
        }
        else throw new NotEnoughPermissions();
    }
}
