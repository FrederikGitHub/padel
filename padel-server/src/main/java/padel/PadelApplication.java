package padel;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by EXT487 on 28/02/2017.
 */

@SpringBootApplication
//@EnableAutoConfiguration(exclude = { FreeMarkerAutoConfiguration.class })
public class PadelApplication extends SpringBootServletInitializer {



    public static void main(String[] args) {
        SpringApplication.run(PadelApplication.class, args);
        List<String> letters = Arrays.asList("A","B","C","D","E");
        List<String> klinkers = getKlinkers(letters);
        letters.removeAll(klinkers);
        System.out.println("letters" + letters);

    }

    public static List<String> getKlinkers(List<String> letters){
        List<String> klinkers = new ArrayList<>();
        for (String letter:letters){
            if (letter.equalsIgnoreCase("E")){
                klinkers.add(letter);
            }
        }
        return klinkers;
    }

    //this method will be called in a container to bootstrap the application
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PadelApplication.class);
    }

    /*1 to 7*/
    public static int getDayNumberNew(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return day.getValue();
    }




}
