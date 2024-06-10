package com.rca.cics;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    @Column(unique = true, nullable = false)
    private String email;
    @Transient
    private int age;

    public int getAge(){
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }
    private void setAge( int age){
        this.age = age;
    }
}
