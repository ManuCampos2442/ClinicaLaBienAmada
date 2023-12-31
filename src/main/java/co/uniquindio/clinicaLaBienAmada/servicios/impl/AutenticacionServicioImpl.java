package co.uniquindio.clinicaLaBienAmada.servicios.impl;

import co.uniquindio.clinicaLaBienAmada.dto.LoginDTO;
import co.uniquindio.clinicaLaBienAmada.dto.TokenDTO.TokenDTO;
import co.uniquindio.clinicaLaBienAmada.model.Cuenta;
import co.uniquindio.clinicaLaBienAmada.model.Medico;
import co.uniquindio.clinicaLaBienAmada.model.Paciente;
import co.uniquindio.clinicaLaBienAmada.repositorios.CuentaRepo;
import co.uniquindio.clinicaLaBienAmada.repositorios.MedicoRepo;
import co.uniquindio.clinicaLaBienAmada.repositorios.PacienteRepo;
import co.uniquindio.clinicaLaBienAmada.servicios.interfaces.AutenticacionServicio;
import co.uniquindio.clinicaLaBienAmada.utils.JWTUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AutenticacionServicioImpl implements AutenticacionServicio {

    private final CuentaRepo cuentaRepo;
    private  final PacienteRepo pacienteRepo;
    private  final MedicoRepo medicoRepo;
    private final JWTUtils jwtUtils;
   @Override
    public TokenDTO login(LoginDTO loginDTO) throws Exception {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Optional<Cuenta> cuentaOptional = cuentaRepo.findByCorreo(loginDTO.correo());
/*
        Paciente cuentaPaciente = pacienteRepo.findByCorreo(cuentaOptional.get().getCorreo());
        Medico cuentaMedico = medicoRepo.findByCorreo(loginDTO.correo());

         if(!(cuentaPaciente.isEstado())){
            throw new Exception("La cuenta ha sido eliminada");
        }

       if(cuentaOptional.isEmpty()){
           throw new Exception("Datos incorrectos, verifique nuevamente");
       }

        Cuenta cuenta = cuentaOptional.get();



        if( !passwordEncoder.matches(loginDTO.password(), cuenta.getPassword()) ){
            throw new Exception("La contraseña ingresada es incorrecta");
        }
        return new TokenDTO( crearToken(cuenta) ); */

       if (cuentaOptional.isEmpty()) {
           throw new Exception("Datos incorrectos, verifique nuevamente");
       }

       Cuenta cuenta = cuentaOptional.get();

       // Verificar el estado de la cuenta
       if (cuenta instanceof Paciente) {
           Paciente cuentaPaciente = pacienteRepo.findByCorreo(cuenta.getCorreo());
           if (!cuentaPaciente.isEstado()) {
               throw new Exception("La cuenta ha sido eliminada");
           }
       }

       // Aquí puedes agregar más lógica para otros tipos de cuenta, si es necesario

       // Resto del código para verificar la contraseña y generar el token
       if (!passwordEncoder.matches(loginDTO.password(), cuenta.getPassword())) {
           throw new Exception("La contraseña ingresada es incorrecta");
       }

       return new TokenDTO(crearToken(cuenta));


    }

    private String crearToken(Cuenta cuenta){
        String rol;
        String nombre;
        if( cuenta instanceof Paciente){
            rol = "paciente";
            nombre = ((Paciente) cuenta).getNombre();
        }else if( cuenta instanceof Medico){
            rol = "medico";
            nombre = ((Medico) cuenta).getNombre();
        }else{
            rol = "admin";
            nombre = "Administrador";
        }
        Map<String, Object> map = new HashMap<>();
        map.put("rol", rol);
        map.put("nombre", nombre);
        map.put("id", cuenta.getCodigo());

        return jwtUtils.generarToken(cuenta.getCorreo(), map);
    }


}