package com.db.hibernate;

import com.db.hibernate.domain.CareProvider;
import com.db.hibernate.domain.HealthIssue;
import com.db.hibernate.domain.MedicalEncounter;
import com.db.hibernate.domain.Patient;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

public class JPAHw {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("health_db");
        EntityManager em = emf.createEntityManager();


        Patient p=new Patient();
        p.setName("Paul");
        em.persist(p);
        Patient p2=new Patient();
        p2.setName("Ana");
        em.persist(p2);

        HealthIssue healthIssue=new HealthIssue();
        healthIssue.setName("Infection");
        p.setHealthIssues(new ArrayList<>());
        p.getHealthIssues().add(healthIssue);
        em.persist(healthIssue);

        MedicalEncounter medicalEncounter = new MedicalEncounter();
        Calendar calendarDate = Calendar.getInstance(
                TimeZone.getTimeZone("UTC"));
        calendarDate.set(Calendar.YEAR, 2017);
        calendarDate.set(Calendar.MONTH, 10);
        calendarDate.set(Calendar.DAY_OF_MONTH, 15);
        medicalEncounter.setDateE(calendarDate);
        em.persist(medicalEncounter);

//        em.getTransaction().commit();
//////////////query1
        HealthIssue hi=em.find(HealthIssue.class, new Long(54));
        Patient patient=(Patient)  em.createQuery("SELECT P from Patient P where P.hi = :hi")
                .setParameter("hi", hi).getSingleResult();


        System.out.println(patient.getName());

/////////////query2
        Patient patient1 = (Patient) em.createQuery("SELECT P from Patient P where P.Edate >: today")
                .setParameter("today",TemporalType.DATE).getSingleResult();
        System.out.println(patient1.getName());

////////////query3
        CareProvider careProvider = new CareProvider();
        Patient patient2 =(Patient) em.createQuery("SELECT P from Patient P where P.careProvider=:careProvider ")
                .setParameter("careProvider",careProvider).getResultList();
        System.out.println(careProvider.getName());




    }

}
