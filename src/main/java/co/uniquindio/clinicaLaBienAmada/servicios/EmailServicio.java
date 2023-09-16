package co.uniquindio.clinicaLaBienAmada.servicios;


import dto.EmailDTO;


public interface EmailServicio {

    String enviarCorreo(EmailDTO emailDTO) throws Exception;


}
