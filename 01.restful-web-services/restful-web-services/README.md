
## Complete Code Example


### /build.gradle

```gradle
plugins {
	id 'org.springframework.boot' version '2.2.2.RELEASE'
	id 'io.spring.dependency-management' version '1.0.8.RELEASE'
	id 'java'
}

group = 'com.ibermatica.rest.webservices'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '1.8'

configurations {
	developmentOnly
	runtimeClasspath {
		extendsFrom developmentOnly
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	developmentOnly 'org.springframework.boot:spring-boot-devtools'
	runtimeOnly 'com.h2database:h2'
	testImplementation('org.springframework.boot:spring-boot-starter-test') {
		exclude group: 'org.junit.vintage', module: 'junit-vintage-engine'
	}
	compileOnly 'org.projectlombok:lombok:1.18.10'
	annotationProcessor 'org.projectlombok:lombok:1.18.10'
}

test {
	useJUnitPlatform()
}

```
---

### /src/main/java/com/ibermatica/rest/webservices/restfulwebservices/RestfulWebServicesApplication.java

```java
/**
 * 
 */
package com.ibermatica.rest.webservices.restfulwebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The spring boot starter.
 *
 * @author pvraul1
 * @since 1.8
 * @version 22 dic. 2019 13:24:02
 *
 */
@SpringBootApplication
public class RestfulWebServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestfulWebServicesApplication.class, args);
    }

}

```
---

### /src/main/java/com/ibermatica/rest/webservices/restfulwebservices/helloworld/HelloWorldController.java

```java
/**
 * 
 */
package com.ibermatica.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Hello World Rest Controller.
 *
 * @author pvraul1
 * @since 1.8
 * @version 22 dic. 2019 20:38:41
 *
 */
@RestController
public class HelloWorldController {

    /**
     * Get the hello world message.
     *
     * @return the hello world message
     */
    @GetMapping(path = "hello-world")
    public String helloWorld() {
        return "Hello World!";
    }

    /**
     * Get the hello world bean.
     * @return the hello world bean
     */
    @GetMapping(path = "hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World!");
    }

    /**
     * Get the hello world path variable.
     * @return the hello world bean with the name passed
     */
    @GetMapping(path = "hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hi there, %s", name));
    }

}

```
---
### /src/main/java/com/ibermatica/rest/webservices/restfulwebservices/helloworld/HelloWorldBean.java

```java
/**
 * 
 */
package com.ibermatica.rest.webservices.restfulwebservices.helloworld;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Hello World Bean.
 *
 * @author pvraul1
 * @since 1.8
 * @version 23 dic. 2019 12:51:58
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HelloWorldBean {

    /** The message property.*/
    private String message;

}

```
---

### /src/main/resources/application.properties

```properties
```
---

### /src/test/java/com/ibermatica/rest/webservices/restfulwebservices/RestfulWebServicesApplicationTests.java

```java
/**
 * 
 */
package com.ibermatica.rest.webservices.restfulwebservices;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestfulWebServicesApplicationTests {

    @Test
    void contextLoads() {
    }

}

```
---

### /src/main/java/com/ibermatica/rest/webservices/restfulwebservices/user/User.java

```java
/**
 * 
 */
package com.ibermatica.rest.webservices.restfulwebservices.user;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The user entity.
 *
 * @author pvraul1
 * @since 1.8
 * @version 14 ene. 2020 17:01:55
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /** The user identifier property.*/
    private Integer id;

    /** The user name property.*/
    private String name;

    /** The user birthday property.*/
    private Date birthDate;
}

```
---

### /src/main/java/com/ibermatica/rest/webservices/restfulwebservices/user/UserDaoService.java

```java
/**
 * 
 */
package com.ibermatica.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * The user DAO service.
 *
 * @author pvraul1
 * @since 1.8
 * @version 15 ene. 2020 8:53:59
 *
 */
@Component
public class UserDaoService {

    /** The user list property.*/
    private static List<User> users = new ArrayList<>();

    /** The users count property.*/
    private static int usersCount = 3;

    static {
        users.add(User.builder()
                .id(Integer.valueOf(1))
                .name("Adam")
                .birthDate(new Date())
                .build());

        users.add(User.builder()
                .id(Integer.valueOf(2))
                .name("Eve")
                .birthDate(new Date())
                .build());

        users.add(User.builder()
                .id(Integer.valueOf(3))
                .name("Jack")
                .birthDate(new Date())
                .build());
    }

    /** Create a new instance of the class.*/
    private UserDaoService() {
        super();
    }

    /**
     * Get all the users.
     *
     * @return the users list
     */
    public List<User> findAll() {
        return users;
    }

    /**
     * Add a user.
     *
     * @param user the user to add
     * @return the user added
     */
    public static synchronized User save(User user) {
        if (user.getId() == null) {
            user.setId(++usersCount);
        }
        users.add(user);

        return user;
    }

    /**
     * Get an user by identifier.
     *
     * @param id the user identifier
     * @return the user 
     */
    public User findOne(int id) {
        for (User user : users) {
            if (user.getId().intValue() == id) {
                return user;
            }
        }

        return null;
    }

}

```
---
### /src/main/java/com/ibermatica/rest/webservices/restfulwebservices/user/UserResource.java

```java
/**
 * 
 */
package com.ibermatica.rest.webservices.restfulwebservices.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * The user REST controller.
 *
 * @author pvraul1
 * @since 1.8
 * @version 15 ene. 2020 9:40:16
 *
 */
@RestController
public class UserResource {

    /** The user DAO service property.*/
    @Autowired
    private UserDaoService service;

    /**
     * Retrieve all users.
     *
     * @return the user list
     */
    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    /**
     * Retrieve an user.
     *
     * @param id the user identifier
     * @return the user
     */
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        return service.findOne(id);
    }

}

```
---