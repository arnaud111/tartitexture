package esgi.tartitexture.gateway.adapter.in.file.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;

public class FileResponse {

    @JsonProperty(value = "fileName", required = true)
    public String fileName;

    public FileResponse() {

    }

    public FileResponse(String fileName) {
        this.fileName = fileName;
    }
}
