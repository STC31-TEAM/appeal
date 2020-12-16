package ru.innopolis.stc31.appeal.controllers;

import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc31.appeal.model.dto.AlbumDTO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Controller for manage albums
 *
 * @author Sergey Fomin
 */
@RestController
@RequestMapping("/album")
public class AlbumController {
    /**
     * Get list of all albums
     *
     * @return List of albums
     */
    @GetMapping("/all")
    public List<AlbumDTO> all() {
        // TODO: render edit form
        return null;
    }

    /**
     * Create new album
     *
     * @param dto Model
     * @return true if success created
     */
    @PostMapping("/create")
    public boolean create(@RequestBody AlbumDTO dto) {
        // TODO: save album
        return false;
    }
}
