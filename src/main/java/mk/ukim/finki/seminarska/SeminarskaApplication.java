package mk.ukim.finki.seminarska;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SeminarskaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeminarskaApplication.class, args);
    }

}
