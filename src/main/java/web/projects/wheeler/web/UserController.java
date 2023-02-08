package web.projects.wheeler.web;

import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import web.projects.wheeler.config.auth.JwtUtil;
import web.projects.wheeler.models.UserLoginModel;
import web.projects.wheeler.models.UserRegisterModel;
import web.projects.wheeler.service.UserService;



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
            return ResponseEntity.badRequest().body("Exception from spring login");
        }

        return ResponseEntity.ok().body(jwt.generateToken(userDetailsService.loadUserByUsername(userLoginModel.getUsername())));

    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserRegisterModel newUser) {

        try {
            userService.register(newUser);
            UserLoginModel loginModel = new UserLoginModel().setUsername(newUser.getUsername()).setPassword(newUser.getPassword());
            return login(loginModel);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Spring exception: " + e.getMessage());
        }

    }
}
