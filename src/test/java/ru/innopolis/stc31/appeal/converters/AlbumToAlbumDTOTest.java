package ru.innopolis.stc31.appeal.converters;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.innopolis.stc31.appeal.model.entity.AlbumLink;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ActiveProfiles({"test"})
class AlbumToAlbumDTOTest {

    @Autowired
    private AlbumDTOToAlbum albumDTOToAlbum;

    @Autowired
    private AlbumToAlbumDTO albumToAlbumDTO;

    @Test
    void convert() {
        AlbumLink albumLink = albumDTOToAlbum.convert(MockUtils.makeAlbumDTO());
        assertEquals(albumDTOToAlbum.convert(albumLink).getLink(), albumLink.getLink());
    }
}