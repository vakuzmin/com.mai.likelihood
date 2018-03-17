package com.mai;

import com.mai.configuration.SpringBootWebApplicationConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.core.env.Environment;


public class SpringBootWebApplication {

    private static final Logger LOGGER = LogManager.getLogger(SpringBootWebApplication.class);

    public static void main(String[] args) throws Exception {

        SpringApplication application = new SpringApplication(SpringBootWebApplicationConfig.class);
        Environment env = application.run(args).getEnvironment();
        LOGGER.info("\n----------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\thttp://localhost:{}/welcome\n\t" +
                        "\n----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                env.getProperty("server.port"));
    }
}
