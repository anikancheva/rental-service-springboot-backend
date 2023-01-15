package web.projects.wheeler.service;

import org.springframework.stereotype.Service;
import web.projects.wheeler.db.entities.User;
import web.projects.wheeler.db.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }
}
