package ru.innopolis.stc31.appeal.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc31.appeal.model.dto.AlbumDTO;
import ru.innopolis.stc31.appeal.services.AlbumService;

import java.util.List;

/**
 * Controller for manage albums
 *
 * @author Sergey Fomin
 */
@RestController
@AllArgsConstructor
@RequestMapping("${application.api.uriPrefix}/album")
public class AlbumController {
    /**
     * Service instance
     */
    private final AlbumService albumService;

    /**
     * Get list of all albums
     *
     * @return List of albums
     */
    @GetMapping("/all")
    @ApiOperation("Получить список всех альбомов")
    public List<AlbumDTO> all() {
        return albumService.getAlbumList();
    }

    /**
     * Create new album
     *
     * @param dto Model
     * @return true if success created
     */
    @PostMapping("/create")
    @ApiOperation("Добить новый альбом")
    public boolean create(@RequestBody AlbumDTO dto) {
        return albumService.createAlbum(dto);
    }
}
