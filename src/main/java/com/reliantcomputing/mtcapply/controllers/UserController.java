package com.reliantcomputing.mtcapply.controllers;

import com.reliantcomputing.mtcapply.controllers.dto.UserDto;
import com.reliantcomputing.mtcapply.models.auth.User;
import com.reliantcomputing.mtcapply.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("applicant/register")
    public User registerApplicant(@RequestBody final UserDto userDto){
        return userService.addApplicant(userDto);
    }
}
