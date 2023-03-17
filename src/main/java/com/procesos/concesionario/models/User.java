package com.procesos.concesionario.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "firs_tName")
    private String firstName;
    @Column(name = "las_tName")
    private String lastName;
    private String email;
    private String password;
    private String address;
    private LocalDate birthday;
}
