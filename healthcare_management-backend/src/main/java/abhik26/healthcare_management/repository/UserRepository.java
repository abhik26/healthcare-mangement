package abhik26.healthcare_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import abhik26.healthcare_management.entity.User;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
 
        List<User> findByEmail(String email);
}
