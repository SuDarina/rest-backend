package com.example.restbackend.controller;
import com.example.restbackend.dao.UserDao;
import com.example.restbackend.model.User;
import com.example.restbackend.payload.JwtResponse;
import com.example.restbackend.payload.SignIn;
import com.example.restbackend.payload.SignUp;
import com.example.restbackend.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserDao userDao;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody SignIn signIn) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signIn.getUsername(), signIn.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        User user = (User) authentication.getPrincipal();

        return ResponseEntity.ok(new JwtResponse(jwt, user.getName()));
    }
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUp signUp) {
        if (userDao.findByName(signUp.getUsername())==null) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Username is already taken!");
        }
        User user = new User();
        user.setName(signUp.getUsername());
        user.setPassword(encoder.encode(signUp.getPassword()));
        userDao.save(user);

        return ResponseEntity.ok("User " + signUp.getUsername() + " registered!");
    }
}
