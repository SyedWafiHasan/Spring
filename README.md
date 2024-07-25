# Spring Notes
### This README is a personal collection of notes I will be making throughout this tutorial. 

## Annotations
Spring relies on Annotations to indicate the usage of a particular class/method.
Some common examples are:
### 1. `@Component`

Marks the class as a Spring Bean. A Spring Bean is just a regular class that is managed by Spring.

`@Component` also makes the bean available for dependency injection.

### 2. `@SpringBootApplication`

`@SpringBootApplication` is used to denote the starting point of a SpringBoot application. 
This is where the main method in a SpringBoot application is found.

### 3. `@RestController`

`@RestController` is used to create RESTful endpoints to serve as URLs you can visit on your local network.
A popular sub-component of `@RestController` is `@GetMapping`, though which you can provide a GET API.

### 4. `@Autowired`

`@Autowired` annotation is used to inject the dependency of one bean into another.
When you annotate a method or field with `@Autowired`, SpringBoot will inejct the dependency automatically and
find the bean that matches that field or parameter. 

In other words, `@Autowired` annotation in SpringBoot manages the entire life cycle of the object. 

Tip : If you only have one constructor, `@Autowired` on constructor is optional. 