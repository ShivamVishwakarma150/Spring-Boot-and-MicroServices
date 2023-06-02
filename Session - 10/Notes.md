# Here provide a detailed explanation of each step you mentioned for building your first application using the Spring Framework.

1) Open STS IDE and Create Maven Project:
   STS (Spring Tool Suite) is an integrated development environment based on Eclipse, specifically designed for developing Spring applications. You can download and install STS from the official website. Once you have STS installed, you can create a new Maven project using the STS IDE.

2) Add Spring-Context Dependency in project pom.xml file:
   The pom.xml file is the configuration file for Maven projects. To use the Spring Framework, you need to include the necessary dependencies in this file. In this case, you need to add the "spring-context" dependency to the <dependencies> section of your pom.xml file. This dependency provides the core functionality of the Spring Framework.

3) Create Bean Classes:
   In the Spring Framework, a bean is an object that is managed by the Spring container. Bean classes are regular Java classes that you define to be managed by Spring. In your case, you need to create several bean classes: IPayment, CreditCardPayment, DebitCardPayment, UpiPayment, BillCollector, and Test. These classes represent different payment methods and a bill collector.

4) Create Beans configuration file and configure our classes as Spring Beans:
   In Spring, you can configure your beans either through XML-based configuration or Java-based configuration. In your case, you are using XML-based configuration. You need to create an XML file (e.g., Spring-Beans.xml) where you define your beans and their configurations. Inside this file, you use the <bean> element to define each bean and its corresponding class. You also use the <property> element to configure dependencies between beans, in this case, through setter injection.

5) Start the IOC container and test the Application:
   Inversion of Control (IOC) is a core principle of the Spring Framework. The IOC container is responsible for managing beans and their dependencies. To start the IOC container and test your application, you need to write a main method in a class (e.g., Test.java). In this method, you create an instance of the ApplicationContext, which represents the IOC container. You provide the name of the beans configuration file ("Spring-Beans.xml") as input to the ApplicationContext. Then, you can retrieve the desired bean from the container using the getBean() method, passing the bean's ID and its class type. Finally, you can call methods on the retrieved bean to test your application.

By following these steps, you are setting up a Spring application with bean classes, configuring them as Spring beans, and using the IOC container to manage and test your beans. The Spring Framework provides powerful features for dependency injection, aspect-oriented programming, and other functionalities that can greatly simplify and enhance your application development process.

<br/>
<br/>
<br/>

# Let's go through each step and provide code explanations for better understanding.

1) Open STS IDE and Create Maven Project:
   In this step, you open the Spring Tool Suite (STS) IDE and create a new Maven project. STS provides a development environment specifically tailored for Spring applications. Creating a Maven project ensures that your project's dependencies and build process are managed efficiently.

2) Add Spring-Context Dependency in project pom.xml file:
   In your project's pom.xml file, you include the necessary dependencies. Here, you add the "spring-context" dependency, which is a core component of the Spring Framework. By adding this dependency, you ensure that your project has access to the Spring Context module and its functionalities.

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.3.20</version>
    </dependency>
</dependencies>
```

3) Create Bean Classes:
   In this step, you create several bean classes that will be managed by the Spring Framework. These classes represent different payment methods (IPayment, CreditCardPayment, DebitCardPayment, UpiPayment) and a bill collector (BillCollector). Additionally, you have a Test class that contains the main method for testing your application.

```java
public interface IPayment {
    void makePayment(double amount);
}

public class CreditCardPayment implements IPayment {
    @Override
    public void makePayment(double amount) {
        System.out.println("Making credit card payment of $" + amount);
    }
}

public class DebitCardPayment implements IPayment {
    @Override
    public void makePayment(double amount) {
        System.out.println("Making debit card payment of $" + amount);
    }
}

public class UpiPayment implements IPayment {
    @Override
    public void makePayment(double amount) {
        System.out.println("Making UPI payment of $" + amount);
    }
}

public class BillCollector {
    private IPayment payment;

    public void setPayment(IPayment payment) {
        this.payment = payment;
    }

    public void collectPayment(double amount) {
        System.out.println("Collecting payment of $" + amount);
        payment.makePayment(amount);
    }
}

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Beans.xml");
        BillCollector billCollector = context.getBean("billCollector", BillCollector.class);
        billCollector.collectPayment(1400.00);
    }
}
```

4) Create Beans configuration file and configure our classes as Spring Beans:
   In this step, you create an XML file (Spring-Beans.xml) to define your beans and their configurations. The <bean> elements define each bean, specifying its ID and class. You also use the <property> element within the BillCollector bean definition to configure the dependency injection. Here, the "payment" property is set using the "creditCard" bean.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="creditCard" class="in.shivam.CreditCardPayment"/>
    
    <bean id="debitCard" class="in.shivam.DebitCardPayment"/>
    
    <bean id="upi" class="in.shivam.UpiPayment"/>
    
    <bean id="billCollector" class="in.shivam

.BillCollector">
        <property name="payment" ref="creditCard"/>
    </bean>

</beans>
```

5) Start the IOC container and test the Application:
   In this final step, you write the main method in the Test class to start the Inversion of Control (IOC) container and test your application. The ApplicationContext is created, specifying the beans configuration file ("Spring-Beans.xml") as input. Then, you retrieve the "billCollector" bean from the container using getBean() and its associated class type. Finally, you call the collectPayment() method on the billCollector object to test the application.

```java
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Beans.xml");
        BillCollector billCollector = context.getBean("billCollector", BillCollector.class);
        billCollector.collectPayment(1400.00);
    }
}
```

When you run the Test class, the IOC container is initialized, and the BillCollector bean is created and configured with the CreditCardPayment bean as a dependency. The collectPayment() method is then called, resulting in the message "Collecting payment of $1400.00" and "Making credit card payment of $1400.00" being printed to the console.

These steps, along with the provided code explanations, guide you through the process of building your first Spring application. The Spring Framework's IOC container and bean management features enable loose coupling and easier configuration of your application components.