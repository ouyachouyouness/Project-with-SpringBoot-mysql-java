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

    @Column(nullable=false,length=50)
    private String lastName;

    @Column(nullable=false,length=120, unique = true)
    private String email;

    @Column(nullable=false)
    private String encryptedPassword;

    @Column(nullable=true)
    private String emailVerificationToken;

    @Column(nullable = false)
    private Boolean emailVerificationStatus = false;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Boolean getEmailVerificationStatuss() {
        return emailVerificationStatus;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public String getEmailVerificationToken() {
        return emailVerificationToken;
    }

    public void setEmailVerificationToken(String emailVerificationToken) {
        this.emailVerificationToken = emailVerificationToken;
    }

    public void setEmailVerificationStatus(String emailVerificationStatuss) {
        this.emailVerificationStatus = emailVerificationStatus;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

}
