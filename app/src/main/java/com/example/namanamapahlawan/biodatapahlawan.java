package com.example.namanamapahlawan;

import java.io.Serializable;

public class biodatapahlawan implements Serializable {
    private String name;
    private String birth_year;
    private String death_year;
    private String description;
    private String ascension_year;

    public String getName() {
        return name;
    }

    public String getBirth_year() {
        return birth_year;
    }

    public String getDeath_year() {
        return death_year;
    }

    public String getDescription() {
        return description;
    }

    public String getAscension_year() {
        return ascension_year;
    }
}

