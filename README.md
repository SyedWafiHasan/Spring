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

## Component Scanning
- Spring will scan your Java classes for special annotations like `@Component` etc.
- Automatically registers the beans in the Spring container.
- Auto-scanning is enabled by importing `SpringBootApplication` class.
  - Behind the scenes, this is enabled by `@EnableAutoConfiguration`, `@ComponentScan` and `@Configuration` annotations.
- `@EnableAutoConfiguration` enables Spring Boot's auto-configuration support.
- `@ComponentScan` enables component scanning of current package, and also recursively scans sub packages.
- `@Configuration` is able to register extra beans with the `@Bean` annotation or import other configuration classes.

In the following code snippet, the `SpringApplication` class bootstraps your Spring Boot Application. 
```
package in.co.swh.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}
}

```

Behind the scenes, this will create the application context, register all the beans
and start the embedded Tomcat server.

### More on Component Scanning
- By default, Spring Boot starts component scanning
  - From the same package as your main Spring Boot Application
  - Also scans sub packages recursively
- This implicitly defines a base search package
  - This allows you to leverage default component scanning
  - No need to explicitly reference base package name
- Component scanning will not work if you change package name unless you explicitly list packages to scan.

To demonstrate this, files were moved into a new sub-package as part of commit `a78072`. The application continues to work, as this is still a sub-package of the original package. 

However, under commit `8cfe4e`, files were moved to a new package which was created outside the main package. This resulted in the application failing to start, as it was unable to locate the necessary components. 