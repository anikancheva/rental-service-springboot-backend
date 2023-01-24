package web.projects.wheeler.web;

import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.web.bind.annotation.*;

import web.projects.wheeler.service.UserService;


@RestController
public class UserController {

    private final UserService userService;
    private final AuthenticationProvider authenticationProvider;

    public UserController(UserService userService, AuthenticationProvider authenticationProvider) {
        this.userService = userService;
        this.authenticationProvider = authenticationProvider;
    }

    @GetMapping("/home")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Hello");
    }



}
