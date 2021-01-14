package ru.innopolis.stc31.appeal.converters;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.innopolis.stc31.appeal.model.dto.AlbumDTO;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ActiveProfiles({"test"})
class AlbumDTOToAlbumTest {

    @Autowired
    private AlbumDTOToAlbum albumDTOToAlbum;

    @Test
    void convert() {
        AlbumDTO albumDTO = MockUtils.makeAlbumDTO();
        assertEquals(albumDTOToAlbum.convert(albumDTO).getLink(),albumDTO.getLink());
    }
}