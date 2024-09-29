//package net.engineeringedigest.journalApp.controller;
//
//import net.engineeringedigest.journalApp.entity.JournalEntry;
//import net.engineeringedigest.journalApp.repository.JournalEntryRepository;
//import net.engineeringedigest.journalApp.service.JournalEntryService;
//import org.bson.types.ObjectId;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.*;
//
//@RestController
//@RequestMapping("/journal")
//public class JournalEntryControllerV2 {
//
//    @Autowired
//    private JournalEntryService journalEntryService;
//
//    @GetMapping
//    public ResponseEntity<List<JournalEntry>> getAll(){                          //localhost:8080/journal   get
//        List<JournalEntry> all = journalEntryService.getAll();
//        if(all!=null && !all.isEmpty()){
//            return new ResponseEntity<>(all, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    @PostMapping
//    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry){
//        try {
//            journalEntryService.saveEntry(myEntry);
//            return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//
//    }
//
//    @GetMapping("id/{myId}")
//    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable ObjectId myId){
//
//        Optional<JournalEntry>journalEntry = journalEntryService.fingById(myId);
//        if(journalEntry.isPresent()){
//            return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
////        return journalEntryService.fingById(myId).orElse(null);
//    }
//
//    @DeleteMapping("id/{myId}")
//    public ResponseEntity<?> deleteJournalEntryById(@PathVariable ObjectId myId){
//        journalEntryService.deleteById(myId);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    @PutMapping("id/{id}")
//    public ResponseEntity<?> updateJournalById(@PathVariable ObjectId id , @RequestBody JournalEntry newEntry){
//        JournalEntry old = journalEntryService.fingById(id).orElse(null);
//
//        if(old!=null){
//            old.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().equals("")?newEntry.getTitle():old.getTitle());
//            old.setContent(newEntry.getContent()!=null && !newEntry.getContent().equals("")?newEntry.getContent(): old.getContent());
//            journalEntryService.saveEntry(old);
//            return new ResponseEntity<>(old,HttpStatus.OK);
//        }
//        return new ResponseEntity<>(old,HttpStatus.NOT_FOUND);
//    }
//}


//package net.engineeringedigest.journalApp.controller;
//
//import net.engineeringedigest.journalApp.entity.JournalEntry;
//import net.engineeringedigest.journalApp.entity.User;
//import net.engineeringedigest.journalApp.repository.JournalEntryRepository;
//import net.engineeringedigest.journalApp.service.JournalEntryService;
//import net.engineeringedigest.journalApp.service.UserService;
//import org.bson.types.ObjectId;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.*;
//
//@RestController
//@RequestMapping("/journal")
//public class JournalEntryControllerV2 {
//
//    @Autowired
//    private JournalEntryService journalEntryService;
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("{userName}")
//    public ResponseEntity<List<JournalEntry>> getAllJournalEntriesOfUser(@PathVariable String userName){                          //localhost:8080/journal   get
//        User user = userService.findByUserName(userName);
//        List<JournalEntry> all = user.getJournalEntries();
//        if(all!=null && !all.isEmpty()){
//            return new ResponseEntity<>(all, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    @PostMapping("{userName}")
//    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry,@PathVariable String userName){
//        try {
//            journalEntryService.saveEntry(myEntry,userName);
//            return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//
//    }
//
//    @GetMapping("id/{myId}")
//    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable ObjectId myId){
//
//        Optional<JournalEntry>journalEntry = journalEntryService.fingById(myId);
//        if(journalEntry.isPresent()){
//            return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @DeleteMapping("id/{userName}/{myId}")
//    public ResponseEntity<?> deleteJournalEntryById(@PathVariable ObjectId myId,@PathVariable String userName){
//        journalEntryService.deleteById(myId,userName);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    @PutMapping("id/{userName}/{id}")
//    public ResponseEntity<?> updateJournalById(@PathVariable ObjectId id , @RequestBody JournalEntry newEntry,@PathVariable String userName){
//        JournalEntry old = journalEntryService.fingById(id).orElse(null);
//
//        if(old!=null){
//            old.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().equals("")?newEntry.getTitle():old.getTitle());
//            old.setContent(newEntry.getContent()!=null && !newEntry.getContent().equals("")?newEntry.getContent(): old.getContent());
//            journalEntryService.saveEntry(old);
//            return new ResponseEntity<>(old,HttpStatus.OK);
//        }
//        return new ResponseEntity<>(old,HttpStatus.NOT_FOUND);
//    }
//}



package net.engineeringedigest.journalApp.controller;

import net.engineeringedigest.journalApp.entity.JournalEntry;
import net.engineeringedigest.journalApp.entity.User;
import net.engineeringedigest.journalApp.repository.JournalEntryRepository;
import net.engineeringedigest.journalApp.service.JournalEntryService;
import net.engineeringedigest.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<JournalEntry>> getAllJournalEntriesOfUser(){                          //localhost:8080/journal   get
        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userService.findByUserName(userName);
        List<JournalEntry> all = user.getJournalEntries();
        if(all!=null && !all.isEmpty()){
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry){
        try {
            Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
            String userName = authentication.getName();
            journalEntryService.saveEntry(myEntry,userName);
            return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("id/{myId}")
    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable ObjectId myId){
        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userService.findByUserName(userName);
        List<JournalEntry> collect = user.getJournalEntries().stream().filter(x->x.getId().equals(myId)).collect(Collectors.toList());
        if(!collect.isEmpty()){
            Optional<JournalEntry>journalEntry = journalEntryService.fingById(myId);
            if(journalEntry.isPresent()){
                return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("id/{myId}")
    public ResponseEntity<?> deleteJournalEntryById(@PathVariable ObjectId myId){
        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        boolean removed = journalEntryService.deleteById(myId,userName);
        if (removed) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("id/{myId}")
    public ResponseEntity<?> updateJournalById(@PathVariable ObjectId myId , @RequestBody JournalEntry newEntry){
        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userService.findByUserName(userName);
        List<JournalEntry> collect = user.getJournalEntries().stream().filter(x->x.getId().equals(myId)).collect(Collectors.toList());

        if(!collect.isEmpty()){
            Optional<JournalEntry>journalEntry = journalEntryService.fingById(myId);
            if(journalEntry.isPresent()){
                JournalEntry old = journalEntry.get();
                old.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().equals("")?newEntry.getTitle():old.getTitle());
                old.setContent(newEntry.getContent()!=null && !newEntry.getContent().equals("")?newEntry.getContent(): old.getContent());
                journalEntryService.saveEntry(old);
                return new ResponseEntity<>(old,HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}