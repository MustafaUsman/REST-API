package com.virtue.restapi;

import com.virtue.restapi.config.SwaggerConfig;
import com.virtue.restapi.persistance.Person;
import com.virtue.restapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;



@Import(SwaggerConfig.class)
@SpringBootApplication
@ComponentScan(basePackages = "com.virtue.restapi.service")
@EnableSwagger2
public class RestapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestapiApplication.class, args);
    }

    @Component
    public class PersonDataPrinter implements CommandLineRunner {

        private final PersonService personService;

        @Autowired
        public PersonDataPrinter(PersonService personService) {
            this.personService = personService;
        }

        @Override
        public void run(String... args) {
            // Retrieve all entries from PersonDB
            List<Person> persons = personService.getAll();

            // Print the retrieved entries
            for (Person person : persons) {
                System.out.println(person.toString());
            }

//            // Create a new person and save it to the DB
//            Person newPerson = new Person();
//            newPerson.setName("Kamran");
//            newPerson.setContact_num("1234");
//            personService.add(newPerson);
//
//            // Retrieve all entries from PersonDB after adding the new person
//            List<Person> updatedPersons = personService.getAll();
//
//            // Print the updated entries
//            for (Person person : updatedPersons) {
//                System.out.println(person.toString());
//            }
        }
    }
}