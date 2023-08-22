package com.georgebanin.studentcourses.entity;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
public class ObjectNotValidException extends RuntimeException {

    private final Set<String> errorMessages;


}
