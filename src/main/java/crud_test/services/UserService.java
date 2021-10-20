package crud_test.services;

import crud_test.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    void addOrUpdate(User user);
    void remove(Long id);
   // void update(User user);
    List<User> getUsers();
}
