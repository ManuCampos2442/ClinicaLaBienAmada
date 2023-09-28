package co.uniquindio.clinicaLaBienAmada.servicios.interfaces;


import dto.EmailDTO;


public interface EmailServicio {

    String enviarCorreo(EmailDTO emailDTO) throws Exception;


}
