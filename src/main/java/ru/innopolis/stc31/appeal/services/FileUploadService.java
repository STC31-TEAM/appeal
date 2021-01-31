package ru.innopolis.stc31.appeal.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class FileUploadService {

    private final Cloudinary cloudinary;

    public String upload(MultipartFile file) throws IOException {
        if (!file.isEmpty() && file.getOriginalFilename() != null) {
            file.transferTo(Paths.get(file.getOriginalFilename()));
            File uploadFile = new File(file.getOriginalFilename());

            Map result = cloudinary.uploader().upload(uploadFile, ObjectUtils.emptyMap());
            if (!uploadFile.delete()) {
                log.error("file " + uploadFile.getAbsolutePath() + " not deleted");
            }
            return result.get("secure_url").toString();
        } else {
            log.error("file is empty");
            return "";
        }
    }
}
