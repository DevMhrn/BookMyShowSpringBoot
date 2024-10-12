package org.buildproduct.bookmyshow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;

@SpringBootApplication
@EnableJdbcAuditing // JPA is a lib using which we are connecting the DB with the application

public class BookMyShowApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookMyShowApplication.class, args);
    }

}

/*
Steps to automatically add createdAt and lastModified ( for checking purpose if it is called auditing attributes)
1. Add the annotation @EnableJdbcAuditing to the main class
2. Add the @EntityListeners(AuditingEntityListener.class) annotation to the BaseModel class

*
* */
