package com.southwind.springboottest.controller;
import com.southwind.springboottest.entity.User;
import com.southwind.springboottest.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;
import com.southwind.springboottest.service.UserService;

@Controller
public class RegisterController {
    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping(value= "/users")//users ..少哥s要保持一直
    @ResponseBody
    public Result register(@RequestBody User requestUser) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUser.getUsername();
        String password = requestUser.getPassword();
//        requestUser.setId(2);
        username = HtmlUtils.htmlEscape(username);
        //拿到用户名，保存到数据库
        User getUser = null;
        if (username != null && !username.equals("")) {
            getUser = userService.getByName(username);
        }
        if (getUser != null) {
            return new Result(401,"当前用户已经存在，请登陆！");
        }
        User addUser = userService.add(requestUser);
//        User user =userService.get(username,requestUser.getPassword());
        //addUser如果保存的用户不为空，则保存成功，否则保存失败
        if (addUser !=null) {
            System.out.println(username+password);
            System.out.println("保存的用户是："+ addUser);
            //这筐返回的是400和200.看看前端接受的啥
            return new Result(200);
        } else {
            return new Result(400,"保存用户失败，请检查用户名和密码");
        }
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
