package ru.innopolis.stc31.appeal.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Company data transfer object
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CompanyDTO {

    private long id;
    private long serviceTypeId;
    private long countryId;
    private long cityId;
    private long streetId;
    private String login;
    private String password;
    private String email;
    private long phone;
    private String title;
    private short status;
}
