package net.engineeringedigest.journalApp.service;

import lombok.extern.slf4j.Slf4j;
import net.engineeringedigest.journalApp.entity.User;
import net.engineeringedigest.journalApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

//    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void saveUser(User user){
        userRepository.save(user);
    }

    public boolean saveNewEntry(User user){
        try{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            userRepository.save(user);
            return true;
        } catch (Exception e) {

//            logger.info("hare krishna hare krishna krishna krishna hare hare !!!");
//            logger.warn("hare krishna hare krishna krishna krishna hare hare !!!");
//            logger.error("Error Occured for {}",user.getUserName(),e);
//            logger.debug("hare krishna hare krishna krishna krishna hare hare !!!");
//            logger.trace("hare krishna hare krishna krishna krishna hare hare !!!");

//            log.error("Error Occured for {}",user.getUserName(),e);
//            log.error("Error Occured");

//            log.debug("debug the code");
            return false;
        }

    }

    public void saveAdmin(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER","ADMIN"));
        userRepository.save(user);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public Optional<User> fingById(ObjectId id){
        return userRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        userRepository.deleteById(id);
    }

    public User findByUserName(String username) {
        return userRepository.findByUserName(username);
    }
}



//controller ---> service ---> repository
