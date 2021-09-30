package com.factorit.crypto.crypto.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "usuario")
public class User {

	@Id
	@NonNull
	@Column(name = "user_name")
	private String userName;

	@NonNull
	@Column(name = "password")
	private String password;

	@NonNull
	@Column(name = "name")
	private String name;

	@NonNull
	@Column(name = "surname")
	private String surname;
	
	@OneToMany(cascade = CascadeType.MERGE, orphanRemoval = true)
	private List<Transaction> transactions;
}
