package ru.otus.architect.user.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {
    private String firstName;
    private String secondName;
    private Integer score;
}