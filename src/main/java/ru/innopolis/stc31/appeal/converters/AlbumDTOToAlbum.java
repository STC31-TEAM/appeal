package ru.innopolis.stc31.appeal.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.innopolis.stc31.appeal.model.dto.AlbumDTO;
import ru.innopolis.stc31.appeal.model.entity.AlbumLink;

@Component
public class AlbumDTOToAlbum implements Converter {

    @Override
    public AlbumLink convert(AlbumDTO source) {
        AlbumLink albumLink = new AlbumLink();
        albumLink.setAlbumLinkId(source.getId_link());
        albumLink.setLink(source.getLink());
        return albumLink;
    }
}
