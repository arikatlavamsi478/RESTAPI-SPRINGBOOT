package com.spring.rest.webservices.springbootrestfulservices.User;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResourceController
{
    @Autowired
    private UserDaoService service;
    @GetMapping("/users")
    public List<User> retriveAllUsers()
    {
        return service.findAll();
    }
    //retrieves a specific user detail
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id)
    {
        User user = service.findOne(id);

        if(user == null){
            throw new UserNotFoundException("id-"+  id);
        }
        return user;
    }
    //method that posts a new user detail and returns the status of HTTP and location of the user resource
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user)
    {
        User savedUser=service.save(user);
        URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}  
