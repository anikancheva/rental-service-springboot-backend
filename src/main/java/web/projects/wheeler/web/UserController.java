package web.projects.wheeler.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.projects.wheeler.models.UserLoginModel;
import web.projects.wheeler.models.UserRegisterModel;
import web.projects.wheeler.service.UserService;

@RestController
@RequestMapping("/")
@CrossOrigin
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody UserLoginModel user) {
        //if successful
        //ResponseEntity.status(200).body("OK");
        //else unauthorized
        return null;
    }

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody UserRegisterModel user) {
        //if successful
        //ResponseEntity.status(201).body("Created");
        //else unauthorized
        return null;
    }
}
