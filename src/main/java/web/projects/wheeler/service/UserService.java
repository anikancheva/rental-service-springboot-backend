package web.projects.wheeler.service;

import org.springframework.stereotype.Service;
import web.projects.wheeler.db.entities.UserModel;
import web.projects.wheeler.db.repositories.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel getUserByUsername(String username){
        return userRepository.findByUsername(username).orElse(null);
    }
}
