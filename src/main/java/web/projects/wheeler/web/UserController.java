package web.projects.wheeler.web;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import web.projects.wheeler.db.entities.UserModel;
import web.projects.wheeler.models.UserRegisterModel;
import web.projects.wheeler.service.UserService;

import java.net.URI;


@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserModel> register(@RequestBody UserRegisterModel newUser) {
        UserModel registered = null;

        try {
            registered=userService.register(newUser);
            return ResponseEntity.created(URI.create(String.format("/users/%d", registered.getId()))).body(registered);
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(registered);
        }

    }

}
