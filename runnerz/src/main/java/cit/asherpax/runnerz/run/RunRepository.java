package cit.asherpax.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {
    private List<Run> runs = new ArrayList<>();

    Optional<Run> findById(Integer id){
        return runs.stream()
                .filter(run -> run.id() == id)
                .findFirst();
    }


    List<Run> findall(){
        return runs;
    }

    void create(Run run){
        runs.add(run);
    }

    void update(Run run, Integer id){
        Optional<Run> existingRun = findById(id);
        if(existingRun.isPresent()){
            runs.set(runs.indexOf(existingRun.get()),run);
        }
    }

    void delete(Integer id){

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
                2,
                "Tuesday Run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(60, ChronoUnit.HOURS),
                3,
                Location.INDOOR));
    }
}
