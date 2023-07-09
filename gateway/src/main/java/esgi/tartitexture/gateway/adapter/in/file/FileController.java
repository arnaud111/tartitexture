package esgi.tartitexture.gateway.adapter.in.file;

import esgi.tartitexture.gateway.adapter.in.file.response.FileResponse;
import esgi.tartitexture.gateway.adapter.out.FilePersistenceAdapter;
import esgi.tartitexture.gateway.domain.exception.InternalServerError;
import esgi.tartitexture.gateway.domain.model.FileModel;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;

@RestController
@RequestMapping("/file")
public class FileController {

    private final FilePersistenceAdapter filePersistenceAdapter;

    public FileController(FilePersistenceAdapter filePersistenceAdapter) {
        this.filePersistenceAdapter = filePersistenceAdapter;
    }

    @GetMapping(value = "/{contractId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public FileResponse[] getFile(@PathVariable("contractId") int contractId) {
        return filePersistenceAdapter.findAllForContract(contractId);
    }

    @PostMapping(value = "/{contractId}")
    public void saveFile(@RequestPart("file") MultipartFile file, @PathVariable("contractId") int contractId) {
        filePersistenceAdapter.create(file, contractId);
    }

    @GetMapping(value = "/{contractId}/{fileName}")
    public ResponseEntity<byte[]> getFile(@PathVariable("contractId") int contractId, @PathVariable("fileName") String fileName) {
        byte[] resource = filePersistenceAdapter.getFile(contractId, fileName);

        HttpHeaders headers = new HttpHeaders();
        try {
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(resource.length)
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(resource);
        } catch (Exception e) {
            System.out.println("2");
            System.out.println(e);
            throw new InternalServerError("Error while trying to get file");
        }
    }
}
