package com.bridgelabez.hello_rest_controller_day2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;


@SpringBootApplication
public class HelloRestControllerDay2Application {

    public static void main(String[] args) {

        SpringApplication.run(HelloRestControllerDay2Application.class, args);
    }
}
@RestController
@RequestMapping("/hello")
class HelloController{

    //uc1  --> http://localhost:8080/hello
    @RequestMapping(value = {"","/","/home"})
    public String helloMessageUc1(){
        return "Hello from Bridgelabz";
    }

    //uc2  --> http://localhost:8080/hello/query?name=Mark
    @RequestMapping(value = {"/query"}, method = RequestMethod.GET)
    public String sayHelloUc2(@RequestParam(value = "name") String name){
        return "Hello "+name+ " from Bridgelabz";
    }

    //uc3 --> http://localhost:8080/hello/param/Mark
    @GetMapping("/param/{name}")
    public String sayHelloUc3(@PathVariable String name){
        return "Hello "+name+ " from Bridgelabz";
    }

    //uc4  -->http://localhost:8080/hello/post       {"firstName":"Mark", "lastName":"Taylor"}
    @PostMapping("/post")
    public String sayHelloUc4(@RequestBody User user){
        return "Hello "+ user.getFirstName() + " " + user.getLastName();
    }

    //uc5 --> http://localhost:8080/hello/put/Mark/?lastName=Taylor **note =>Working in Postman but not in Chrome browser
    @PutMapping("/put/{firstName}")
    public String sayHelloUc5(@PathVariable String firstName, @RequestParam(value = "lastName") String lastName){
        return "Hello " + firstName + " " + lastName;
    }
}
