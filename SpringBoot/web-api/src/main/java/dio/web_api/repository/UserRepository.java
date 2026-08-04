package dio.web_api.repository;

import dio.web_api.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    public void save(User user){
        if(user.getId()==null){
            System.out.println("SAVE");
        }else{
            System.out.println("UPDATE");
        }
        System.out.println(user);
    }
    public void deleteById(Integer id){
        System.out.println(String.format("DELETE %s", id));
        System.out.println(id);
    }
    public List<User> findAll(){
        System.out.println("LIST ALL USERS");
        List<User> users = new ArrayList<>();
        users.add(new User("John","passW"));
        users.add(new User("Jane","anotherPassW"));
        return users;
    }
    public User findById(Integer id){
        System.out.println(String.format("FIND %s", id));
        return new User("John","passW");
    }
    public User findByName(String name){
        System.out.println(String.format("FIND %s", name));
        return new User("John","passW");
    }
}
