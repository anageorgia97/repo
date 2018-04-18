package com.db.hibernate.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @OneToMany
    List<HealthIssue> healthIssues;

    @OneToMany
    List<MedicalEncounter> medicalEncounters;



    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", healthIssues=" + healthIssues +
                '}';
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

    public List<HealthIssue> getHealthIssues() {
        return healthIssues;
    }

    public void setHealthIssues(List<HealthIssue> healthIssues) {
        this.healthIssues = healthIssues;
    }

    public List<MedicalEncounter> getMedicalEncounters() {
        return medicalEncounters;
    }

    public void setMedicalEncounters(List<MedicalEncounter> medicalEncounters) {
        this.medicalEncounters = medicalEncounters;
    }
}
