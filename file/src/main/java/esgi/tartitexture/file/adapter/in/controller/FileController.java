package esgi.tartitexture.file.adapter.in.controller;

import esgi.tartitexture.file.adapter.in.controller.response.FileResponse;
import esgi.tartitexture.file.adapter.in.mapper.FileResponseMapper;
import esgi.tartitexture.file.application.port.in.command.SaveFileCommand;
import esgi.tartitexture.file.application.port.in.usecase.FindFileUseCase;
import esgi.tartitexture.file.application.port.in.usecase.SaveFileUseCase;
import esgi.tartitexture.file.domain.exception.InternalServerError;
import esgi.tartitexture.file.domain.model.FileModel;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.util.List;

@RestController
@RequestMapping("/file")
public class FileController {

    private final SaveFileUseCase saveFileUseCase;
    private final FindFileUseCase findFileUseCase;

    public FileController(SaveFileUseCase saveFileUseCase, FindFileUseCase findFileUseCase) {
        this.saveFileUseCase = saveFileUseCase;
        this.findFileUseCase = findFileUseCase;
    }

    @GetMapping(value = "/{contractId}", produces = "application/json")
    public List<FileResponse> getFile(@PathVariable("contractId") int contractId) {
        return FileResponseMapper.listFileModelToListFileResponse(findFileUseCase.findAllForContractId(contractId));
    }

    @GetMapping(value = "/{contractId}/{fileName}")
    public ResponseEntity<Resource> getFile(@PathVariable("contractId") int contractId, @PathVariable("fileName") String fileName) {
        FileModel fileModel = findFileUseCase.findFileByContractIdAndFileName(contractId, fileName);
        InputStreamResource resource;

        try {
            resource = new InputStreamResource(new FileInputStream(fileModel.getFile()));
        } catch (Exception e) {
            throw new InternalServerError("Error while reading file");
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileModel.getFile().getName());

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(fileModel.getFile().length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

    @PostMapping(value = "/{contractId}")
    public void saveFile(@RequestPart("file") MultipartFile file, @PathVariable("contractId") int contractId) {

        SaveFileCommand saveFileCommand = new SaveFileCommand(file, contractId);

        saveFileUseCase.saveFile(saveFileCommand);
    }
}
