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
        Objects.requireNonNull(startedOn, "Started On cannot be null");
        Objects.requireNonNull(completedOn, "Completed On cannot be null");

        if (!completedOn.isAfter(startedOn)) {
            throw new IllegalArgumentException("Completed On must be after Started On");
        }
    }
}
