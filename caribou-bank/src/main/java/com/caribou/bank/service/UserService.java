package com.caribou.bank.service;

import com.caribou.bank.domain.User;
import com.caribou.bank.repository.UserRepository;
import com.caribou.bank.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService implements IUserService{


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerNewUserAccount(final UserDTO accountDto) {
       /* if (emailExists(accountDto.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email address: " + accountDto.getEmail());
        }*/
        final User user = new User();

//        user.setFirstName(accountDto.getFirstName());
        user.setUsername(accountDto.getUsername());
        user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
//        user.setEmail(accountDto.getEmail());
//        user.setUsing2FA(accountDto.isUsing2FA());
//        user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));
        user.setRole(("ROLE_USER"));
        return userRepository.save(user);
    }

}
