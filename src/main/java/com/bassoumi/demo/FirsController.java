package com.bassoumi.demo;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirsController {
    //@GetMapping("/hey") public String sayHellow(){
        // return "Hello World from my first controller";}

    @GetMapping("/hey-2")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String sayHellow2(){
        return "Hello-2 World from my first controller";
    }

    @PostMapping("/post")
    public String post(
            @RequestBody String message
    ){
        return "request accepted and message is : " + message;
    }

    @PostMapping("/post-order")
    public String post(
            @RequestBody Order order
    ){
        return "request accepted and order is : " + order.toString();
    }


    @PostMapping("/post-order-record")
    public String post(
            @RequestBody OrderRecord order
    ){
        return "request accepted and order is : " + order.toString();
    }


   // @GetMapping("/hey/{userName}")
    //public String pathVar(
        //   @PathVariable("userName") String userName
    //){
      //  return "my value = "+userName;
   // }



    @GetMapping("/hey")
    public String paramVar(
           @RequestParam("userName") String userName,
           @RequestParam("userLastName") String userLastName

           ){
        return "my value = "+userName + " " +userLastName;
    }


}
