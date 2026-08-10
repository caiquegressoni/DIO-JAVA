package dio.spring_security.repository;

import dio.spring_security.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.User;

public interface UserRepository extends JpaRepository<UserModel, String> {
    @Query("SELECT e FROM User e JOIN FETCH e.roles WHERE e.username = (:username)")
    public UserModel findByUsername(@Param("username") String username);
}
