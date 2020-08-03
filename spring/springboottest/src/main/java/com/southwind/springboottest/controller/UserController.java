package com.southwind.springboottest.controller;

import com.southwind.springboottest.entity.DataModel;
import com.southwind.springboottest.entity.Govern;
import com.southwind.springboottest.entity.Result;
import com.southwind.springboottest.entity.User;
import com.southwind.springboottest.repository.UserRepository;
import com.southwind.springboottest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")

public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/findAll/{page}/{size}/{createBy}")
    public Page<User> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size, @PathVariable("createBy") String createBy){
        PageRequest request = PageRequest.of(page,size);
        Page<User> userPage = userService.findAll(request, createBy);
        return userPage;
    }

    @PostMapping("/save")
    public String save(@RequestBody User user){
        User result = userRepository.save(user);
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }
    @PutMapping("/update")
    public String update(@RequestBody User user){
        User result = userRepository.save(user);
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        userRepository.deleteById(id);
    }
    @GetMapping("/findById/{id}")
    public Result findById(@PathVariable("id") Integer id){
        Optional<User> optional = userRepository.findById(id);
        User user = new User();
        if (optional.isPresent()) {
            user = optional.get();
        }
        return new Result(200, user);
    }
}

