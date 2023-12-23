package org.fsk.graalvmdemo.repository;

import org.fsk.graalvmdemo.models.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {
}
