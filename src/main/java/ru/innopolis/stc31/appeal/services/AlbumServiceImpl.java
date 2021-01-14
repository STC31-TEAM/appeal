package ru.innopolis.stc31.appeal.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.innopolis.stc31.appeal.converters.AlbumDTOToAlbum;
import ru.innopolis.stc31.appeal.converters.AlbumToAlbumDTO;
import ru.innopolis.stc31.appeal.model.dto.AlbumDTO;
import ru.innopolis.stc31.appeal.model.entity.AlbumLink;
import ru.innopolis.stc31.appeal.repository.AlbumLinkRepository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class AlbumServiceImpl implements AlbumService{

    private final AlbumLinkRepository albumLinkRepository;
    private final AlbumToAlbumDTO albumToAlbumDTO;
    private final AlbumDTOToAlbum albumDTOToAlbum;

    @Override
    public List<AlbumDTO> getAlbumList() {
        List<AlbumLink> albumLinkList = albumLinkRepository.findAll();
        List<AlbumDTO> albumDTOList = new ArrayList<>();
        for (AlbumLink albumLink : albumLinkList) {
            albumDTOList.add(albumToAlbumDTO.convert(albumLink));
        }
        return albumDTOList;
    }

    @Override
    public AlbumLink createAlbum(AlbumDTO albumDTO) {
        return albumLinkRepository.save(albumDTOToAlbum.convert(albumDTO));
    }

    @Override
    public boolean deleteAlbum(AlbumDTO albumDTO) {
        return false;
    }
}
