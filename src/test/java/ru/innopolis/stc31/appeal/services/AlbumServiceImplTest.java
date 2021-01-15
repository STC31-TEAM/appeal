package ru.innopolis.stc31.appeal.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * Testing AlbumServiceImpl
 */
@SpringJUnitConfig
class AlbumServiceImplTest {

    @InjectMocks
    private AlbumServiceImpl service;

    @Test
    void checkOnOk() {
        assertDoesNotThrow(() -> service.createAlbum(MockUtils.makeAlbumDTO()));
        assertDoesNotThrow(() -> service.deleteAlbum(MockUtils.makeAlbumDTO()));
        assertDoesNotThrow(() -> service.getAlbumList());
    }


    @Test
    void getAlbumList() {
    }

    @Test
    void createAlbum() {
    }

    @Test
    void deleteAlbum() {
    }
}