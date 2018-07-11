package com.newbee.DemoController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cuiming
 * @date 2018.07.11
 */
@RestController
@Slf4j
@Api(value = "菜鸟工作室")
public class HelloWorldController {

    @ApiOperation(value = "HelloWorld", httpMethod = "POST")
    @PostMapping("/helloworld")
    public String helloWorld(String name){
        return "菜鸟工作室" + name;
    }


}
