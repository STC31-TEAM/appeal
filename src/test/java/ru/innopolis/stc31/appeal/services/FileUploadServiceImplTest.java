package ru.innopolis.stc31.appeal.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.Uploader;
import com.cloudinary.utils.ObjectUtils;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringJUnitConfig
public class FileUploadServiceImplTest {

    @InjectMocks
    private FileUploadService fileUploadService;

    @Spy
    private Cloudinary cloudinary;

    @Mock
    private Uploader uploader;

    @Mock
    private MultipartFile multipartFile;

    @Test
    void checkOnOk() throws IOException {
        String inputFileName = "example.png";
        String uploadedFileName = "get_image_url.png";

        when(!multipartFile.isEmpty()).thenReturn(false);
        when(multipartFile.getOriginalFilename()).thenReturn(inputFileName);
        when(cloudinary.uploader()).thenReturn(uploader);

        Map<String, String> resultUpload = new HashMap<>();
        resultUpload.put("secure_url", uploadedFileName);

        when(uploader.upload(new File(inputFileName), ObjectUtils.emptyMap())).thenReturn(resultUpload);

        assertDoesNotThrow(() -> fileUploadService.upload(null));
        assertEquals(uploadedFileName, fileUploadService.upload(multipartFile));
    }
}
