package web.projects.wheeler.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import web.projects.wheeler.config.auth.UserAlreadyExistsException;
import web.projects.wheeler.db.entities.UserModel;
import web.projects.wheeler.db.repositories.UserRepository;
import web.projects.wheeler.models.UserRegisterModel;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    public UserModel register(UserRegisterModel userRegisterModel) {
        if (userRepository.findByUsername(userRegisterModel.getUsername()).isPresent()
                || userRepository.findByEmail(userRegisterModel.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException();
        }

        PasswordEncoder encoder=new BCryptPasswordEncoder();
        UserModel user= new UserModel(userRegisterModel.getUsername(), userRegisterModel.getFirstName(),
                userRegisterModel.getLastName(), userRegisterModel.getEmail(), encoder.encode(userRegisterModel.getPassword()), userRegisterModel.getPhoneNo());
        return userRepository.save(user);
    }


}
