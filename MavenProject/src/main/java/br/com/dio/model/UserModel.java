package br.com.dio.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class UserModel {
    private int code;
    private String username;
    private LocalDate birthDay;
}
