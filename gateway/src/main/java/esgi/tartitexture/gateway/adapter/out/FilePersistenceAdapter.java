package esgi.tartitexture.gateway.adapter.out;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.dockerjava.zerodep.shaded.org.apache.hc.client5.http.classic.methods.HttpPost;
import com.github.dockerjava.zerodep.shaded.org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder;
import com.github.dockerjava.zerodep.shaded.org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import com.github.dockerjava.zerodep.shaded.org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import com.github.dockerjava.zerodep.shaded.org.apache.hc.core5.http.ContentType;
import com.github.dockerjava.zerodep.shaded.org.apache.hc.core5.http.HttpEntity;
import esgi.tartitexture.gateway.adapter.in.file.response.FileResponse;
import esgi.tartitexture.gateway.domain.exception.InternalServerError;
import org.springframework.core.io.InputStreamResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FilePersistenceAdapter {

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public FilePersistenceAdapter() {
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    public FileResponse[] findAllForContract(int id) {
        HttpResponse<String> response;

        try {
            response = httpClient.send(HttpRequest.newBuilder()
                    .uri(URI.create("http://127.0.0.1:8098/file/" + id))
                    .build(), HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new InternalServerError("Error while trying to find all files");
        }

        try {
            return objectMapper.readValue(response.body(), FileResponse[].class);
        } catch (Exception e) {
            System.out.println(e);
            throw new InternalServerError("Error while trying to parse file response");
        }
    }

    public void create(MultipartFile file, int contractId) {
        try {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost httpPost = new HttpPost("http://127.0.0.1:8098/file/" + contractId);

            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.addBinaryBody("file", file.getBytes(), ContentType.DEFAULT_BINARY, file.getOriginalFilename());

            HttpEntity multipart = builder.build();
            httpPost.setEntity(multipart);

            httpClient.execute(httpPost);

        } catch (Exception e) {
            throw new InternalServerError("Error while trying to create file");
        }
    }

    public byte[] getFile(int contractId, String fileName) {
        HttpResponse<byte[]> response;

        try {
            response = httpClient.send(HttpRequest.newBuilder()
                    .uri(URI.create("http://127.0.0.1:8098/file/" + contractId + "/" + fileName))
                    .build(), HttpResponse.BodyHandlers.ofByteArray());

            return response.body();
        } catch (Exception e) {
            throw new InternalServerError("Error while trying to find file");
        }
    }

}
