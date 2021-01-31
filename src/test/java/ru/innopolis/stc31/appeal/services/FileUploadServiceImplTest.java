package ru.innopolis.stc31.appeal.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.web.multipart.MultipartFile;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringJUnitConfig
public class FileUploadServiceImplTest {

    @InjectMocks
    private FileUploadService fileUploadService;

    @Mock
    private MultipartFile multipartFile;

    @Test
    void checkOnOk() {
        assertDoesNotThrow(() -> fileUploadService.upload(multipartFile));
    }
}
