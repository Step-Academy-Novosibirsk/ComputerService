package ru.ipgolenischev.computerservice.models.base;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractServiceUserServiceModel extends AbstractServiceModel {

    @Column(name = "UserName",nullable = false)
    private String name;
    @Column(name = "UserPassword",nullable = false)
    private String password;
    @Column(name = "Phone",unique = true,length = 12,nullable = false)
    private String phone;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
