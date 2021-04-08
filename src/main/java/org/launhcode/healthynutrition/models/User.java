package org.launhcode.healthynutrition.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


@Entity
public class User extends AbstractEntity {
//    @Id
//    @GeneratedValue
//    private Integer Id;

    @NotNull
    private String firstName;

    private String lastName;
    @NotNull
    @Email
    private String email;
    @NotNull
    private String pwHash;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @OneToOne(mappedBy = "user")
    private Profile profile;

    public User(){
    }

    public User(String firstName, String lastName, String email, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        setPwHash(password);

    }

    public void setPwHash(String password) {
        this.pwHash = encoder.encode(password);
    }

    public String getPwHash() {
        return this.pwHash;
    }

    public User(Profile profile) {
        this.profile = profile;
    }

    //    public Integer getId() {
//        return Id;
//    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String email) {
        this.email = email;
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
//        User user = (User) o;
//        return Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email) && Objects.equals(pwHash, user.pwHash);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(super.hashCode(), firstName, lastName, email, pwHash);
//    }
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof User)) return false;
//        User user = (User) o;
//        return Objects.equals(Id, user.Id) &&
//                Objects.equals(getFirstName(), user.getFirstName()) &&
//                Objects.equals(getLastName(), user.getLastName()) &&
//                Objects.equals(getEmail(), user.getEmail()) &&
//                Objects.equals(pwHash, user.pwHash);
//    }


//    @Override
//    public int hashCode() {
//        return Objects.hash(Id, getFirstName(), getLastName(), getEmail(), pwHash);
//    }

}

