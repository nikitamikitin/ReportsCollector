package com.reportscollector.demo.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;


@Document(collection = "User")
public class User extends BaseEntity {

    @Email
    private String email;

    @Size(min = 6, max = 15)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)

    private String password;

    public User() {

    }

    public User(String id,String email,String password){
        super(id);
        this.email=email;
        this.password=password;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
