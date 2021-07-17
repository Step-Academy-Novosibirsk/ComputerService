package ru.ipgolenischev.computerservice.models.Users;

import ru.ipgolenischev.computerservice.models.base.AbstractServiceUserServiceModel;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ServiceManagers")
public class ServiceManagerServiceModel extends AbstractServiceUserServiceModel {
}
