package com.stackroute.springboot.contoller;

import com.stackroute.springboot.model.User;
import com.stackroute.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {
private UserService userService;
@Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>>getAllUsers() {
        return new ResponseEntity<List<User>>((List<User>)userService.getAllUsers(),HttpStatus.OK);

    }

    @GetMapping("/profile/gender")
    public ResponseEntity <List<User>> SearchUserByGender(String gender)
    {
        return new ResponseEntity<List<User>>((List<User>)userService.SearchUserByGender(gender),HttpStatus.OK);


    }








@PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody User user){
    User savedUser=userService.saveUser(user);
    return new ResponseEntity<>(savedUser, HttpStatus.CREATED);

}

    @PutMapping("/userss/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id,@RequestBody User user) throws Exception {
        user.setId(id);
        return ResponseEntity.ok().body(this.userService.updateUser(user));
    }
    @DeleteMapping("/usersss/{id}")
    public HttpStatus deleteUser(@PathVariable int id) throws Exception {
        this.userService.deleteUser(id);
        return HttpStatus.OK;
    }




}
