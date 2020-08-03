package com.southwind.springboottest.controller;
        import com.southwind.springboottest.entity.User;
        import com.southwind.springboottest.entity.Result;
        import lombok.Data;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.*;
        import org.springframework.web.util.HtmlUtils;
import com.southwind.springboottest.service.UserService;

@Controller
public class LoginController {
@Autowired
UserService userService;

    @CrossOrigin
    @PostMapping(value= "/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUser.getUsername();
        String password = requestUser.getPassword();
        username = HtmlUtils.htmlEscape(username);
        //拿用户名和密码取查，如果查询到，则说明用户名密码正确。查询不到则说明用户名密码错误
        User user = userService.get(username, requestUser.getPassword());
//        if (!Objects.equals("admin", username) || !Objects.equals("123456", requestUser.getPassword())) {
        //填写的用户名密码和数据库保存的对比
//        if (!username.equals(user.getUsername()) || !password.equals(user.getPassword())) {
        //
        if (user ==null) {
            String message = "账号密码错误";
            System.out.println("test");
            return new Result(400,message);
        } else {
            return new Result(200,user);
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
