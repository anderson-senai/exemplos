package exemplo.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Executar pelo Eclipse: mvn spring-boot:run
 * Executar pelo Command: java -jar target\exemplo-0.0.1-SNAPSHOT.jar
 *
 * @author anderson.kruger
 *
 */
@SpringBootApplication
@EntityScan(basePackages = { "exemplo.jpa" })
@EnableJpaRepositories(basePackages = { "exemplo.repos" })
@ComponentScan(basePackages = {"exemplo.controller"})
public class Application {
      public static void main(String[] args) {
            SpringApplication.run(Application.class, args);
      }
}