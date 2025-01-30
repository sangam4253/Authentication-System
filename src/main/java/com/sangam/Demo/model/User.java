package com.sangam.Demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users") // Maps this entity to the "users" table in the database
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the primary key
    private Long id;

    @Column(nullable = false) // Marks this column as NOT NULL
    private String name;

    @Column(nullable = false, unique = true) // Ensures emails are unique
    private String email;

    @Column(nullable = false) // Marks the password column as NOT NULL
    private String password;
    private String resetToken;
    
    public User() {
    	
    }
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
	public String getResetToken() {
		return resetToken;
	}
	public void setResetToken(String resetToken) {
		this.resetToken = resetToken;
	}
}
