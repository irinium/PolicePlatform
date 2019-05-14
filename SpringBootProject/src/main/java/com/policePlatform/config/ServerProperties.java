package com.policePlatform.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Component
@ConfigurationProperties
public  class ServerProperties{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String person;

    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person){
        this.person = person;
    }
    @Override
    public String toString() {
        return String.format(
                "ServerProperties[id=%d, person='%s'",
                id, person);
    }

}