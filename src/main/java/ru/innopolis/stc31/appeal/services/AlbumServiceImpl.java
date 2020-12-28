package ru.innopolis.stc31.appeal.services;

import org.springframework.stereotype.Service;
import ru.innopolis.stc31.appeal.model.dto.AlbumDTO;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService{
    @Override
    public List<AlbumDTO> getAlbumList() {
        return null;
    }

    @Override
    public boolean createAlbum(AlbumDTO albumDTO) {
        return false;
    }

    @Override
    public boolean deleteAlbum(AlbumDTO albumDTO) {
        return false;
    }
}
