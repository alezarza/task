package com.kubbo.task.Users;


import javax.persistence.*;

@Entity
@Table
public class Contact {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private String photo_url;
    private int phone_number;

    public Contact() {

    }

    /*The Database will generate*/
    public Contact(String name, String email, String photo_url, int phone_number) {
        this.name = name;
        this.email = email;
        this.photo_url = photo_url;
        this.phone_number = phone_number;
    }

    public Contact(Long id, String name, String email, String photo_url, int phone_number) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.photo_url = photo_url;
        this.phone_number = phone_number;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public void setPhone_number(int phone_number) { this.phone_number = phone_number; }


}
