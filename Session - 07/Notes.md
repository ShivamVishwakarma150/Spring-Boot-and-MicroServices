Dependency injection is a design pattern and technique used in object-oriented programming to achieve loose coupling between classes. It involves injecting one class object (dependency) into another class object that requires it. This allows for better maintainability, flexibility, and testability of the code.

There are different approaches to perform dependency injection:

1. Constructor Injection:
   In constructor injection, dependencies are provided through a class constructor. The dependent class specifies a constructor that takes the required dependency as a parameter. The dependency is then passed to the class during instantiation.

   Example:
   ```java
   public class BillCollector {
       private IPayment payment;

       public BillCollector(IPayment payment) {
           this.payment = payment;
       }

       // Other methods and code...
   }
   ```

   In the above example, the `BillCollector` class has a dependency on the `IPayment` interface, and it is injected through the constructor. This allows for a clear and explicit declaration of dependencies.

2. Setter Injection:
   In setter injection, dependencies are provided through setter methods of the dependent class. The dependent class exposes a setter method that accepts the required dependency as a parameter. The dependency is then set using this method.

   Example:
   ```java
   public class BillCollector {
       private IPayment payment;

       public void setPayment(IPayment payment) {
           this.payment = payment;
       }

       // Other methods and code...
   }
   ```

   In the above example, the `BillCollector` class provides a setter method `setPayment` to inject the `IPayment` dependency. This allows for more flexibility as the dependency can be changed at runtime.

Both constructor injection and setter injection are valid approaches for dependency injection, and the choice between them depends on the specific requirements and design considerations of the application.

In the provided code example, the `BillCollector` class demonstrates both constructor injection and setter injection. The `Test` class shows how to instantiate the `BillCollector` class using both approaches.

Note: In the code example, the specific implementation of the `IPayment` interface, `CreditCardPayment`, is used as the dependency. However, the actual implementation can be swapped with any other class implementing the `IPayment` interface without changing the code in the `BillCollector` class. This demonstrates the flexibility and loose coupling achieved through dependency injection.