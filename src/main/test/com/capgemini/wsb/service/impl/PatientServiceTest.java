package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.WsbJpaApplication;
import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.service.DoctorService;
import com.capgemini.wsb.service.PatientService;
import com.capgemini.wsb.service.VisitService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WsbJpaApplication.class)
class PatientServiceImplTest {

    @Autowired
    PatientService patientService;

    @Autowired
    VisitService visitService;

    @Autowired
    DoctorService doctorService;

    @Transactional
    @Test
    //pobranie pacjenta po ID powinno zwrocic struktore TO-sow odpowiadajaca wczesniejszym zalozeniom.
    // W asercjach sprawdz poprawnosc odczytu dodanego przez Ciebie pola z punktu pierwszego
    void findById(){
        //given
        //when
        PatientTO patientTO =  patientService.findById(1L);
        //then
        assertTrue(patientTO.isFirtsVisit());
    }

    @Transactional
    @Test
    // test usuwajacy pacjenta sprawdza czy usuniete zostaly wszystkie wizyty (kaskada) i czy nie zostali usunieci doktorzy
    void deleteById() {
        //given
        //when
        patientService.deleteById(1L);
        //then
        assertNull(patientService.findById(1L));
        assertNull(visitService.findById(1L));
        assertNotNull(doctorService.findById(1L));
    }

    @Transactional
    @Test
    // Znajdz wszystkie wizyty pacjenta po jego ID
    void getPatientVisits() {
        //given
        //when
        List<VisitTO> visitTOList = patientService.getPatientVisitsByID(1L);
        //then
        assertEquals(1, visitTOList.size());
    }
}