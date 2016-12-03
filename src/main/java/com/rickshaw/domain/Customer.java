package com.rickshaw.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

    @NotNull
	private String firstname;

    @NotNull
	private String lastname;

    @NotNull
	private String email;

    @NotNull
	private String password;

    // private List<Order> orders = new ArrayList<>();
}
