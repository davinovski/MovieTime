package mk.ukim.finki.seminarska.repository;

import mk.ukim.finki.seminarska.model.ApplicationUser;
import mk.ukim.finki.seminarska.model.DTOs.UserInTable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findByUsername(String username);

    /*@Query("select distinct u from ApplicationUser u where lower(u.userDetails.firstName) like lower(concat('%',:searchTerm,'%')) or lower(u.userDetails.lastName) like lower(concat('%',:searchTerm,'%'))")
    Page<ApplicationUser> getAllUsers(Pageable pageable, String searchTerm);*/

    @Query("select new mk.ukim.finki.seminarska.model.DTOs.UserInTable(u.id, u.username, u.userDetails.firstName, u.userDetails.lastName, u.admin) from ApplicationUser u")
    Page<UserInTable> getAllUsers(Pageable pageable, String searchTerm);
}
