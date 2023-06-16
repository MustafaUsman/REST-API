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

    // Write similar test methods for other endpoints

    // ...

}
