package com.cts.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class PersonItemProcessor implements ItemProcessor<com.cts.input.Person, com.cts.model.Person> {//ItemProcessor<Input, Output>

    private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);

    @Override
    public com.cts.model.Person process(final com.cts.input.Person person) throws Exception {
    	final String id = person.getId();
        final String firstName = person.getFirstName().toUpperCase();
        final String lastName = person.getLastName().toUpperCase();

        final com.cts.model.Person transformedPerson = new com.cts.model.Person(id,firstName, lastName);

        log.info("Converting (" + person + ") into (" + transformedPerson + ")");

        return transformedPerson;
    }

}
