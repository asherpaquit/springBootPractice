package cit.asherpax.runnerz.run;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// @RestController annotation indicates that this class is a controller where every method returns a
// domain object instead of a view. It combines @Controller and @ResponseBody.
@RestController
@RequestMapping("/api/runs")
public class RunController {

    private final RunRepository runRepository;

    // Constructor injection is used here to inject the RunRepository dependency into this controller.
    public RunController(RunRepository runRepository){
        this.runRepository = runRepository;
    }

    // @GetMapping annotation maps HTTP GET requests onto specific handler methods.
    // It is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET).
    @GetMapping("")
    List<Run> findall(){
        return runRepository.findall();
    }

    @GetMapping("/hello")
    String display(){
        return "Hello asher pax";
    }
    // @GetMapping annotation maps HTTP GET requests onto specific handler methods. Here it is mapping requests to "/api/runs/{id}".
    // @PathVariable annotation indicates that a method parameter should be bound to a URI template variable.
    // The {id} part of the URI is bound to the id parameter of the method.
    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id){
        // This method handles GET requests to "/api/runs/{id}" and returns the Run object with the specified id.
        Optional<Run> run = runRepository.findById(id);
        if(run.isEmpty()){
            throw new RunNotFoundException();
        }
        return run.get();
    }

    //post
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@RequestBody Run run){
        runRepository.create(run);
    }


    //put
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@RequestBody Run run, @PathVariable Integer id){
        runRepository.update(run,id);
    }


    //delete
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        runRepository.delete(id);
    }
}
