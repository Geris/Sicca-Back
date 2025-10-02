package com.sicca.usecase;

import com.sicca.dto.imagen.ResultadoIADTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Component
public class AnalizarImagenUseCase {

    public ResultadoIADTO execute(MultipartFile file) {

        return new ResultadoIADTO();
    }
}
