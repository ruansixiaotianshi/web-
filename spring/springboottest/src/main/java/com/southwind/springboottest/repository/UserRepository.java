package com.southwind.springboottest.repository;
import com.southwind.springboottest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer>{
    User findByUsername(String username);
    User getByUsernameAndPassword(String username, String password);

}
