package fr.sacem.api.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
@Service
public class FilesService {
    public String getFileContent(String filePath){
        Resource resource = new ClassPathResource(filePath);
        String fileContent = null;
        try {
            InputStream inputStream = resource.getInputStream();
            byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
            fileContent = new String(bdata, StandardCharsets.UTF_8);
        }catch (Exception e) {

        }
        return fileContent;
    }
}
