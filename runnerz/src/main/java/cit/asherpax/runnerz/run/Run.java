package cit.asherpax.runnerz.run;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;
import java.util.Objects;

public record Run (

     Integer id,
     @NotEmpty
     String title,
     LocalDateTime startedOn,
     LocalDateTime completedOn,
     @Positive
     Integer miles,
     Location location

)
{
    public Run{
        if(!completedOn.isAfter(startedOn())){
            throw new IllegalArgumentException("Completed On Must be after Started On");
        }
    }
}
