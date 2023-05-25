package com.creche.crecheapp.auth;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean authenticate(User user, String password) {
        return user.getPassword().equals(password);
    }

    public void signup(User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null) {
            throw new IllegalArgumentException("Username already exists");
        }
        userRepository.save(user);
    }
    public String getUserRoleByEmail(String email) {
        User user = userRepository.findByUsername(email);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        return user.getRole();
    }
/*    public void initializeUsersWithRoles() {
        User admin = new User("admin", "admin", new HashSet<>(Arrays.asList("ROLE_ADMIN")));
        User educator = new User("educator", "educator", new HashSet<>(Arrays.asList("ROLE_EDUCATOR")));
        User parent = new User("parent", "parent", new HashSet<>(Arrays.asList("ROLE_PARENT")));

        createUser(admin);
        createUser(educator);
        createUser(parent);
    }  */
}
