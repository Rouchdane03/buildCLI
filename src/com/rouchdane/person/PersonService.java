package com.rouchdane.person;

import static com.rouchdane.utils.StringUtils.isEmpty;

public class PersonService {

    public int addPerson(Person person){
        if (isEmpty(person.getName())){
            throw new IllegalArgumentException("name cannot be blank");
        }
        //store person in database
        return 1;
    }
}
