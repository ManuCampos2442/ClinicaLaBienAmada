package co.uniquindio.clinicaLaBienAmada.servicios.impl;

import co.uniquindio.clinicaLaBienAmada.servicios.interfaces.ImagenesServicio;
import com.cloudinary.Cloudinary;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ImagenesServicioImpl implements ImagenesServicio {

    private final Cloudinary cloudinary;
    public ImagenesServicioImpl(){
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "dwgbwwffn");
        config.put("api_key", "581341145757435");
        config.put("api_secret", "M0W25UZBQgozKgMcMC5CWkLHfHs");
        cloudinary = new Cloudinary(config);
    }

    @Override
    public void subirImagen() throws Exception {

    }
}
