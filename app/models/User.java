package models;

import java.io.Serializable;
import java.util.UUID;

import javax.inject.Inject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import play.data.validation.Constraints;
import play.db.jpa.JPAApi;

/**
 * The persistent class for the user database table.
 *
 */
@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String address;
    private String auth_token;

    @Constraints.Required
    private String code;

    private String email;

    private String name;

    private String password;

    @Column(name="phone_number")
    private String phoneNumber;

    private String status;

    private String type;

    public User() {
    }
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User(String name) { this.name = name; }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        User aux = (User) obj;
        return (id == aux.id);
    }

    public String createToken() {
        auth_token = UUID.randomUUID().toString();
        //        save();
        return auth_token;
    }

    public void deleteAuthToken() {
        auth_token = null;
        //        save();
    }

    public String getAuthToken() {
        return auth_token;
    }

    public void setAuthToken(String authToken) {
        this.auth_token = authToken;
    }

}