package esgi.tartitexture.file.application.port.in.usecase;

import esgi.tartitexture.file.domain.model.FileModel;

import java.util.List;

public interface FindFileUseCase {

    List<FileModel> findAllForContractId(int contractId);

    FileModel findFileByContractIdAndFileName(int contractId, String fileName);

}
