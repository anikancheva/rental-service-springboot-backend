package web.projects.wheeler.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import web.projects.wheeler.config.auth.UserAlreadyExistsException;
import web.projects.wheeler.db.Role;
import web.projects.wheeler.db.RoleType;
import web.projects.wheeler.db.entities.UserModel;
import web.projects.wheeler.db.repositories.RoleRepository;
import web.projects.wheeler.db.repositories.UserRepository;
import web.projects.wheeler.models.UserRegisterModel;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public UserModel getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    public UserModel register(UserRegisterModel userRegisterModel) {
        if (userRepository.findByUsername(userRegisterModel.getUsername()).isPresent()
                || userRepository.findByEmail(userRegisterModel.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException();
        }

        PasswordEncoder encoder = new BCryptPasswordEncoder();
        UserModel user = new UserModel(userRegisterModel.getUsername(), userRegisterModel.getFirstName(),
                userRegisterModel.getLastName(), userRegisterModel.getEmail(), encoder.encode(userRegisterModel.getPassword()), userRegisterModel.getPhoneNo());
        Role role = roleRepository.getRoleByRole(RoleType.USER);
        user.getAuthorities().add(role);

        return userRepository.save(user);
    }


}
