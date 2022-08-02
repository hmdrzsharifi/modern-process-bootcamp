//package com.caribou.bank.web.rest;
//
//import com.caribou.bank.domain.User;
//import com.caribou.bank.repository.UserRepository;
//import com.caribou.bank.service.IUserService;
//import com.caribou.bank.service.UserService;
//import com.caribou.bank.service.dto.UserDTO;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//
///**
// * REST controller for managing the current user's account.
// */
//@RestController
//@RequestMapping("/api")
//public class AccountResource {
//
//    private final Logger log = LoggerFactory.getLogger(AccountResource.class);
//
//    private final UserRepository userRepository;
//
//    private final IUserService userService;
//
//    public AccountResource(UserRepository userRepository, IUserService userService) {
//        this.userRepository = userRepository;
//        this.userService = userService;
//    }
//
//
//    @PostMapping("/register")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void registerAccount(@Valid @RequestBody UserDTO userDTO) {
//       /* if (isPasswordLengthInvalid(managedUserVM.getPassword())) {
//            throw new InvalidPasswordException();
//        }*/
//        User user = userService.registerNewUserAccount(userDTO);
////        mailService.sendActivationEmail(user);
//    }
//}
