package com.decagon.scorecardapi.exceptions;

public class SquadAlreadyExistException extends RuntimeException{
    public SquadAlreadyExistException(String message) {
        super(message);
    }
}
