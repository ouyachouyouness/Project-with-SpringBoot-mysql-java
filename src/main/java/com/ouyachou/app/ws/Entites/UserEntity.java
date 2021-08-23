package com.ouyachou.app.ws.Entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="users")
public class UserEntity implements Serializable {

	
	private static final long serialVersionUID = 6543065294379924202L;
	@Id
	@GeneratedValue
	private long id;
	private String userId;
	
	@Column(nullable=false, length=50)
	
	private String firstName;
	@Column(nullable=false)

	private String lastName;
	private String email;
	private String encryptedPassword;
	private String emilVerificationToken;
	private Boolean emailVerificationStatus;
	
	
	
}
