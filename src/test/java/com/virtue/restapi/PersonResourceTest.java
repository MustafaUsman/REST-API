package com.virtue.restapi.resource;

import com.virtue.restapi.persistance.Person;
import com.virtue.restapi.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
public class PersonResourceTest {

    @Mock
    private PersonService personService;

    private PersonResource personResource;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        personResource = new PersonResource(personService);
    }

    @Test
    public void testGetAll() {
        // Arrange
        List<Person> persons = Arrays.asList(new Person(), new Person());
        when(personService.getAll()).thenReturn(persons);

        // Act
        List<Person> result = personResource.getAll();

        // Assert
        assertEquals(persons.size(), result.size());
        verify(personService, times(1)).getAll();
    }

    @Test
    public void testGetById() {
        // Arrange
        long id = 1;
        Person person = new Person();
        when(personService.getById(id)).thenReturn(person);

        // Act
        Person result = personResource.getById(id);

        // Assert
        assertEquals(person, result);
        verify(personService, times(1)).getById(id);
    }

    @Test
    public void testAdd() {
        // Arrange
        Person person = new Person();
        // Set properties for the person object
        person.setName("Kamran");
        // ...

        when(personService.add(any(Person.class))).thenReturn(person);

        // Act
        Person result = personResource.add(person);

        // Assert
        assertEquals(person, result);
        verify(personService, times(1)).add(any(Person.class));
    }

    @Test
    public void testUpdate() {
        // Arrange
        long id = 1;
        Person person = new Person();
        // Set properties for the updated person object
        person.setName("Updated Name");
        // ...

        when(personService.update(eq(id), any(Person.class))).thenReturn(person);

        // Act
        Person result = personResource.update(id, person);

        // Assert
        assertEquals(person, result);
        verify(personService, times(1)).update(eq(id), any(Person.class));
    }

    @Test
    public void testDelete() {
        // Arrange
        long id = 1;

        // Act
        personResource.delete(id);

        // Assert
        verify(personService, times(1)).delete(id);
    }

    // Add more test methods for other endpoints if needed

    // ...
}

