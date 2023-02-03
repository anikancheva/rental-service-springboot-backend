package web.projects.wheeler.web;

import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import web.projects.wheeler.config.auth.JwtUtil;
import web.projects.wheeler.db.entities.UserModel;
import web.projects.wheeler.models.UserLoginModel;
import web.projects.wheeler.models.UserRegisterModel;
import web.projects.wheeler.service.UserService;

import java.net.URI;


@RestController
@CrossOrigin
public class UserController {

    private final UserService userService;
    private final JwtUtil jwt;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    public UserController(UserService userService, JwtUtil jwt, AuthenticationManager authenticationManager, UserDetailsService userDetailsService) {
        this.userService = userService;
        this.jwt = jwt;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginModel userLoginModel) {
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(userLoginModel.getUsername(), userLoginModel.getPassword()));
        } catch (BadCredentialsException e) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().body(jwt.generateToken(userDetailsService.loadUserByUsername(userLoginModel.getUsername())));

    }

    @PostMapping("/register")
    public ResponseEntity<UserModel> register(@RequestBody UserRegisterModel newUser) {
        UserModel registered;

        try {
            registered = userService.register(newUser);
            return ResponseEntity.created(URI.create(String.format("/users/%d", registered.getId()))).body(registered);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }

    }
}
