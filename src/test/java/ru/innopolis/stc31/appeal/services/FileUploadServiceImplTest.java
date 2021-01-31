package ru.innopolis.stc31.appeal.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.web.multipart.MultipartFile;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.when;

@SpringJUnitConfig
public class FileUploadServiceImplTest {

    @InjectMocks
    private FileUploadService fileUploadService;

    @Mock
    private MultipartFile multipartFile;

    @Test
    void checkOnOk() {
        when(multipartFile.isEmpty()).thenReturn(true);
        when(multipartFile.getOriginalFilename()).thenReturn("example.png");

        assertDoesNotThrow(() -> fileUploadService.upload(null));
        assertDoesNotThrow(() -> fileUploadService.upload(multipartFile));
    }
}
