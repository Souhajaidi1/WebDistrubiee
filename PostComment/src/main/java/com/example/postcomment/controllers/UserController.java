package com.example.postcomment.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.postcomment.entities.User;
import com.example.postcomment.interfaces.IUserService;
import com.example.postcomment.repositories.UserRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService userService;
     UserRepository userRepository;

    @PostMapping("/addUser")


    public User add(@RequestBody User user) {
        return userService.saveUser(user);
    }


    @PostMapping("updateUser/{userID}")
    @ResponseBody
    User updateUser(@RequestBody User user,@PathVariable Long userID){
        return userService.updateUser(user, userID);
    }

    @GetMapping("/getRole")
    @ResponseBody
    public List<User> findAll() {
        return userService.getAllUsers();
    }


    @DeleteMapping("/delete/{userID}")
    public void deleteUserById(@PathVariable Long userID) {
        userService.deleteUser(userID);

    }
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, User user) {
        // get error status
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return "error-404";
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "error-500";
            }
        }

        return "error";
    }
    
}

