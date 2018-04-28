package com.chinaup.security.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Table(name = "jpress_user")
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,columnDefinition = "varchar(30) default ''")
    private String name;

    @Column(nullable = false,columnDefinition = "varchar(30) default ''")
    private String nikeName;

    @Column(name = "email", length = 50)
    private String email;//用户邮箱

    @Column(name = "password", length = 120)
    private String password;//用户密码

    @Temporal(TemporalType.DATE)
    @Column(name = "dob", length = 10)
    private Date dob;//时间

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Role> roles = new HashSet<Role>(0);// 所对应的角色集合



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
