package com.caribou.bank.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "m_appuser")
@SequenceGenerator(name = "sequence-generator", initialValue = 1, sequenceName = "user_sequence")
public class User extends AbstractPersistableCustom implements Serializable {

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

    public User() {
    }
    
/*  public User(String username, String password, String role) {
    super();
    this.username = username;
    this.password = password;
    this.role = role;
  }
  */

	  public String getUsername() {
	    return username;
	  }

	  public void setUsername(String username) {
	    this.username = username;
	  }

	  public String getPassword() {
	    return password;
	  }

	  public void setPassword(String password) {
	    this.password = password;
	  }

	  public String getRole() {
	    return role;
	  }

	  public void setRole(String role) {
	    this.role = role;
	  }
	}