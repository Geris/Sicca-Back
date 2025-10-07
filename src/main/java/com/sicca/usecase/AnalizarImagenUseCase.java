package com.sicca.usecase;

import com.sicca.dto.requests.imagen.ResultadoIARequest;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class AnalizarImagenUseCase {

    public ResultadoIARequest execute(MultipartFile file) {

        return new ResultadoIARequest();
    }
}
