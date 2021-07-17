package ru.ipgolenischev.computerservice.models.base;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractServiceModel {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
