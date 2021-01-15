package ru.innopolis.stc31.appeal.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * City data transfer object
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class CityDTO {

    private long id;
    private int countryId;
    private String cityName;
}
