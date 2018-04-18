package com.db.hibernate.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class HealthIssue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @OneToMany
    List<HealthService> healthServices;

    public List<HealthService> getHealthServices() {
        return healthServices;
    }

    public void setHealthServices(List<HealthService> healthServices) {
        this.healthServices = healthServices;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
