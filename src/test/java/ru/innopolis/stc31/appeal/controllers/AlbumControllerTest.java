package ru.innopolis.stc31.appeal.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.http.ResponseEntity;
import ru.innopolis.stc31.appeal.converters.AlbumDTOToAlbum;
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
@SpringBootTest
@ActiveProfiles({"test"})
class AlbumControllerTest {

    @InjectMocks
    private AlbumController albumController;

    @Mock
    private AlbumService albumService;

    @Mock
    private AlbumDTOToAlbum albumDTOToAlbum;

    @Test
    void checkOnOk() {
        assertDoesNotThrow(() -> albumController.getAllAlbums());
        assertDoesNotThrow(() -> albumController.createAlbum(MockUtils.makeAlbumDTO()));
    }

    @Test
    void getAllAlbumsWithOk() {
        List<AlbumDTO> albumDTOList = MockUtils.makeListAlbumDTO(5);
        when(albumService.getAlbumList()).thenReturn(albumDTOList);

        assertEquals(albumDTOList.size(), albumController.getAllAlbums().size());
        assertEquals(albumDTOList.get(1).getLink(), albumController.getAllAlbums().get(1).getLink());
    }

    @Test
    void createAlbumWithOk() {
        AlbumDTO albumDTO = MockUtils.makeAlbumDTO();
        /*AlbumLink albumLink = albumDTOToAlbum.convert(albumDTO);
        albumLink.setId(1);
        when(albumService.createAlbum(albumDTO)).thenReturn(albumLink);*/

        ResponseEntity<AlbumDTO> responseEntity = albumController.createAlbum(albumDTO);

        assertEquals(responseEntity.getStatusCodeValue(), 200);
        //assertEquals(responseEntity.getBody().getLink(), albumDTO.getLink());
    }
}