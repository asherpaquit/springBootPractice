package cit.asherpax.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RunRepository {
    private List<Run> runs = new ArrayList<>();

    Run findById(Integer id){
        return runs.stream()
                .filter(run -> run.id() = id)
                .findFirst()
                .get();
    }


    List<Run> findall(){
        return runs;
    }

    @PostConstruct
    private void init(){
        runs.add(new Run(
                1,
                "Monday Run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(2, ChronoUnit.HOURS),
                5,
                Location.OUTDOOR));
        runs.add(new Run(
                1,
                "Tuesday Run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(60, ChronoUnit.HOURS),
                3,
                Location.INDOOR));
    }
}
