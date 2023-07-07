package esgi.tartitexture.file.application.services;

import esgi.tartitexture.file.application.port.in.command.SaveFileCommand;
import esgi.tartitexture.file.application.port.in.usecase.SaveFileUseCase;
import esgi.tartitexture.file.application.port.out.contract.FindContractPort;
import esgi.tartitexture.file.application.port.out.file.SaveFilePort;
import esgi.tartitexture.file.domain.exception.ContractClosedException;
import esgi.tartitexture.file.domain.exception.FileBadExtensionException;
import esgi.tartitexture.file.domain.exception.FileEmptyException;
import esgi.tartitexture.file.domain.model.ContractModel;
import esgi.tartitexture.file.domain.model.FileModel;

import java.util.Objects;

public class SaveFileService implements SaveFileUseCase {

    private final SaveFilePort saveFilePort;
    private final FindContractPort findContractPort;


    public SaveFileService(SaveFilePort saveFilePort, FindContractPort findContractPort) {
        this.saveFilePort = saveFilePort;
        this.findContractPort = findContractPort;
    }

    @Override
    public void saveFile(SaveFileCommand saveFileCommand) {

        if (saveFileCommand.getFile().isEmpty()) throw new FileEmptyException("File is empty");

        String extension = Objects.requireNonNull(saveFileCommand.getFile().getOriginalFilename())
                .substring(saveFileCommand.getFile().getOriginalFilename().lastIndexOf(".") + 1)
                .toLowerCase();

        if (!extension.equals("pdf")) throw new FileBadExtensionException("File extension is not pdf");

        ContractModel contractModel = findContractPort.findContractById(saveFileCommand.getContractId());

        if (contractModel.isClosed()) throw ContractClosedException.closedContractId(contractModel.getId());

        saveFilePort.saveFile(saveFileCommand.getFile(), saveFileCommand.getContractId());
    }
}
