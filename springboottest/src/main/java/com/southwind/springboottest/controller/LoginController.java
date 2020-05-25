package com.southwind.springboottest.controller;

import com.southwind.springboottest.entity.User;
import com.southwind.springboottest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoginController {

    @Autowired
    private UserRepository userRepository;


    @RequestMapping("login")
    public String login(@RequestParam("userName") String userName,@RequestParam("passWord") String passWord) {

        //从数据库中查询到所有的账号
        List<User> userList = userRepository.findAll();
        if (userList != null && userList.size() > 0) {
            for (int i = 0; i < userList.size(); i++) {
                //取到数据库中的账号依次和传过来的进行对比
                String username = userList.get(i).getUsername();
                String password = userList.get(i).getPassword();
                if (userName.equals(username) && passWord.equals(password)) {
                    return "200";
                }
            }
        }
        return "400";
    }
}

//@RestController
//public class LoginController {
//    @CrossOrigin
//    @RequestMapping("api/login")
//    public Result login(@RequestBody User user) {
//        String username = HtmlUtils.htmlEscape(user.getUsername());
//        if (!"admin".equals(username) || !"123456".equals(user.getPassword())) {
//            return new Result(400);
//        } else {
//            return new Result(200);
//        }
//        @GetMapping("/login")
//        public String login() {
//            return "/login";
//        }
//
//    }
//}
