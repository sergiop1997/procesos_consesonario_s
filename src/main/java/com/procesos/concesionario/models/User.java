package com.procesos.concesionario.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity

public class User {
    @Id
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
