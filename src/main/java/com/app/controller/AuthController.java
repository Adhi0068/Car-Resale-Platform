package com.app.controller;

import com.app.entity.User;
import com.app.payload.JWTTokenDto;
import com.app.payload.LoginDto;
import com.app.repository.UserRepository;
import com.app.service.JWTService;
import com.app.service.OTPService;
import com.app.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private UserRepository userRepository;
    private UserService userService;
    private OTPService otpService;
    private JWTService jwtService;

//        // 1st approach : to encrypt
    private PasswordEncoder passwordEncoder;

    public AuthController(
            UserRepository userRepository, UserService userService, OTPService otpService, JWTService jwtService,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.otpService = otpService;
        this.jwtService = jwtService;
    }


    @PostMapping("/signup")
    public ResponseEntity<?> createUser(
            @RequestBody User user
    ){
        // checks wheather the useranme and emailid already exits or not
        // if not existed, it will create them.
        Optional<User> opUsername = userRepository.findByUsername(user.getUsername());
        if(opUsername.isPresent()){
            return new ResponseEntity<>("Username already exist", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        Optional<User> opEmail = userRepository.findByEmailId(user.getEmailId());
        if(opEmail .isPresent()){
            return new ResponseEntity<>("emailId already exist", HttpStatus.INTERNAL_SERVER_ERROR);
        }
//        // 1st approach : to encrypt
//        // This will encrypt the password
//        String encodedPassword = passwordEncoder.encode(user.getPassword());
//        user.setPassword(encodedPassword);

//        // 2nd approach : to encrypt (where we can set the level of password encryption)
        String hashpw = BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(10));
        user.setPassword(hashpw);
        user.setRole("ROLE_USER");

        userRepository.save(user);
        return new ResponseEntity<>("User created", HttpStatus.CREATED);
    }


    @PostMapping("/content-manager-signup")
    public ResponseEntity<?> createContentManagerUser(
            @RequestBody User user
    ){
        Optional<User> opUsername = userRepository.findByUsername(user.getUsername());
        if(opUsername.isPresent()){
            return new ResponseEntity<>("Username already exist", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        Optional<User> opEmail = userRepository.findByEmailId(user.getEmailId());
        if(opEmail .isPresent()){
            return new ResponseEntity<>("emailId already exist", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        String hashpw = BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(10));
        user.setPassword(hashpw);
        user.setRole("ROLE_CONTENTMANAGER");
        userRepository.save(user);
        return new ResponseEntity<>("User created", HttpStatus.CREATED);
    }

    @PostMapping("/blog-manager-signup")
    public ResponseEntity<?> createBlogManagerUser(
            @RequestBody User user
    ){
        Optional<User> opUsername = userRepository.findByUsername(user.getUsername());
        if(opUsername.isPresent()){
            return new ResponseEntity<>("Username already exist", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        Optional<User> opEmail = userRepository.findByEmailId(user.getEmailId());
        if(opEmail .isPresent()){
            return new ResponseEntity<>("emailId already exist", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        String hashpw = BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(10));
        user.setPassword(hashpw);
        user.setRole("ROLE_BLOGMANAGER");
        userRepository.save(user);
        return new ResponseEntity<>("User created", HttpStatus.CREATED);
    }



    @PostMapping("/usersignin")
    public ResponseEntity<?> userSignIn(
            @RequestBody LoginDto dto
    ){
        String jwtToken = userService.verifyLogin(dto);
        if(jwtToken!=null){
            JWTTokenDto tokenDto = new JWTTokenDto();
            tokenDto.setToken(jwtToken);
            tokenDto.setTokenType("JWT");
            return new ResponseEntity<>(tokenDto, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Invalid Token", HttpStatus.INTERNAL_SERVER_ERROR);
    }


  @PostMapping("/login-with-otp")
    public String generateOTP(
            @RequestParam String mobile
  ){

      Optional<User> opUser = userRepository.findByMobile(mobile);
      if(opUser.isPresent()){
          String otp = otpService.generateOTP(mobile);
          return " Mobile: "+ mobile
                  +" OTP: "+otp ;

      }
      return "User not found" +
              "Need to SignUp first";
    }

    @PostMapping("/validate-otp")
    public String validateOTP(
            @RequestParam String mobile,
            @RequestParam String otp
    ){
        boolean status = otpService.validateOTP(mobile, otp);
        if (status){
            //generate JWT Token
            Optional<User> opUser = userRepository.findByMobile(mobile);
            if(opUser.isPresent()){
                String jwtToken = jwtService.generateToken(opUser.get().getUsername());
                return "JWT Token: "+ jwtToken;
            }

        }
        return status? "OTP validated Successfully" : "Invalid OTP";
    }


}

















