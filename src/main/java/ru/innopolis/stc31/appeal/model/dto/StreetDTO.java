package ru.innopolis.stc31.appeal.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Street data transfer object
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class StreetDTO {

    private long id;
    private long idCity;
    private String streetName;
}
