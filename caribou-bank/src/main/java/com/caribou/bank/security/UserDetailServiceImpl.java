//package com.caribou.bank.security;
//
//import com.caribou.bank.domain.User;
//import com.caribou.bank.repository.UserRepository;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserDetailServiceImpl implements UserDetailsService {
//
//    private final UserRepository repository;
//
//    public UserDetailServiceImpl(UserRepository repository) {
//        this.repository = repository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User currentUser = repository.findByUsername(username);
//        if (currentUser == null) {
//            throw new UsernameNotFoundException(username);
//        }
//        UserDetails user = new org.springframework.security.core.userdetails.User(username, currentUser.getPassword()
//                , true, true, true, true, AuthorityUtils.createAuthorityList(currentUser.getRole()));
//        return user;
//    }
//}
