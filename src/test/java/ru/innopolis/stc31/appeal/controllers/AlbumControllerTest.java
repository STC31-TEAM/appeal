package ru.innopolis.stc31.appeal.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.innopolis.stc31.appeal.model.dto.AlbumDTO;
import ru.innopolis.stc31.appeal.services.AlbumService;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * Testing AlbumController
 */
@SpringJUnitConfig
class AlbumControllerTest {

    @InjectMocks
    private AlbumController controller;

    @Mock
    private AlbumService service;

    @Test
    void checkOnOk() {
        assertDoesNotThrow(() -> controller.getAllAlbums());
        assertDoesNotThrow(() -> controller.createAlbum(new AlbumDTO()));
    }

    @Test
    void getAllAlbumsWithOk() {
        List<AlbumDTO> albums = MockUtils.makeListAlbumDTO(5);
        when(service.getAlbumList()).thenReturn(albums);

        assertEquals(albums.size(), controller.getAllAlbums().size());
    }

    @Test
    void createAlbumWithOk() {
        AlbumDTO album = MockUtils.makeAlbumDTO();

        when(service.createAlbum(album)).thenReturn(true);

        assertTrue(controller.createAlbum(album));
    }
}