package net.mainclass.sample;

import com.fasterxml.jackson.databind.ObjectMapper;
import methodx.MethodxHandler;
import org.eclipse.jetty.server.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Main {

    private static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {

        log.info("starting spring application context...");
        ApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
        UserService userService = context.getBean(UserService.class);
        Environment env = context.getBean(Environment.class);

        log.info("starting jetty server...");
        Integer port = env.getProperty("server.port", Integer.class);
        Server server = new Server(port);
        server.setHandler(new MethodxHandler.Builder()
                .addBean("userService", userService)
                .setObjectMapper(new ObjectMapper())
                .build());
        server.start();

        log.info("jetty server has started at port {}", port);
        server.join();
    }
}
