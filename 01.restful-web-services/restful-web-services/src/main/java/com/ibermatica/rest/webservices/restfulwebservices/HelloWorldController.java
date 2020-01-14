/**
 * 
 */
package com.ibermatica.rest.webservices.restfulwebservices;

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
