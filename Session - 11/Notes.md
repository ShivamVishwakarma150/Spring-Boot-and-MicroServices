# Let's go through each point you mentioned and provide a detailed explanation:

1) Setter Injection using `<property/>` tag:
   Setter injection is a type of dependency injection where dependencies are set through setter methods. In the XML configuration file, you can use the `<property/>` tag to perform setter injection. Here's an example:

```xml
<bean id="billCollector" class="in.shivam.BillCollector">
    <property name="payment" ref="upi"/>
</bean>
```

In the above code, the `BillCollector` bean is configured with a property called `payment` using the `setPayment()` setter method. The `ref` attribute of the `<property/>` tag refers to the bean ID of the `upi` bean, which will be injected into the `BillCollector` bean.

2) Constructor Injection using `<constructor-arg/>` tag:
   Constructor injection is a type of dependency injection where dependencies are provided through a constructor. In the XML configuration file, you can use the `<constructor-arg/>` tag to perform constructor injection. Here's an example:

```xml
<bean id="billCollector" class="in.shivam.BillCollector">
    <constructor-arg name="payment" ref="upi"/>
</bean>
```

In the above code, the `BillCollector` bean is configured with a constructor argument named `payment`. The `ref` attribute of the `<constructor-arg/>` tag refers to the bean ID of the `upi` bean, which will be passed as an argument to the `BillCollector` constructor.

3) Setter Injection overriding Constructor Injection:
   When both setter injection and constructor injection are used for the same variable in a bean configuration, the setter injection will override the value set by constructor injection. This is because the setter method is called after the constructor is invoked, allowing it to reinitialize the variable.

```xml
<bean id="billCollector" class="in.shivam.BillCollector">
    <property name="payment" ref="creditCard"/>
    <constructor-arg name="payment" ref="upi"/>
</bean>
```

In the above code, the `BillCollector` bean is configured with both a setter injection and a constructor injection for the `payment` property. The `payment` property is initially set to the `upi` bean through the constructor injection. However, the subsequent setter injection sets the `payment` property to the `creditCard` bean, effectively overriding the value set by the constructor.

By understanding these points, you have a clear understanding of how to perform setter injection and constructor injection using the appropriate XML tags in the Spring configuration file. Additionally, you now know the behavior when both setter and constructor injections are used for the same variable, with the setter injection taking precedence.

<br/>
<br/>
<br/>

# Here's a diagrammatic representation of the concepts you mentioned:

1) Setter Injection using `<property/>` tag:

```
           +-----------------+
           |   BillCollector |
           +-----------------+
           |     payment     | <-- Setter Injection
           +-----------------+
                  /_\
                   |
                   |
           +-----------------+
           |      UpiPayment  |
           +-----------------+
```

In this diagram, the `BillCollector` bean has a `payment` property, which is injected using the setter method `setPayment()`. The `payment` property is set with an instance of the `UpiPayment` bean.

2) Constructor Injection using `<constructor-arg/>` tag:

```
           +-----------------+
           |   BillCollector |
           +-----------------+
           |     payment     | <-- Constructor Injection
           +-----------------+
                  /_\
                   |
                   |
           +-----------------+
           |      UpiPayment  |
           +-----------------+
```

In this diagram, the `BillCollector` bean has a constructor that accepts a `payment` argument. The `payment` property is initialized through the constructor argument with an instance of the `UpiPayment` bean.

3) Setter Injection overriding Constructor Injection:

```
           +-----------------+
           |   BillCollector |
           +-----------------+
           |     payment     | <-- Setter Injection (Overrides Constructor Injection)
           +-----------------+
                  /_\
                   |
                   |
           +-----------------+
           |CreditCardPayment|
           +-----------------+

           +-----------------+
           |   UpiPayment    |
           +-----------------+
```

In this diagram, the `BillCollector` bean has both setter and constructor injections for the `payment` property. Initially, the `payment` property is set through the constructor with an instance of the `UpiPayment` bean. However, the subsequent setter injection overrides the value by setting the `payment` property with an instance of the `CreditCardPayment` bean.

These diagrams visually represent how the dependencies are injected using setter injection, constructor injection, and how setter injection can override constructor injection when both are used for the same variable.