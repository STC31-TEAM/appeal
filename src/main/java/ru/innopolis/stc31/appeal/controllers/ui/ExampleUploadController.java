package ru.innopolis.stc31.appeal.controllers.ui;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.innopolis.stc31.appeal.services.FileUploadService;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@Slf4j
@Deprecated
public class ExampleUploadController extends BaseCredentialController {

    private final FileUploadService fileUploadService;

    @PostMapping("/upload_form")
    public String upload(@RequestParam(value = "uploadFile", required = false) MultipartFile photo,
                         Model model) throws IOException {

        String uploadedImagUrl = fileUploadService.upload(photo);

        model.addAttribute("uploadedImageUrl", uploadedImagUrl);

        return "upload_form";
    }

    @GetMapping("/upload_form")
    public String uploadImage() throws IOException {
        return "upload_form";
    }
}
