package com.caribou.bank.service;

import com.caribou.bank.domain.User;
import com.caribou.bank.service.dto.UserDTO;

public interface IUserService {

    User registerNewUserAccount(UserDTO accountDto);
}
