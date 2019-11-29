package cn.gaoz.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

//import org.mybatis.spring.annotation.MapperScan;//生成通用mapper时是需要用下面tk的MapperScan

/**
 * 依赖注入是按照包名逐级向下查找，所以依赖注入的类要在这个类的同级或下级包中才可以被注入
 */
@MapperScan(basePackages = "cn.gaoz.example.dao.mapper")
@SpringBootApplication
@ServletComponentScan
@EnableScheduling
public class BaseWebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(BaseWebApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BaseWebApplication.class);
    }
}
