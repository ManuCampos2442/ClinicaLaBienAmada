package co.uniquindio.clinicaLaBienAmada.test.servicios.interfaces;


import dto.EmailDTO;


public interface EmailServicio {

    String enviarCorreo(EmailDTO emailDTO) throws Exception;

    //EL PROFESOR TIENE ESTA LINEA EN LA GUÍA
    //void enviarCorreo(EmailDTO emailDTO) throws Exception;

}
