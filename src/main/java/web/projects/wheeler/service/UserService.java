package web.projects.wheeler.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import web.projects.wheeler.db.auth.UserAlreadyExistsException;
import web.projects.wheeler.db.entities.UserModel;
import web.projects.wheeler.db.repositories.UserRepository;
import web.projects.wheeler.models.UserRegisterModel;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public UserModel getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    public UserModel register(UserRegisterModel userRegisterModel) {
        if (userRepository.findByUsername(userRegisterModel.getUsername()).isPresent()
                || userRepository.findByEmail(userRegisterModel.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException();
        }

        UserModel user=modelMapper.map(userRegisterModel, UserModel.class);
        return userRepository.save(user);
    }

}
