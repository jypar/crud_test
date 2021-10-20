package crud_test.services;

import crud_test.entities.Role;
import crud_test.entities.User;
import crud_test.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = NONE)
class UserServiceImplTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void addOrUpdate() {
        Set<Role> roles =  new HashSet<>();
        roles.add(new Role("ROLE_ADMIN"));
        User user = new User();
        user.setUsername("test_user");
        user.setPassword("1234");
        user.setDate_of_birth("2021-10-14");
        user.setEmail("test@mail.ru");
        user.setRoles(roles);
        userRepository.save(user);
    }
}