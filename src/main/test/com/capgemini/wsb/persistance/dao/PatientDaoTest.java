package com.capgemini.wsb.persistance.dao;
import com.capgemini.wsb.WsbJpaApplication;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WsbJpaApplication.class)
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;

    @Transactional
    @Test
    // Znajdz pacjentow po nazwisku
    public void findPatientByLastNameTest() {
        //given
        //when
        List<PatientEntity> patientEntityList = patientDao.findPatientByName("Miłościcka");
        //then
        assertThat(patientEntityList.size()).isEqualTo(1);
    }

    @Transactional
    @Test
    // znajdz pacjentow ktorzy mieli wiecej niz X wizyt (X jest parametrem wejsciowym)
    public void findPatientsWithMoreThanXVisits(){
        //given
        //when
        int x = 1;
        //then
        assertThat(patientDao.findPatientsWithMoreThanXVisits(x).size()).isEqualTo(1);
    }

    @Transactional
    @Test
    // Znajdz pacjentow po dodanym przez Ciebie polu - nie wyszukuj wprost po wartosci,
    // uzyj zapytania typu wieksze/mniejsze/pozniej/wczesniej/zawiera, w zaleznosci od wybranego typu zmiennej.
    // Znajdź pacjentów, którzy są na pierwszej wizycie
    public void findPatientsOnFirstVisitTest(){
        //given
        //when
        List<PatientEntity> patientEntityList = patientDao.findPatientsOnFirstVisit();
        //then
        assertThat(patientEntityList.size()).isEqualTo(2);
    }
}