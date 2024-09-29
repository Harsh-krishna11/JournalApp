package net.engineeringedigest.journalApp.service;

import net.engineeringedigest.journalApp.entity.User;
import net.engineeringedigest.journalApp.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;


//    @Disabled
//    @Test
//    public void testFindByUserName(){
////        assertEquals(4,2+2);
////        assertNotNull(userRepository.findByUserName("harsh"));
////        assertTrue(5>3);
//        User user = userRepository.findByUserName("harsh");
//        assertTrue(!user.getJournalEntries().isEmpty());
//    }


//    @ParameterizedTest
//    @CsvSource({
//            "harsh",
//            "kanha"
//    })
//    public void testFindByUserName(String name){
//        assertNotNull(userRepository.findByUserName(name),"failed for : "+name);
//    }


//    @ParameterizedTest
//    @ValueSource(strings = {
//            "harsh",
//            "kanha"
//    })
//    public void testFindByUserName(String name){
//        assertNotNull(userRepository.findByUserName(name),"failed for : "+name);
//    }

//    @BeforeEach
//    @BeforeAll
//    @AfterAll
//    void setUp(){
//
//    }


    @Disabled
    @ParameterizedTest
    @ArgumentsSource(UserArgumentsProvider.class)
    public void testSaveNewUser(User user){
        assertTrue(userService.saveNewEntry(user));
    }

    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,10,12",
            "3,3,3"
    })
    public void test(int a , int b , int expected){
        assertEquals(expected,a+b);
    }
}
