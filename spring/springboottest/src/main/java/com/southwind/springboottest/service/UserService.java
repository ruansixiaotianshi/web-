package com.southwind.springboottest.service;

        import com.southwind.springboottest.entity.DataModel;
        import com.southwind.springboottest.entity.User;
        import com.southwind.springboottest.repository.UserRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.data.domain.Example;
        import org.springframework.data.domain.Page;
        import org.springframework.data.domain.PageRequest;
        import org.springframework.stereotype.Service;

        import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;


    public   Page<User>  findAll(PageRequest pageRequest, String createBy) {
        User user = userRepository.findByUsername(createBy);
        String role = user.getRole();
        //如果是用户，可以查看当前用户下数据
        if ("user".equals(role) ) {
            user.setUsername(createBy);
        }
        Example<User> userExample = Example.of(user);
        Page<User> userPage = userRepository.findAll(userExample, pageRequest);
        return userPage;
    }

    public boolean isExist(String username) {
        User user = getByName(username);
        return null!= user;
    }


    public User getByName(String username) {
        return userRepository.findByUsername(username);
    }


    public User get(String username, String password){
        return userRepository.getByUsernameAndPassword(username, password);
    }


    public User add(User user) {
        User addUser = null;
        if (user != null) {
            addUser = userRepository.save(user);
        }
        return addUser;
    }
}