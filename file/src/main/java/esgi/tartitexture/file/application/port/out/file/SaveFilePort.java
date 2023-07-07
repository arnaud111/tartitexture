package esgi.tartitexture.file.application.port.out.file;

import esgi.tartitexture.file.domain.model.FileModel;
import org.springframework.web.multipart.MultipartFile;

public interface SaveFilePort {

    void saveFile(MultipartFile multipartFile, int contractId);

}
