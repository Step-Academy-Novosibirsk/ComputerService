package ru.ipgolenischev.computerservice.models;

import ru.ipgolenischev.computerservice.models.Users.ServiceClientServiceModel;
import ru.ipgolenischev.computerservice.models.base.AbstractServiceModel;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "ServiceOrders")
public class ServiceOrderModel extends AbstractServiceModel {
    @Column(name ="StartDate")
    private Date startDate;
    @Column(name ="EndDate")
    private Date endDate;
    @Column(name ="Comment")
    private String comment;
    @Column(name ="Description")
    private String description;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ClientId")
    private ServiceClientServiceModel client;

    public ServiceClientServiceModel getClient() {
        return client;
    }

    public void setClient(ServiceClientServiceModel client) {
        this.client = client;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
