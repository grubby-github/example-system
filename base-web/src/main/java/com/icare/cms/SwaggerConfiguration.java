package cn.gaoz.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author gaoz
 * @function Swagger启动配置类
 * @date 2019-09-06 20:34:00
 * @url http://localhost:8080/swagger-ui.html
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    /**
     * swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
     *
     * @return
     */
    @Bean
    public Docket createRestfulApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("CMS-Base")
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.gaoz.example.controller")) //暴露接口地址的包路径
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    /**
     * 构建 api文档的详细信息函数,注意这里的注解引用的是哪个
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("CMS-Base RESTful API")
                //创建人
                .contact(new Contact("gaoz", "http://www.icarevision.cn/", "re_grubby@hotmail.com"))
                //版本号
                .version("1.0")
                //描述
                .description("CMS-Base只管理公司现有的PAS和VAS等所有的AS服务模块")
                .build();
    }
}
