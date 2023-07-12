# @Autowired with Field Injection 

```java
@Service public class ReportService { 
    
    @Autowired 
    private ReportDao reportDao; 
    public void generateReport() { 
        reportDao.findData(); 
        System.out.println("generating report...."); 
        } 
}
```

In the provided code snippet, the `@Autowired` annotation is used for field injection in the `ReportService` class. Let's break down the different points you mentioned and provide a detailed explanation for each.

**1. IOC (Inversion of Control) and Reflection API:**
IOC is a design principle where the control of object creation and dependency management is inverted from the application code to a container or framework. The framework is responsible for creating and managing the objects and their dependencies. In the case of the Spring Framework, which supports `@Autowired`, it uses the Reflection API internally for dependency injection.

Reflection is a feature in Java that allows the examination and modification of the structure and behavior of classes, interfaces, fields, and methods at runtime. Spring's IOC container uses reflection to analyze the class structure, identify the dependencies (annotated with `@Autowired`), and inject the appropriate objects into the fields.

**2. `@Autowired` and Field Injection:**
The `@Autowired` annotation is used in Spring to automatically inject dependencies into beans (objects managed by the Spring container). When applied to a field, the annotation instructs the Spring container to find a suitable bean that satisfies the dependency and inject it into that field.

In the provided code, the `ReportDao` dependency is injected into the `reportDao` field of the `ReportService` class using field injection.

**3. Violation of OOP Principles:**
Field injection is considered less favorable compared to constructor or setter injection because it violates some Object-Oriented Programming (OOP) principles, such as encapsulation and dependency inversion.

Encapsulation promotes the hiding of internal implementation details of a class, allowing controlled access through well-defined interfaces. With field injection, the dependencies are directly exposed as public or package-private fields, which breaks encapsulation.

Dependency inversion, another principle of OOP, suggests that high-level modules should not depend on low-level modules directly, but both should depend on abstractions. Field injection directly injects concrete dependencies into the fields, resulting in a tight coupling between classes.

**4. Single Responsibility Principle:**
The Single Responsibility Principle (SRP) states that a class should have only one reason to change. By using field injection, a class is responsible for managing its own dependencies, which introduces an additional responsibility beyond its primary concern. This violates the SRP, making the class more complex and harder to maintain.

**5. Code Review and Complexity:**
When objects are injected using field injection, code review tools might find it challenging to identify the complexity of the code. Since the dependencies are directly injected into fields, it becomes less evident which dependencies a class requires. This can make it difficult for reviewers or analyzers to understand the dependencies and their relationships, leading to potential issues in code quality, maintainability, and testability.

To address these concerns, it is generally recommended to use constructor injection or setter injection instead of field injection. These approaches explicitly declare dependencies as constructor parameters or setter methods, promoting encapsulation, loose coupling, and easier code review and analysis.

<br/>
<br/>

# SI vs CI vs FI

Setter Injection:
-----------------
1. Setter Injection is performed through a setter method, which allows you to set the dependencies of a class.
2. The `@Autowired` annotation is mandatory to specify at the setter method to indicate that dependency injection should occur at that point.
3. If the `@Autowired` annotation is not specified, dependency injection will not happen, resulting in partial injection.
4. If dependency injection doesn't occur, and you call methods that rely on the dependencies, a `NullPointerException` may be thrown since the dependencies are not properly initialized.
5. In Setter Injection, the target bean (the class that depends on the dependency) is created first, and then the setter method is called to inject the dependent bean.

Constructor Injection:
----------------------
1. Constructor Injection is performed through the constructor of a class.
2. If a class has multiple constructors, you need to specify the `@Autowired` annotation at the constructor level to indicate which constructor should be used for dependency injection.
3. If a class has only one parameterized constructor, the `@Autowired` annotation is optional.
4. In Constructor Injection, the dependent bean is created first, and then the target bean is created. This ensures that all the necessary dependencies are available before creating the target object.
5. Partial injection is not possible in Constructor Injection. If any of the required dependencies are missing, Spring will throw an exception during bean creation.

Field Injection:
----------------
1. Field Injection is performed using the Reflection API, which directly initializes private variables of a class from outside.
2. Field Injection violates some Object-Oriented Programming (OOP) principles, as private variables are being directly initialized from outside the class, breaking encapsulation.
3. Field Injection is simple to use since it requires just one line of code (`@Autowired` annotation on the field).
4. Field Injection is often preferred by many programmers due to its simplicity and convenience.
   
Summary:
--------
Among the different types of dependency injections, Constructor Injection is generally recommended for several reasons:
- It ensures that all required dependencies are available before creating the target object, preventing partial injection.
- It allows for better encapsulation and loose coupling between classes.
- It is more explicit and clear in indicating dependencies.
- It promotes testability and easier code review.

Field Injection, although simple to use, violates encapsulation and can make it harder to identify and manage dependencies. Setter Injection, on the other hand, can lead to partial injection issues if the `@Autowired` annotation is not specified correctly. Therefore, Constructor Injection is the preferred approach for dependency injection in most cases.

<br/>
<br/>

# **`Bean Life Cycle`**

**Bean Class**
-------------------
The Java class that is represented as a Spring Bean is called a Bean Class. It is a class that is managed by the Spring framework's Inversion of Control (IOC) container.

**Spring Bean**
-----------------
In the context of Spring framework, a Spring Bean refers to a Java object that is managed by the IOC container. The IOC container creates, configures, and manages the lifecycle of Spring Beans.

**Lifecycle Management**
----------------------------
The Spring framework manages the lifecycle of Spring Beans through the IOC container. The IOC container is responsible for creating, initializing, and destroying Spring Beans as needed.

**Object Creation and Destruction**
---------------------------------------
The creation and destruction of Spring Beans are handled by the IOC container. When the IOC container initializes, it creates instances of Spring Beans based on the configuration. When the application or container shuts down, the IOC container destroys the Spring Beans, releasing any resources held by them.

**Lifecycle Methods for Spring Beans**
-----------------------------------------
Spring provides the ability to execute lifecycle methods during the creation and destruction of Spring Beans. These lifecycle methods allow you to perform custom initialization and cleanup tasks specific to your application needs.

**Two Ways to Work with Bean Lifecycle Methods in Spring Boot**
------------------------------------------------------------------
1) **Implementing Interfaces**
```java
@Component
public class Motor implements InitializingBean, DisposableBean{
	
	public Motor() {
		System.out.println("Motor :: Constructor");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet() method called....");
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("destroy() method called.....");
	}
}
```

   - Spring provides two interfaces, `InitializingBean` and `DisposableBean`, which can be implemented by the Bean Class.
   - The `afterPropertiesSet()` method from the `InitializingBean` interface is called by the IOC container after dependency injection is complete.
   - The `destroy()` method from the `DisposableBean` interface is called by the IOC container before the bean is destroyed.

2) **Using Annotations**
```java
@Component
public class Motor {
	
	public Motor() {
		System.out.println("Motor :: Constructor");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("init() method called....");
	}
	
	@PreDestroy
	public void cleanup() {
		System.out.println("cleanup() method called.....");
	}
}
```

   - Spring annotations `@PostConstruct` and `@PreDestroy` can be used to define lifecycle methods in the Bean Class.
   - The method annotated with `@PostConstruct` is executed after the bean has been constructed and all dependencies have been injected.
   - The method annotated with `@PreDestroy` is executed before the bean is destroyed.

In summary, the Spring framework manages the lifecycle of Spring Beans through the IOC container. The container handles object creation and destruction, and Spring provides mechanisms to execute lifecycle methods for custom initialization and cleanup tasks. These methods can be implemented through interfaces or annotated with appropriate annotations.