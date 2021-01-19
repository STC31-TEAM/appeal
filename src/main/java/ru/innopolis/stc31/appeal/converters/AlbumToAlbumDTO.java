package ru.innopolis.stc31.appeal.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.innopolis.stc31.appeal.model.dto.AlbumDTO;
import ru.innopolis.stc31.appeal.model.entity.AlbumLink;

@Component
public class AlbumToAlbumDTO implements Converter<AlbumLink, AlbumDTO> {

    @Override
    public AlbumDTO convert(AlbumLink source) {
        AlbumDTO albumDTO = new AlbumDTO();
        albumDTO.setId(source.getId());
        albumDTO.setId_link(source.getAlbumLinkId());
        albumDTO.setLink(source.getLink());
        return albumDTO;
    }
}
