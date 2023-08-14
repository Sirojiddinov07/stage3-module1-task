package com.mjc.school.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorModel {
    private Long id;
    private String  name;

    public AuthorModel(Long id){
        this.id = id;
    }

//    @Override
//    public boolean equals(Object o){
//        if (this == o)
//            return true;
//        if (o == null || getClass()!= o.getClass());
//            return false;
//        AuthorModel authorModel = (AuthorModel) o;
//        return id.equals(authorModel.id);
//    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}

