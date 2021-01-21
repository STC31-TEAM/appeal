package ru.innopolis.stc31.appeal.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Role data transfer object
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class RoleDTO {
    private int id;
    private String title;
}
