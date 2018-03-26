package net.mainclass.sample;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@ComponentScan("net.mainclass.sample")
@PropertySource("file:config/app.properties")
public class AppContext {
}
