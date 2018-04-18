package com.db.hibernate.domain;

import javax.persistence.*;
import java.util.Calendar;

@Entity
public class MedicalEncounter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dateE;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Calendar getDateE() {
        return dateE;
    }

    public void setDateE(Calendar dateE) {
        this.dateE = dateE;
    }
}
