
package com.ouyachou.app.ws.request;


import javax.validation.constraints.*;

public class UserRequest {

    @NotBlank(message="ce champ ne doit pas etre null")
    @Size(min=3, message = "ce message doit au moin 3 caracters")
    private String firstName;

    @NotBlank(message="ce champ ne doit pas etre null")
    @Size(min=3, message = "ce message doit au moin 3 caracters")
    private String lastName;

    @NotBlank(message="ce champ ne doit pas etre null")
    @Email(message= "ce champ doit respecter le format email")
    private String email;

    @NotBlank(message="ce champ ne doit pas etre null")
    @Size(min=8, message = "mot de passe doit avoir au moins 8 caracters")
    @Size(max=12, message = "mot de passe doit avoir au max 12 caracters")
    @Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[*.!@$%^&(){}[]:;<>,.?/~_+-=|\\]).{8,32}$")
    private String password;


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}



