package org.fsk.graalvmdemo.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.fsk.graalvmdemo.models.Person;
import org.fsk.graalvmdemo.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/person")
@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("/loadData")
    public void saveFakeDataToMongoDb() throws Exception {
        personService.loadJsonData();
    }

    @GetMapping("/serchByParamFromFirstName/{param}")
    public List<Person> searchByParamFromFirstName(@PathVariable("param") String param) {
        return personService.findAllPersonSearchNameContains(param);
    }
}
