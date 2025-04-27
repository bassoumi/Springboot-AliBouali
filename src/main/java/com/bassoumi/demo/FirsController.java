package com.bassoumi.demo;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirsController {
    @GetMapping("/hey") public String sayHellow(){
        return "Hello World from my first controller";}


    @PostMapping("/post")
    public String post(
            @RequestBody String message
    ){
        return "request accepted and message is : " + message;
    }


}
