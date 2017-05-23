package edu.mum;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AmqpClientMain {
    @SuppressWarnings("resource")
	public static void main(String[] args) {
        new GenericXmlApplicationContext("classpath:META-INF/spring/order-app-context.xml");
       }
}
