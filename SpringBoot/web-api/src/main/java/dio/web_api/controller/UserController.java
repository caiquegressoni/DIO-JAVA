package dio.web_api.controller;

import dio.web_api.model.User;
import dio.web_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users") //O RequestMapping server para deixar como padrão um prefixo, neste caso o "/users"
public class UserController {
    @Autowired
    private UserRepository repository;
    @GetMapping()
    public List<User> getUsers(){
        return repository.findAll();
    }
    @GetMapping("/{username}")
    public User getOne(@PathVariable("username") String username){
        return repository.findByName(username);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        repository.deleteById(id);
    }
    @PostMapping()
    public void postUser(@RequestBody User user){
        repository.save(user);
    }
}
