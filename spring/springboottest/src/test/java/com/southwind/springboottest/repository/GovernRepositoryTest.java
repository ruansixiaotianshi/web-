package com.southwind.springboottest.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GovernRepositoryTest {

    @Autowired
    private GovernRepository governRepository;

    @Test
    void findAll(){
System.out.println(governRepository.findAll());
    }

}
//    @Test
//    void findAll(){
//        System.out.println(userRepository.findAll());
//    }
//
//}