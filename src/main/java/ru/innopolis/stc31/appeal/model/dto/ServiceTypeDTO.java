package ru.innopolis.stc31.appeal.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Service type data transfer object
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ServiceTypeDTO {
    private long id;
    private String type;
}
