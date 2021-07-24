package ru.ipgolenischev.computerservice.models.Users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.ipgolenischev.computerservice.models.ServiceOrderModel;
import ru.ipgolenischev.computerservice.models.base.AbstractServiceUserServiceModel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ServiceClients")
public class ServiceClientServiceModel extends AbstractServiceUserServiceModel {

    @Column(name = "ClientAddress",nullable = false)
    private String address;
    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<ServiceOrderModel> orders;

    public ServiceClientServiceModel(){

    }

    public List<ServiceOrderModel> getOrders() {
        return orders;
    }
    public void add(ServiceOrderModel serviceOrderModel){
        orders.add(serviceOrderModel);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
