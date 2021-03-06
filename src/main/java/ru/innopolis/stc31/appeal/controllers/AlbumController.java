package ru.innopolis.stc31.appeal.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc31.appeal.converters.AlbumToAlbumDTO;
import ru.innopolis.stc31.appeal.model.SuccessModel;
import ru.innopolis.stc31.appeal.model.dto.AlbumDTO;
import ru.innopolis.stc31.appeal.services.AlbumService;

import java.util.List;

/**
 * Controller for manage albums
 */
@RestController
@AllArgsConstructor
@RequestMapping("${application.api.uriPrefix}/album")
@Slf4j
public class AlbumController {

    /** Album service instance */
    private final AlbumService albumService;

    private final AlbumToAlbumDTO albumToAlbumDTO;

    /**
     * Get list of all albums
     *
     * @return List of albums
     */
    @GetMapping("/all")
    @ApiOperation("Получить список всех альбомов")
    public List<AlbumDTO> getAllAlbums() {
        return albumService.getAlbumList();
    }

    /**
     * Create new album
     *
     * @param albumDTO Model
     * @return ResponseEntity if success created
     */
    @PostMapping("/create")
    @ApiOperation("Добить новый альбом")
    public ResponseEntity<AlbumDTO> createAlbum(@RequestBody AlbumDTO albumDTO) {
        log.debug("create album method was called this {} ", albumDTO);

        var album = albumService.createAlbum(albumDTO);
        if (album == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        log.debug("create album method return result {} ", album);

        return new ResponseEntity<>(albumToAlbumDTO.convert(album),HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ApiOperation("Удалить альбом")
    public ResponseEntity<SuccessModel> deleteAlbum(@RequestBody AlbumDTO albumDTO) {

        log.debug("delete album method was called with {} ", albumDTO);

        var isRemoved = albumService.deleteAlbum(albumDTO);

        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        SuccessModel successModel = new SuccessModel().setResult("OK");
        log.debug("delete album method return result {} ", successModel);
        return new ResponseEntity<>(successModel, HttpStatus.OK);
    }
}
