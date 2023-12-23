package org.fsk.graalvmdemo.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Person {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String ipAddress;
    private String city;
    private int age;
    private String country;
    private String language;
    private String university;
    private String jobTitle;
    private String companyName;
    private String phone;
    private String iban;

}
