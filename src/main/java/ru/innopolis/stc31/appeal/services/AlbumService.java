package ru.innopolis.stc31.appeal.services;

import ru.innopolis.stc31.appeal.model.dto.AlbumDTO;

import java.util.List;

/**
 * interface for Album services
 *
 * @author v.shulepov
 */
public interface AlbumService {
    /**
     * return list of all albums
     * @return list of albums
     */
    List<AlbumDTO> getAlbumList();

    /**
     * create new album
     * @param albumDTO album
     * @return result of operation
     */
    boolean createAlbum(AlbumDTO albumDTO);

    /**
     * delete album from base
     * @param albumDTO album needed to remove
     * @return result of operation
     */
    boolean deleteAlbum(AlbumDTO albumDTO);
}
