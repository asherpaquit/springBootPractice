package cit.asherpax.runnerz.run;


import java.time.LocalDateTime;
import java.util.Objects;

public record Run (

     Integer id,
     String title,
     LocalDateTime startedOn,
     LocalDateTime completedOn,
     Integer miles,
     Location location

){

}
