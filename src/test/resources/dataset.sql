/*
    _______________________________________ Pacientes _________________________________________________________
 */
insert into cuenta values(2, 'pepito@email.com', '123');
insert into cuenta values(3, 'juanita@email.com', '234');

insert into cuenta values(4, 'valen7848@email.com', '123');
insert into cuenta values(5, 'mariana89@email.com', '012');
insert into cuenta values(7, 'santiagohs0730@gmail.com', '929');
insert into cuenta values(8, 'palomar67@email.com', '232323');
insert into cuenta values(9, 'seguridadcopia720@gmail.com', '233333');


insert into paciente values('24567234', 1, 1, 'Pepito Perez', '5454545', 'url_foto', 'Sin
alergias', 3, '2001-01-01', 1, 2);
insert into paciente values('18635123', 2, 1, 'Juanita Lopez',  '4564545', 'url_foto', 'Sin
alergias', 4, '1991-11-28', 1, 3);

insert into paciente values('246810', 6, 1, 'Valentina Campos',  '24827383', 'url_foto', 'Molusco contagioso',
                            2, '1995-11-28', 1, 4);
insert into paciente values('36912', 4, 1, 'Mariana Valencia',  '234123434', 'url_foto', 'Lil Peep',
                            1, '1980-11-28', 1, 5);
insert into paciente values('481216', 5, 1, 'Santiago Hernandez',  '6545345', 'url_foto', 'Hola Xd',
                            2, '1999-07-30', 2, 7);
insert into paciente values('5101520', 6, 1, 'Palomar de la Madriguera',  '7765555', 'url_foto', 'Alergia x',
                            3, '1994-11-28', 3, 8);
insert into paciente values('6121824', 7, 1, 'Bruna Mars',  '1111111', 'url_foto', 'Sin
alergias', 4, '2004-11-28', 4, 9);
/*
  ____________________________________________________________________________________________________________
 */


/*
   _______________________________________ Medicos _________________________________________________________
*/
insert into cuenta values(20, 'medico17848@gmail.com', '444');
insert into cuenta values(21, 'medico27848@email.com', '1234');
insert into cuenta values(22, 'medico37848@email.com', '12341');
insert into cuenta values(23, 'medico47848@email.com', '12341');
insert into cuenta values(24, 'medico57848@email.com', '12341');

insert into medico values('373456', 8, 1, 'Yhonatan Brutal', '11111', 'url_foto', 4, 20);
insert into medico values('345634', 8, 1, 'Cristian Bedon',  '222222', 'url_foto', 3, 21);
insert into medico values('345234', 6, 1, 'Erick Bedoya',  '333333', 'url_foto', 2, 22);
insert into medico values('253325', 11, 1, 'Rojito PT',  '444444', 'url_foto', 1, 23);
insert into medico values('765475', 10, 1, 'Metricas Frias',  '555555', 'url_foto', 3,24);
/*
  ____________________________________________________________________________________________________________
 */

/*
  _______________________________________ Citas _________________________________________________________
*/
insert into cita values (100, 3, '2023-10-20', 'Consulta General', 20, 4);
insert into cita values (101, 3, '2023-10-22', 'Consulta General', 21, 5);
insert into cita values (102, 3, '2023-10-24', 'Consulta General', 22, 7);
insert into cita values (103, 3, '2023-10-26', 'Consulta General', 23, 8);
insert into cita values (104, 2, '2023-10-28', 'Consulta General', 24, 9);
/*
  ____________________________________________________________________________________________________________
 */

/*
 _______________________________________ Atenciones _________________________________________________________
*/
insert into atencion values(200, 'Paciente presenta dolores de cabeza muy fuertes',
                            'Irritabilidad, perdida del conocimiento ', 'Acetaminofen cada 6 horas', 100);
INSERT INTO atencion VALUES(201, 'Paciente con fiebre y dolor de garganta',
                            'Dificultad para tragar, fatiga', 'Ibuprofeno cada 8 horas', 101);
INSERT INTO atencion VALUES(202, 'Paciente con fractura en el brazo izquierdo',
                            'Dolor intenso, hinchazón', 'Inmovilización y derivación a ortopedia', 102);
INSERT INTO atencion VALUES(203, 'Paciente con alergia cutánea',
                            'Picazón, enrojecimiento de la piel', 'Crema antihistamínica aplicar cada 4 horas', 103);
INSERT INTO atencion VALUES(204, 'Paciente con dolor abdominal',
                            'Náuseas, vómitos', 'Ranitidina cada 12 horas y observación', 104);
/*
  ____________________________________________________________________________________________________________
 */


 /*
  ---------------------------------------Dia Libre ------------------------------------------------------------
  */
insert into dia_libre values(300, '2023-10-20', 20);
insert into dia_libre values(301, '2023-12-22', 21);
insert into dia_libre values(302, '2024-01-30', 22);
insert into dia_libre values(303, '2024-07-30', 23);
insert into dia_libre values(304, '2024-09-30', 24);
/*
  ____________________________________________________________________________________________________________
 */


/*
 _______________________________________ Horario (horarios para medico) _________________________________________________________
*/
insert into horario values(400, '2024-09-30', '10:00 am', ' 5:00 pm', 20);
insert into horario values(401, '2024-10-01', '10:00 am', ' 5:00 pm', 21);
insert into horario values(402, '2024-09-02', '10:00 am', ' 5:00 pm', 22);
insert into horario values(403, '2024-09-03', '10:00 am', ' 5:00 pm', 23);
insert into horario values(404, '2024-09-04', '10:00 am', ' 5:00 pm', 24);
/*
  ____________________________________________________________________________________________________________
 */


/*
_______________________________________ Horario (horarios para medico) _________________________________________________________
*/
insert into pqrs values(500, 3, '2024-09-30', 'Doctor completamente soes', 'Leve', 100);
INSERT INTO pqrs VALUES(501, 2, '2024-10-01', 'Solicitud de cita médica', 'Moderado', 102);
INSERT INTO pqrs VALUES(502, 1, '2024-09-02', 'Consulta de resultados de laboratorio', 'Leve', 103);
INSERT INTO pqrs VALUES(503, 3, '2024-09-03', 'Queja sobre el tiempo de espera en la clínica', 'Moderado', 101);
INSERT INTO pqrs VALUES(504, 4, '2024-09-4', 'Sugerencia para mejorar la señalización en el hospital', 'Leve', 104);
/*
  ____________________________________________________________________________________________________________
 */


/*
_______________________________________ Administrador _________________________________________________________
*/
insert into cuenta values(99, 'anassterian7848@gmail.com', 'kael2442');
/*
  ____________________________________________________________________________________________________________
 */


