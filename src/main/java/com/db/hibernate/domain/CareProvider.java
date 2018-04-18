package com.db.hibernate.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class CareProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String speciality;

    @OneToMany
    List<MedicalEncounter> medicalEncounters;

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

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public List<MedicalEncounter> getMedicalEncounters() {
        return medicalEncounters;
    }

    public void setMedicalEncounters(List<MedicalEncounter> medicalEncounters) {
        this.medicalEncounters = medicalEncounters;
    }
}
