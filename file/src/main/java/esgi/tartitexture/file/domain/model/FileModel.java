package esgi.tartitexture.file.domain.model;

import java.io.File;

public class FileModel {

    private File file;

    private int contractId;

    public FileModel(File file, int contractId) {
        this.file = file;
        this.contractId = contractId;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }
}
