/**
 * 
 */
package com.logigear.training.entities;
/**
 * @author bang.ngo
 *
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author bang.ngo
 *
 */
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "username",nullable = false,length = 100)
    private String username;
    @Column(name = "password",nullable = false,length = 100)
    private String password;
    @Column(name = "fullname",nullable = false,length = 100)
    private String fullname;
    @Column(name = "role",nullable = false,length = 100)
    private String role;

    public Employee() {
    }

    public Employee(String username, String password, String fullname, String role) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.role = role;
    }

    public  String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getFullname() {
        return this.fullname;
    }

    public String getRole() {
        return this.role;
    }

    public void setUsername( String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String toString() {
        return "Employee(username=" + this.getUsername() + ", password=" + this.getPassword() + ", fullname=" + this.getFullname() + ", role=" + this.getRole() + ")";
    }
}
