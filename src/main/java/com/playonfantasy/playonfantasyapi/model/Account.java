package com.playonfantasy.playonfantasyapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="accounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



    @Column(unique=true)
    @Email(message = "Email is not valid")
    @NotNull
    private String email;

    @NotNull
    private String password;

    @OneToMany(mappedBy="account")
    @JsonManagedReference(value="account-team")
    private List<Team> teams;

}
