package co.uniquindio.clinicaLaBienAmada.test.servicios.impl;


import co.uniquindio.clinicaLaBienAmada.test.servicios.interfaces.EmailServicio;
import dto.EmailDTO;
import lombok.RequiredArgsConstructor;

import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServicioImpl implements EmailServicio {

    private final JavaMailSender javaMailSender;
    @Override
    public String enviarCorreo(EmailDTO emailDTO) throws Exception {

        MimeMessage mensaje = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mensaje);
        helper.setSubject(emailDTO.asunto());
        helper.setText(emailDTO.mensaje(), true);
        helper.setTo(emailDTO.destinatario());
        helper.setFrom("no_reply@dominio.com");
        javaMailSender.send(mensaje);

    }
}
