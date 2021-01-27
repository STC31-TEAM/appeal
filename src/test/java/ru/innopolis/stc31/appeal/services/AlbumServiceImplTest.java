package ru.innopolis.stc31.appeal.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.innopolis.stc31.appeal.converters.AlbumDTOToAlbum;
import ru.innopolis.stc31.appeal.converters.AlbumToAlbumDTO;
import ru.innopolis.stc31.appeal.model.dto.AlbumDTO;
import ru.innopolis.stc31.appeal.model.dto.StreetDTO;
import ru.innopolis.stc31.appeal.model.entity.AlbumLink;
import ru.innopolis.stc31.appeal.model.entity.Street;
import ru.innopolis.stc31.appeal.repository.AlbumLinkRepository;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Testing AlbumServiceImpl
 */
@SpringJUnitConfig
class AlbumServiceImplTest {

    @InjectMocks
    private AlbumServiceImpl service;

    @Mock
    private AlbumLinkRepository albumLinkRepository;

    @Spy
    private AlbumToAlbumDTO albumToAlbumDTO;

    @Spy
    private AlbumDTOToAlbum albumDTOToAlbum;

    @Test
    void checkOnOk() {
        assertDoesNotThrow(() -> service.createAlbum(MockUtils.makeAlbumDTO()));
        assertDoesNotThrow(() -> service.deleteAlbum(MockUtils.makeAlbumDTO()));
        assertDoesNotThrow(() -> service.getAlbumList());
    }

    @Test
    void getAlbumList() {
        List<AlbumLink> albumLinkList = new ArrayList<>();
        for (int count = 1; count < 6; count++){
            albumLinkList.add(new AlbumLink(count, count * 3, "test album" + count));
        }
        when(albumLinkRepository.findAll()).thenReturn(albumLinkList);

        List<AlbumDTO> albumDTOList = service.getAlbumList();

        assertEquals(albumLinkList.size(), albumDTOList.size());
        assertEquals(albumLinkList.get(1).getLink(), albumDTOList.get(1).getLink());
    }

    @Test
    void createAlbum() {
        AlbumDTO albumDTO = new AlbumDTO(1, 3, "album test");
        AlbumLink albumLink = albumDTOToAlbum.convert(albumDTO);
        when(albumLinkRepository.save(albumLink)).thenReturn(albumLink);

        assertEquals(service.createAlbum(albumDTO).getAlbumLinkId(), albumDTO.getId_link());
        assertEquals(service.createAlbum(albumDTO).getLink(), albumDTO.getLink());
    }

    @Test
    void deleteAlbum() {
        AlbumDTO albumDTO = MockUtils.makeAlbumDTO();
        assertEquals(service.deleteAlbum(albumDTO), true);
        verify(albumLinkRepository).deleteById(any());
    }
}