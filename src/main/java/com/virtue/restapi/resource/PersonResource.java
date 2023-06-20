package com.virtue.restapi.resource;

import com.virtue.restapi.persistance.Person;
import com.virtue.restapi.service.PersonService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
public class PersonResource {
    PersonService service;

    public PersonResource(PersonService service) {
        this.service = service;
    }
    @GetMapping(value = "/persons")
    public List<Person> getAll(){
        return this.service.getAll();
    }
    @GetMapping(value = "/persons/{id}")
    public Person getById(@PathVariable long id){
        return this.service.getById(id);
    }
    @PostMapping(value = "/persons")
    public Person add(@RequestBody Person person){
        return this.service.add(person);
    }
    @PutMapping(value = "/persons/{id}", consumes = "applications/json")
    public Person update(@PathVariable long id, @RequestBody Person person){
        return this.service.update(id, person);
    }
    @DeleteMapping(value="/persons/{id}")
    public void delete(@PathVariable long id){
        this.service.delete(id);
    }
}

