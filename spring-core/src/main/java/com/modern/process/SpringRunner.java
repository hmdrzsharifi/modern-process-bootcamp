package com.modern.process;

import com.modern.process.domain.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringRunner {

    public static void main(String[] args) {
        Car toyota = getCarFromJavaConfig();
        System.out.println(toyota);

        toyota = getCarFromXml();
        System.out.println(toyota);
    }

    private static Car getCarFromXml() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        return context.getBean(Car.class);
    }

    private static Car getCarFromJavaConfig() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        return context.getBean(Car.class);
    }
}
