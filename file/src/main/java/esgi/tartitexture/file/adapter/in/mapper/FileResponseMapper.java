package esgi.tartitexture.file.adapter.in.mapper;

import esgi.tartitexture.file.adapter.in.controller.response.FileResponse;
import esgi.tartitexture.file.domain.model.FileModel;

import java.util.ArrayList;
import java.util.List;

public class FileResponseMapper {

    public static List<FileResponse> listFileModelToListFileResponse(List<FileModel> fileModelList) {

        List<FileResponse> fileResponseList = new ArrayList<>();

        for (FileModel fileModel : fileModelList) {
            fileResponseList.add(new FileResponse(fileModel.getFile().getName()));
        }

        return fileResponseList;
    }
}
