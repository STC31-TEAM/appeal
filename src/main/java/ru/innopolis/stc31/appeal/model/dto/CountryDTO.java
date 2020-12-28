package ru.innopolis.stc31.appeal.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author Sergey Fomin
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class CountryDTO {

    private int id;
    private String countryName;
}
