package com.decagon.scorecardapi.domain.entities.enums;

public enum Gender {
    MALE("male"),
    FEMALE("female");

    private String display;

    Gender(String display) {
        this.display = display;
    }

}
