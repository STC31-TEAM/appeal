package ru.innopolis.stc31.appeal.controllers.ui;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.ui.Model;
import ru.innopolis.stc31.appeal.services.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
@ActiveProfiles({"test"})
class ReviewControllerTest {

    @Mock
    private ReviewService reviewService;

    @InjectMocks
    private ReviewController reviewController;

    @Mock
    private Model model;

    @Test
    void welcomeWithOk() {
        assertDoesNotThrow(() -> reviewController.welcome(model));
    }

    @Test
    void createUser() {
        Map<String,Long> mockMap = new HashMap<>();
        doReturn(mockMap).when(reviewService).getAllCompanyTitle();
        doReturn(mockMap).when(reviewService).getAllCountryName();
        doReturn(mockMap).when(reviewService).getAllCityName();
        doReturn(mockMap).when(reviewService).getAllStreetName();

        assertNotNull(reviewController.createUser(model));
    }

    @Test
    void companyAll(){
        Map<String,Long> mockMap = new HashMap<>();
        doReturn(mockMap).when(reviewService).getAllCompany();

        assertNotNull(reviewController.companyAll(model));
    }
}