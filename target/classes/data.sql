INSERT INTO ADDRESS (id, address_line1, address_line2, city, postal_code)
VALUES
    (1, 'ul. Strawińskiego 5', NULL, 'Wrocław', '52-129'),
    (2, 'ul. Wyszyńskiego 32', NULL, 'Lublin', '22-345'),
    (3, 'pl. Grunwaldzki 8', 'Obok placu', 'Wrocław', '10-231'),
    (4, 'al. Ołbińska 21', NULL, 'Kraków', '29-109');

INSERT INTO DOCTOR (id, first_name, last_name, telephone_number, email, doctor_number, specialization)
VALUES
    (1, 'Rudolf', 'Wiśniewski', '345876562', 'rudolf.wisniewski@example.com', 'D001', 'SURGEON'),
    (2, 'Aleksandra', 'Krzysztofek', '098123123', 'aleksandra.krzysztofek@example.com', 'D002', 'OCULIST'),
    (3, 'Cezary', 'Pazura', '456123098', 'cezary.pazura@example.com', 'D003', 'INTERNIST'),
    (4, 'Elżbieta', 'Izery', '321987654', 'elzbieta.izery@example.com', 'D004', 'DERMATOLOGIST');

INSERT INTO PATIENT (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, firts_visit)
VALUES
    (1, 'Jacek', 'Kowalski', '879234123', 'jacek.kowalski@example.com', 'P001', '1995-11-10', TRUE),
    (2, 'Halina', 'Miłościcka', '32189723', 'halina.miloscicka@example.com', 'P002', '1989-10-25', FALSE),
    (3, 'Ela', 'Wojciechowska', '123567213', 'ela.wojciechowska@example.com', 'P003', '1954-11-16', TRUE),
    (4, 'Artur', 'Młodnicki', '098231456', 'artur.mlodnicki@example.com', 'P004', '1998-09-10', FALSE);

INSERT INTO VISIT (id, description, time, PATIENT_ID, DOCTOR_ID)
VALUES
    (1, 'Konsultacja internistyczna', '2124-07-01 11:00:00', 1, 3),
    (2, 'Konsultacja internistyczna', '2124-07-01 11:20:00', 4, 3),
    (3, 'Kontrola po operacji', '2124-07-10 14:00:00', 2, 1),
    (4, 'Badanie dermatologiczne', '2124-07-13 11:00:00', 4, 4),
    (5, 'Konsultacja internistyczna', '2124-07-01 11:40:00', 3, 3);

INSERT INTO MEDICAL_TREATMENT (id, description, type, VISIT_ID)
VALUES
    (1, 'Badanie kontrolne', 'EKG', 1),
    (2, 'Badanie dermatologiczne', 'MANUAL', 4),
    (3, 'Obrazowanie', 'RTG', 2),
    (5, 'Szczepienie', 'MANUAL', 5),
    (6, 'Kontrola po szczepieniu', 'MANUAL', 2),
    (7, 'Kontrola po zabiegiu chirurgicznym', 'RTG', 3);