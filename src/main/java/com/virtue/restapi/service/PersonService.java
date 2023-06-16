package com.virtue.restapi.service;


import com.virtue.restapi.persistance.Person;
import com.virtue.restapi.persistance.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> getAll(){
        return this.repository.findAll();
    }

    public Person getById(long id){
        return this.repository.findById(id).get();
    }

    public Person add(Person person){
        return this.repository.save(person);
    }

    public Person update(long id, Person person){
        Optional<Person> per = this.repository.findById(id);
        if (per.isPresent()){
            per.get().setName(person.getName());
            return this.repository.save(per.get());
        }
        throw new RuntimeException();
    }

    public void delete(long id){
        this.repository.deleteById(id);
    }
}
