
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

### /src/main/java/com/ibermatica/rest/webservices/restfulwebservices/HelloWorldController.java

```java
/**
 * 
 */
package com.ibermatica.rest.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.GetMapping;
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

}

```
---
### /src/main/java/com/ibermatica/rest/webservices/restfulwebservices/HelloWorldBean.java

```java
/**
 * 
 */
package com.ibermatica.rest.webservices.restfulwebservices;

/**
 * The Hello World Bean.
 *
 * @author pvraul1
 * @since 1.8
 * @version 23 dic. 2019 12:51:58
 *
 */
public class HelloWorldBean {

    /** The message property.*/
    private String message;

    public HelloWorldBean(String message) {
        super();
        this.message = message;
    }

    /**
     * @return the message
     */
    public final String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public final void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("HelloWorldBean [message=%s]", message);
    }

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
