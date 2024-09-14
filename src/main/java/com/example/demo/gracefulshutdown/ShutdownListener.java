package com.example.demo.gracefulshutdown;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

@Component
public class ShutdownListener implements ApplicationListener<ApplicationEvent> {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ContextClosedEvent) {
            // Handle shutdown event
            System.out.println("Application is shutting down.");
            // Perform cleanup tasks or any necessary operations before shutdown
        }
    }
}
