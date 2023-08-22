package com.georgebanin.studentcourses.entity;

import lombok.Builder;

import java.util.List;

@Builder
public record StudentRecord(Integer id, String name, List<String> courses) {
}
