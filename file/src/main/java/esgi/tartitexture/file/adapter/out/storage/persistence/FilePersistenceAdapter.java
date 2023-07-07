package esgi.tartitexture.file.adapter.out.storage.persistence;

import esgi.tartitexture.file.adapter.out.storage.mapper.FileMapper;
import esgi.tartitexture.file.application.port.out.file.FindFilePort;
import esgi.tartitexture.file.application.port.out.file.SaveFilePort;
import esgi.tartitexture.file.domain.exception.InternalServerError;
import esgi.tartitexture.file.domain.model.FileModel;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FilePersistenceAdapter implements FindFilePort, SaveFilePort {

    private final String uploadLocation = "contract_files";

    @Override
    public List<FileModel> findAllForContractId(int contractId) {
        File[] files = new File(this.uploadLocation + "/" + contractId).listFiles();
        return FileMapper.listFileAndContractIdToModel(files, contractId);
    }

    @Override
    public FileModel findFileByContractIdAndFileName(int contractId, String fileName) {
        Path path = Paths.get(this.uploadLocation + "/" + contractId);
        File file = path.resolve(fileName).toFile();
        return FileMapper.fileAndContractIdToModel(file, contractId);
    }

    @Override
    public void saveFile(MultipartFile multipartFile, int contractId) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();

        Path destinationFile = Paths.get(this.uploadLocation + "/" + contractId + "/" + dtf.format(now) + "-" + multipartFile.getOriginalFilename());

        try (InputStream inputStream = multipartFile.getInputStream()) {

            Files.createDirectories(Paths.get(this.uploadLocation + "/" + contractId));

            Files.copy(inputStream, destinationFile,
                    StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            throw new InternalServerError("Could not store file. Please try again!");
        }
    }
}
