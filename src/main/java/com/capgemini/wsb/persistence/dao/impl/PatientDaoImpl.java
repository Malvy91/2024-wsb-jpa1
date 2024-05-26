package com.capgemini.wsb.persistence.dao.impl;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.stereotype.Repository;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class PatientDaoImpl  extends AbstractDao<PatientEntity, Long> implements PatientDao
{

    @Override
    public List<PatientEntity> findPatientByName(String lastName){
        TypedQuery<PatientEntity> query = entityManager.createQuery("SELECT patient FROM PatientEntity patient WHERE patient.lastName LIKE :lastName", PatientEntity.class).setParameter("lastName", lastName);
        return query.getResultList();
    }

    @Override
    public List<PatientEntity> findPatientsWithMoreThanXVisits(int x){
        TypedQuery<PatientEntity> query = entityManager.createQuery("SELECT patient FROM PatientEntity patient WHERE size(patient.visits) > :x", PatientEntity.class).setParameter("x", x);
        return query.getResultList();
    }

    @Override
    public List<PatientEntity> findPatientsOnFirstVisit(){
        TypedQuery<PatientEntity> query = entityManager.createQuery("SELECT patient FROM PatientEntity patient WHERE firtsVisit LIKE true", PatientEntity.class);
        return query.getResultList();
    }
}
