package dio.spring_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.User;

public interface UserRepository extends JpaRepository<User, String> {
    @Query("SELECT e FROM User e JOIN FETCH e.roles WHERE e.username = (:username)")
    public User findByUsername(@Param("username") String username);
}
