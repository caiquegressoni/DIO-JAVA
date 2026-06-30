package com.example.annotation.model;

import com.example.annotation.annotations.SerializerType;

@SerializerType
public record User(long id, String fullName, int age, double salary) {
}
