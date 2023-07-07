package esgi.tartitexture.file.application.port.in.usecase;

import esgi.tartitexture.file.application.port.in.command.SaveFileCommand;

public interface SaveFileUseCase {

    void saveFile(SaveFileCommand saveFileCommand);

}
