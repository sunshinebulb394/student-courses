package com.georgebanin.studentcourses.entity;

import lombok.Builder;

@Builder
public record Cat(String id,String url,Integer width,Integer height) {
}
