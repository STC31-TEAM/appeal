package ru.innopolis.stc31.appeal.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.innopolis.stc31.appeal.converters.AlbumDTOToAlbum;
import ru.innopolis.stc31.appeal.converters.AlbumToAlbumDTO;
import ru.innopolis.stc31.appeal.model.SuccessModel;
import ru.innopolis.stc31.appeal.model.dto.AlbumDTO;
import ru.innopolis.stc31.appeal.model.dto.StreetDTO;
import ru.innopolis.stc31.appeal.model.entity.AlbumLink;
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

    @Spy
    private AlbumDTOToAlbum albumDTOToAlbum;

    @Spy
    private AlbumToAlbumDTO albumToAlbumDTO;

    @Test
    void checkOnOk() {
        assertDoesNotThrow(() -> controller.getAllAlbums());
        assertDoesNotThrow(() -> controller.createAlbum(MockUtils.makeAlbumDTO()));
    }

    @Test
    void getAllAlbumsWithOk() {
        List<AlbumDTO> albums = MockUtils.makeListAlbumDTO(5);
        when(service.getAlbumList()).thenReturn(albums);

        assertEquals(albums.size(), controller.getAllAlbums().size());
    }

    @Test
    void createAlbum() {
        AlbumDTO albumDTO = MockUtils.makeAlbumDTO();
        AlbumLink albumLink = albumDTOToAlbum.convert(albumDTO);
        when(service.createAlbum(albumDTO)).thenReturn(albumLink);

        ResponseEntity<AlbumDTO> responseEntity = controller.createAlbum(albumDTO);

        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertEquals(responseEntity.getBody().getId_link(), albumDTO.getId_link());
        assertEquals(responseEntity.getBody().getLink(), albumDTO.getLink());
    }

    @Test
    void deleteAlbumWitOk() {
        AlbumDTO albumDTO = MockUtils.makeAlbumDTO();

        SuccessModel successModel = new SuccessModel().setResult("OK");
        when(service.deleteAlbum(albumDTO)).thenReturn(true);

        ResponseEntity<SuccessModel> responseEntity = controller.deleteAlbum(albumDTO);

        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertEquals(responseEntity.getBody().getResult(), successModel.getResult());
    }

    @Test
    void deleteAlbumWithFail() {
        AlbumDTO albumDTO = MockUtils.makeAlbumDTO();

        when(service.deleteAlbum(albumDTO)).thenReturn(false);

        ResponseEntity<SuccessModel> responseEntity = controller.deleteAlbum(albumDTO);

        assertEquals(HttpStatus.NOT_FOUND.value(), responseEntity.getStatusCodeValue());
    }
}