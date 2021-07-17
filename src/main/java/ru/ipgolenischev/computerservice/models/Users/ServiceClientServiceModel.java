package ru.ipgolenischev.computerservice.models.Users;

import ru.ipgolenischev.computerservice.models.base.AbstractServiceUserServiceModel;

import javax.persistence.*;

@Entity
@Table(name = "ServiceClients")
public class ServiceClientServiceModel extends AbstractServiceUserServiceModel {

    @Column(name = "ClientAddress",nullable = false)
    private String address;

    public ServiceClientServiceModel(){

    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
