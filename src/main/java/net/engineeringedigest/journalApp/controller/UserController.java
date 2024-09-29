package net.engineeringedigest.journalApp.controller;

import net.engineeringedigest.journalApp.entity.JournalEntry;
import net.engineeringedigest.journalApp.entity.User;
import net.engineeringedigest.journalApp.repository.UserRepository;
import net.engineeringedigest.journalApp.service.JournalEntryService;
import net.engineeringedigest.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

//    @GetMapping
//    public List<User> getAllUsers(){
//        return userService.getAll();
//    }

    @PutMapping()
    public ResponseEntity<?> updateUser(@RequestBody User user){

        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();

        User userInDb = userService.findByUserName(userName);
        if(userInDb != null){
            userInDb.setUserName(user.getUserName());
            userInDb.setPassword(user.getPassword());
            userService.saveNewEntry(userInDb);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @DeleteMapping
    public ResponseEntity<?> deleteByUserId(@RequestBody User user){

        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();

        userRepository.deleteByUserName(userName);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
