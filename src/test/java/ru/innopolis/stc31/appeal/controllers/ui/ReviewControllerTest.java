package ru.innopolis.stc31.appeal.controllers.ui;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringJUnitConfig
class ReviewControllerTest {

    @InjectMocks
    private ReviewController reviewController;

    @Mock
    private Model model;

    @Test
    void welcomeWithOk() {
        assertEquals("index", reviewController.welcome(model));
    }
}