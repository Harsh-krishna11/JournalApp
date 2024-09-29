//package net.engineeringedigest.journalApp.entity;
//
//public class JournalEntry {
//
//    private long id;
//
//    private String title;
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    private String content;
//}


//package net.engineeringedigest.journalApp.entity;
//
//import org.bson.types.ObjectId;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//import java.time.LocalDateTime;
//import java.util.Date;
//
//@Document(collection = "journal_entries")
//public class JournalEntry {
//
//    @Id
//    private ObjectId id;
//
//    private String title;
//
//    private LocalDateTime date;
//
//    public LocalDateTime getDate() {
//        return date;
//    }
//
//    public void setDate(LocalDateTime date) {
//        this.date = date;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public ObjectId getId() {
//        return id;
//    }
//
//    public void setId(ObjectId id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    private String content;
//}


//lombok generates geeters and setters during compilation using annotation

package net.engineeringedigest.journalApp.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
@Data
@Builder
public class User {

    @Id
    private ObjectId id;

    @Indexed(unique = true)
    @NonNull
    private String userName;

    @NonNull
    private String password;

    private List<String>roles;

    @DBRef
    private List<JournalEntry> journalEntries= new ArrayList<>();
}



//@Document(collection = "journal_entries")
////@Getter
////@Setter
////@NoArgsConstructor
////@AllArgsConstructor
////@ToString
////@EqualsAndHashCode
////@Builder
//@Data