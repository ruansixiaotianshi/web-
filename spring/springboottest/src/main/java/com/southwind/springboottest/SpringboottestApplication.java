package com.southwind.springboottest;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.southwind.springboottest.repository")
public class SpringboottestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringboottestApplication.class, args);
    }

    @Bean
      public PaginationInterceptor paginationInterceptor() {
               PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
               return paginationInterceptor;
            }

}
