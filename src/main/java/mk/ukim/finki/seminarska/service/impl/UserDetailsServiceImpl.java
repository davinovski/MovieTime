package mk.ukim.finki.seminarska.service.impl;

import mk.ukim.finki.seminarska.model.ApplicationUser;
import mk.ukim.finki.seminarska.model.exceptions.InvalidUserIdException;
import mk.ukim.finki.seminarska.repository.ApplicationUserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.List;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private ApplicationUserRepository applicationUserRepository;

    public UserDetailsServiceImpl(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
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
}
