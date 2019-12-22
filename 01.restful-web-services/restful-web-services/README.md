
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
