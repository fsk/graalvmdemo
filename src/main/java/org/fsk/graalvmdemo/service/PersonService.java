package org.fsk.graalvmdemo.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.fsk.graalvmdemo.models.Person;
import org.fsk.graalvmdemo.repository.PersonRepository;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {


    private final PersonRepository personRepository;


    public void loadJsonData() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        for (int i = 0; i < 1000; i++) {
        File file = new ClassPathResource("demo.json").getFile();
        List<Person> persons = mapper.readValue(file, new TypeReference<>() {});
            personRepository.saveAll(persons);
        }
    }

    public List<Person> findAllPersonSearchNameContains(String param) {

        List<Person> personList = personRepository
                .findAll();

        List<Person> resultList = personList
                .stream()
                .filter(item -> item.getFirstName().contains(param))
                .toList();

        return resultList;
    }
}
