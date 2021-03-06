package packt.springboot.webapp.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class DocumentController {

    @PostMapping(path = "/farm/legalDocument", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String addLegalDocument(@RequestParam("ducument") MultipartFile legalDocument) {
        return String.join("", "Added document: ", legalDocument.getOriginalFilename());
    }

}
