package mk.ukim.finki.seminarska.service.impl;

import mk.ukim.finki.seminarska.model.ApplicationUser;
import mk.ukim.finki.seminarska.model.DTOs.UserDTO;
import mk.ukim.finki.seminarska.model.exceptions.InvalidUserIdException;
import mk.ukim.finki.seminarska.model.exceptions.InvalidUsernameException;
import mk.ukim.finki.seminarska.repository.ApplicationUserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final ApplicationUserRepository applicationUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDetailsServiceImpl(ApplicationUserRepository applicationUserRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser applicationUser = applicationUserRepository.findByUsername(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(applicationUser.getUsername(), applicationUser.getPassword(), emptyList());
    }

    public ApplicationUser loadUser(String username) throws UsernameNotFoundException {
        ApplicationUser applicationUser = applicationUserRepository.findByUsername(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return applicationUser;
    }

    public ApplicationUser loadUserById(long userId){
        return this.applicationUserRepository.findById(userId).orElseThrow(InvalidUserIdException::new);
    }

    public void registerUser(UserDTO user){
        //user.setDeactivated(false);
        ApplicationUser userToSave = new ApplicationUser();
        userToSave.setUsername(user.getUsername());
        userToSave.setPassword(user.getPassword());
        userToSave.setUserDetails(new mk.ukim.finki.seminarska.model.UserDetails(user.getFirstName(), user.getLastName(), userToSave));
        applicationUserRepository.save(userToSave);
    }

    /*public void deactivateUser(long userId){
        ApplicationUser user = applicationUserRepository.findById(userId).orElseThrow(InvalidUserIdException::new);
        user.setDeactivated(true);
        applicationUserRepository.save(user);
    }*/

    public ApplicationUser AddFavourite(long userId, int movieId){
        ApplicationUser user = applicationUserRepository.findById(userId).orElseThrow(InvalidUserIdException::new);
        List<Integer> favourites = user.getFavoritesIds();
        if(!favourites.contains(movieId)){
            favourites.add(movieId);
        }
        else{
            favourites.remove(Integer.valueOf(movieId));
        }
        user.setFavoritesIds(favourites);
        return this.applicationUserRepository.save(user);
    }

    public Page<ApplicationUser> findAll(Pageable pageable){
        return applicationUserRepository.findAll(pageable);
    }

    public mk.ukim.finki.seminarska.model.UserDetails changeUserDetails(String username, String firstName, String lastName, String description){
        ApplicationUser user = applicationUserRepository.findByUsername(username);
        if(user == null){
            throw new InvalidUserIdException();
        }
        user.getUserDetails().setFirstName(firstName);
        user.getUserDetails().setLastName(lastName);
        user.getUserDetails().setDescription(description);
        return this.applicationUserRepository.save(user).getUserDetails();
    }

    public ResponseEntity<String> changePassword(String username, String oldPassword, String newPassword){
        ApplicationUser user = this.applicationUserRepository.findByUsername(username);
        if(user != null){
            if(checkCredentials(user, oldPassword)){
                user.setPassword(bCryptPasswordEncoder.encode(newPassword));
                this.applicationUserRepository.save(user);
                return new ResponseEntity<>("The password was changed!", HttpStatus.OK);
            }
            return new ResponseEntity<>("The password was not changed. Reason: invalid old password.", HttpStatus.METHOD_NOT_ALLOWED);
        }
        throw new InvalidUsernameException();
    }

    public boolean checkCredentials(ApplicationUser user, String password){
        return bCryptPasswordEncoder.matches(password, user.getPassword());
    }

    public boolean IsEmailAvailable(String email){
        return applicationUserRepository.findByUsername(email) != null;
    }

    public boolean isMovieWatched(String username, int movieId){
        ApplicationUser user = this.applicationUserRepository.findByUsername(username);
        if(user == null)
            throw new InvalidUsernameException();
        return user.getWatched().stream().anyMatch(m -> m.getId().getMovieId() == movieId);
    }



}
