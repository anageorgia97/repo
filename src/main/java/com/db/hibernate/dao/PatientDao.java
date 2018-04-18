package com.db.hibernate.dao;

import com.db.hibernate.domain.Patient;

import javax.persistence.EntityManager;
import java.util.List;

public class PatientDao {

    private EntityManager em;

    public PatientDao(EntityManager em){
        this.em=em;

    }
    @SuppressWarnings("unchecked")
    public List<Patient> findAll(){

        return (List<Patient>) em.createQuery("select p from Patient p").getResultList();

    }
    public Patient findById(Long id){

        return em.find(Patient.class,id);

    }

    public void saveOrUpdate(Patient patient){

        em.merge(patient);
    }
    public void remove(Patient patient){

        em.remove(patient);
    }


}
