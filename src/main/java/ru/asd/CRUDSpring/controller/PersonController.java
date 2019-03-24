package ru.asd.CRUDSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.asd.CRUDSpring.entity.Person;
import ru.asd.CRUDSpring.service.PersonService;

import java.util.List;
import java.util.Map;

@Controller

public class PersonController {
    @Autowired
    PersonService personService;

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String list(@RequestParam Map<String, String> allRequestParams, ModelMap model) {
        System.out.println("dsfsdfsdf");
        for (Map.Entry entry : allRequestParams.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        List<Person> persons = personService.getAll();
        for (Person p : persons) {
            System.out.println(p);
        }
        model.addAttribute("persons", persons);
        //  personService.deletePersonById(6);

        return "index1";
    }

    @RequestMapping("/")
    public String listAll(ModelMap model) {
        System.out.println("mainpage");
        List<Person> persons = personService.getAll();

        model.addAttribute("persons", persons);

        return "index1";
    }

    @RequestMapping(value = "/new")
    public String newPerson(@RequestParam Map<String, String> allRequestParams) {
        System.out.println("New Person");
        if (allRequestParams.get("surname") != null) {
            System.out.println("Создаём");
            Person p = new Person(allRequestParams.get("surname"), allRequestParams.get("name"), allRequestParams.get("address"));
            personService.addPerson(p);
        }
        return "new";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editPerson(@RequestParam Map<String, String> allRequestParams, ModelMap model) {
        System.out.println("EditPage");
        Person person = personService.getPersonById(Long.parseLong(allRequestParams.get("id")));
        model.addAttribute("person", person);
        return "edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String esPerson(@RequestParam Map<String, String> allRequestParams, ModelMap model) {
        Person p = new Person(allRequestParams.get("surname"), allRequestParams.get("name"), allRequestParams.get("address"));
        p.setId(Long.parseLong(allRequestParams.get("id")));
        Person retPers = personService.updatePerson(p);
        return "redirect:./";
    }

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public String dPerson(@RequestParam Map<String, String> allRequestParams, ModelMap model) {
        personService.deletePersonById(Long.parseLong(allRequestParams.get("id")));
        return "redirect:./";
    }

}
