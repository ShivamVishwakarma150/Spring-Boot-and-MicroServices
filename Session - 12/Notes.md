The given code snippets demonstrate the usage of different bean scopes in the Spring Framework. Let's go through each point and provide a detailed explanation.

**Point 1: Bean scope decides how many objects should be created for a Spring bean.**<br/>
The scope of a bean determines the lifecycle and visibility of the object created by the Spring container. It defines how many instances of a bean should be created and how they should be shared.

**Point 2: The default scope of a Spring bean is singleton (only one object will be created).**<br/>
In the Spring Framework, the default scope for a bean is singleton. This means that only one instance of the bean will be created and shared across the application context.

**Point 3: Scopes available for Spring beans:**<br/>
a) Singleton: Only one instance of the bean is created for the entire application context.<br/>
b) Prototype: A new instance of the bean is created every time it is requested.<br/>
c) Request: A new instance of the bean is created for each HTTP request (web applications only).<br/>
d) Session: A new instance of the bean is created for each HTTP session (web applications only).<br/>

**Point 4: Singleton beans are created when the IOC container starts.**<br/>
Singleton beans are eagerly created by the Spring container when the application context is initialized.

**Point 5: Object creation for prototype beans happens when `context.getBean(..)` method is called.**<br/>
In the case of prototype-scoped beans, a new instance is created every time the `context.getBean(..)` method is called to request the bean.

**Point 6: For prototype beans, a new object is created every time.**<br/>
Prototype-scoped beans create a new instance every time they are requested, so each call to `context.getBean(..)` for a prototype bean results in a new object.

**FAQ: Why does Spring Framework make the default scope as singleton?**<br/>
The Spring Framework chooses the singleton scope as the default to save memory. Since singleton beans are shared across the application context, it avoids unnecessary object creation and memory consumption.

Now, let's analyze the code snippets:

**Code example: Singleton Scope**
```java
package in.shivam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        // Starting IOC Container
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Beans.xml");
        
        Car car1 = context.getBean("Car", Car.class);
        System.out.println(car1.hashCode());
        
        Car car2 = context.getBean("Car", Car.class);
        System.out.println(car2.hashCode());
    }
}
```
**Output:**<br/>
Motor:Constructor<br/>
Car:Constructor<br/>
726281927<br/>
726281927<br/>

Explanation:
- The code initializes the Spring container by creating an application context using the XML configuration file "Spring-Beans.xml".
- Two instances of the "Car" bean are requested from the context using `context.getBean(..)`.
- As the "Car" bean has a singleton scope, the same instance is returned for both `car1` and `car2`.
- The `hashCode()` method is used to print the memory address of each object, showing that both `car1` and `car2` refer to the same instance of the "Car" bean.

**Code example: Prototype Scope**
```java
package in.shivam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        // Starting IOC Container
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Beans.xml");
        
        Car car1 = context.getBean("Car", Car.class);
        System.out.println(car1.hashCode());
        


        Car car2 = context.getBean("Car", Car.class);
        System.out.println(car2.hashCode());
    }
}
```
**Output:**<br/>
Car:Constructor<br/>
1800659519<br/>
Car:Constructor<br/>
1691538257<br/>

Explanation:
- Similar to the previous example, the Spring container is initialized using the XML configuration file.
- Two instances of the "Car" bean are requested from the context using `context.getBean(..)`.
- As the "Car" bean has a prototype scope, a new instance is created for each call to `getBean(..)`.
- The `hashCode()` method shows that `car1` and `car2` represent different instances of the "Car" bean.

**Conclusion:**
In summary, the bean scope determines the lifecycle and visibility of objects created by the Spring container. The default scope is singleton, where only one instance is created and shared. However, you can configure different scopes like prototype, request, or session to create multiple instances. The choice of scope depends on the specific requirements of your application. Singleton scope optimizes memory usage, while prototype scope ensures a new instance is created each time.