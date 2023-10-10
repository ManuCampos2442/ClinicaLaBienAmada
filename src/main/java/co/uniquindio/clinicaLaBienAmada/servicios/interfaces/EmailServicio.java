package co.uniquindio.clinicaLaBienAmada.servicios.interfaces;


import co.uniquindio.clinicaLaBienAmada.dto.EmailDTO;


public interface EmailServicio {

    String enviarCorreo(EmailDTO emailDTO) throws Exception;


}
