package ru.innopolis.stc31.appeal.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.innopolis.stc31.appeal.converters.AlbumDTOToAlbum;
import ru.innopolis.stc31.appeal.converters.AlbumToAlbumDTO;
import ru.innopolis.stc31.appeal.model.dto.AlbumDTO;
import ru.innopolis.stc31.appeal.model.entity.AlbumLink;
import ru.innopolis.stc31.appeal.repository.AlbumLinkRepository;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Testing AlbumServiceImpl
 */
@SpringBootTest
@ActiveProfiles({"test"})
class AlbumServiceImplTest {

    @InjectMocks
    private AlbumServiceImpl albumService;

    @Mock
    private AlbumLinkRepository albumLinkRepository;

    @Mock
    private AlbumDTOToAlbum albumDTOToAlbum;

    @Mock
    private AlbumToAlbumDTO albumToAlbumDTO;

    @Test
    void checkOnOk() {
        assertDoesNotThrow(() -> albumService.createAlbum(MockUtils.makeAlbumDTO()));
        assertDoesNotThrow(() -> albumService.deleteAlbum(MockUtils.makeAlbumDTO()));
        assertDoesNotThrow(() -> albumService.getAlbumList());
    }

    @Test
    void getAlbumList() {
    }

    @Test
    void createAlbum() {
        AlbumDTO albumDTO = MockUtils.makeAlbumDTO();
        AlbumLink albumLink = albumDTOToAlbum.convert(albumDTO);
        albumLink.setId(1);
        when(albumLinkRepository.save(albumDTOToAlbum.convert(albumDTO))).thenReturn(albumLink);

        assertEquals(albumService.createAlbum(albumDTO).getId(), albumLink.getId());
    }

    @Test
    void deleteAlbum() {
    }
}
