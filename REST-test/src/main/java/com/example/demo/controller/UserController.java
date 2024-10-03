package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.model.Users;
import com.example.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Iterable<UserDto>> getAllUsers(){
        try {
            Iterable<UserDto> allUsers = userService.getAllUsers();
            return new ResponseEntity<>(allUsers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id){
        try{
            UserDto user = userService.findUserById(id);

            if(user == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(user, HttpStatus.OK);

        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestParam(name="username") String username, @RequestParam(name="firstname") String firstName, @RequestParam(name="lastname") String lastName,
                                             @RequestParam(name="email") String email, @RequestParam(name="university") String university) {
        try{
            Users newUser = new Users(username, firstName, lastName, email, university);
            userService.createUser(newUser);
            return new ResponseEntity<>("Successfully created user with id: " + newUser.getId(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> handleException(Exception e) {
//        // Log the exception
//        logger.error("An error occurred: ", e);
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body("An unexpected error occurred");
//    }
//    Could add the above, but then errors become generalized

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(name="id") Long id) {
        try{
            userService.deleteUserById(id);
            return new ResponseEntity<>("Successfully deleted user", HttpStatus.ACCEPTED);
        } catch (Exception ex){
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}