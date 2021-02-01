package ru.innopolis.stc31.appeal.controllers.ui;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import ru.innopolis.stc31.appeal.services.FileUploadService;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringJUnitConfig
class ExampleUploadControllerTest {

    @Mock
    private FileUploadService service;

    @Mock
    private MultipartFile image;

    @Mock
    private Model model;

    @InjectMocks
    private ExampleUploadController controller;

    @Test
    void checkOnOk() {
        assertDoesNotThrow(() -> controller.uploadImage());
        assertDoesNotThrow(() -> controller.upload(image, model));
    }
}