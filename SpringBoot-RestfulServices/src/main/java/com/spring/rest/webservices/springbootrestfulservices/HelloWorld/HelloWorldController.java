package com.spring.rest.webservices.springbootrestfulservices.HelloWorld;

// Controller

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
    @GetMapping(path="/hello-world")
    public String helloWorld(){
        return "Rest1 Hello World";
    }
    
    @PostMapping(path="/create-post")
    public String createPost() {
    	return "create new post";
    }
    
    //hello-world-bean
    @GetMapping(path="/hello-world-bean")
    	public HelloWorldBean helloWorldBean() {
    	return new HelloWorldBean("Hello World");
    }
    
    // using path variable
    //hello-world/path-variable/in28mins
	 @GetMapping(path="/hello-world/path-variable/{name}") 
	  public HelloWorldBean helloWorldBean1(@PathVariable String name) { 
		  return new HelloWorldBean(String.format("Hello World, %s", name));
	}
	  
	 
}
