package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class SkiResort {

    private final UUID IdResort;
    @NotBlank
    private final String Name;
    @NotBlank
    private final String Description;


    public SkiResort(@JsonProperty("id") UUID id,
                     @JsonProperty("Name") String name,
                     @JsonProperty("Description") String description) {
        this.Name = name;
        this.Description = description;
        this.IdResort = id;
    }

    public UUID getIdResort() {

        return IdResort;
    }

    public String getName() {

        return Name;
    }

    public String getDescription() {

        return Description;
    }
}