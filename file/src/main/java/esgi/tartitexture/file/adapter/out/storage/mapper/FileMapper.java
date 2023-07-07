package esgi.tartitexture.file.adapter.out.storage.mapper;

import esgi.tartitexture.file.domain.model.FileModel;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class FileMapper {

    public static FileModel fileAndContractIdToModel(File file, int contractId) {

        if (file == null) return null;

        return new FileModel(file, contractId);
    }

    public static List<FileModel> listFileAndContractIdToModel(File[] files, int contractId) {

        if (files == null) return null;

        List<FileModel> fileModels = new java.util.ArrayList<>(List.of());

        for (File file : files) {
            fileModels.add(fileAndContractIdToModel(file, contractId));
        }

        return fileModels;
    }
}
