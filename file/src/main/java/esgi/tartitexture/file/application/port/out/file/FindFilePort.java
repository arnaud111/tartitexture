package esgi.tartitexture.file.application.port.out.file;

import esgi.tartitexture.file.domain.model.FileModel;

import java.util.List;

public interface FindFilePort {

    List<FileModel> findAllForContractId(int contractId);

    FileModel findFileByContractIdAndFileName(int contractId, String fileName);

}
