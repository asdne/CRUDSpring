package ru.asd.CRUDSpring.service;

import ru.asd.CRUDSpring.entity.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAll();

    void savePerson(Person person);

    void deletePersonById(Long id);

    void addPerson(Person person);

    Person getPersonById(Long id);

    Person updatePerson(Person person);
}
