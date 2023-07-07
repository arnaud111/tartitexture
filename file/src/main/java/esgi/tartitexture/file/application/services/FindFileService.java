package esgi.tartitexture.file.application.services;

import esgi.tartitexture.file.application.port.in.usecase.FindFileUseCase;
import esgi.tartitexture.file.application.port.out.file.FindFilePort;
import esgi.tartitexture.file.domain.model.FileModel;

import java.util.List;

public class FindFileService implements FindFileUseCase {

    private final FindFilePort findFilePort;

    public FindFileService(FindFilePort findFilePort) {
        this.findFilePort = findFilePort;
    }

    @Override
    public List<FileModel> findAllForContractId(int contractId) {
        return findFilePort.findAllForContractId(contractId);
    }

    @Override
    public FileModel findFileByContractIdAndFileName(int contractId, String fileName) {
        return findFilePort.findFileByContractIdAndFileName(contractId, fileName);
    }
}
