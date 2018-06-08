package com.cts.input;

import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class Person {
	
	@Id
	private String id;
    private String lastName;
    private String firstName;

    public Person(String id, String firstName, String lastName) {
    	this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

   

}
