package esgi.tartitexture.file.application.port.in.command;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public class SaveFileCommand {

    private MultipartFile file;
    private int contractId;

    public SaveFileCommand(MultipartFile file, int contractId) {
        this.file = file;
        this.contractId = contractId;
    }

    public MultipartFile getFile() {
        return file;
    }

    public int getContractId() {
        return contractId;
    }
}
