package com.sid.itcodeapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UserEntity {

    private String firstname;
    private String lastname;
    @Id
    private String email;
    @Column(length = 60)
    private String password;

}
