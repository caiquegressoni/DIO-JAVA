package dio.spring_security.init;

import dio.spring_security.model.UserModel;
import dio.spring_security.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartApplication implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public void run(String @NonNull ... args) throws Exception {
        UserModel user = userRepository.findByUsername("admin");
        if(user==null){
            user = new UserModel();
            user.setName("ADMIN");
            user.setUsername("admin");
            user.setPassword("master@123");
            user.getRoles().add("MANAGER");
            userRepository.save(user);
        }
        user = userRepository.findByUsername("user");
        if(user==null){
            user = new UserModel();
            user.setName("USER");
            user.setUsername("user");
            user.setPassword("user@123");
            userRepository.save(user);
        }
    }
}
