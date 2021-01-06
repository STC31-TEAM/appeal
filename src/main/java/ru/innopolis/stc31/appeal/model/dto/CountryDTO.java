package ru.innopolis.stc31.appeal.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Country data transfer object
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class CountryDTO {

    private long id;
    private String countryName;
}
