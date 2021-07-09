package models;

import javax.persistence.*;

@Entity
@Table(name = "ServiceClients")
public class ServiceClient {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ClientAddress",nullable = false)
    private String address;
    @Column(name = "ClientName",nullable = false)
    private String name;
    @Column(name = "ClientPassword",nullable = false)
    private String password;
    @Column(name = "Phone",unique = true,length = 12,nullable = false)
    private String phone;
    public int getId(){
        return id;
    }
    public ServiceClient(){

    }
    public ServiceClient(int id, String address, String name, String password, String phone){
        this.id = id;
        this.address = address;
        this.name = name;
        this.password = password;
        this.phone = phone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

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
