package net.engineeringedigest.journalApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class JournalApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context =  SpringApplication.run(JournalApplication.class, args);
		System.out.println(context.getEnvironment().getActiveProfiles()[0]);
	}

	@Bean
	public PlatformTransactionManager add(MongoDatabaseFactory dbFactory){
		return new MongoTransactionManager(dbFactory);
	}
}


//PlatformTransactionManager
//MongoTransactionManager  -- implements platformtransaction


//orm(object relational mapping) (hibernate) is a technique used to map java objects to database tables
//jpi(java persistence api) a way to achieve orm includes interfaces and annotation that you use in your java classes,requies a


//transaction context ---atomacity , isolation