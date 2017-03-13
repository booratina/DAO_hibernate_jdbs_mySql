package model;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by User on 05.03.2017.
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Column(name = "name", unique = true, updatable = false)
    private String name;

    @Column(name = "role", unique = true, updatable = false)
    private String role;

    @Column(name = "password", unique = true, updatable = false)
    private String password;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @SuppressWarnings("UnusedDeclaration")
    public User(int id, String name, String password, String role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    @SuppressWarnings("UnusedDeclaration")
    public User() {
    }


    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }
}
