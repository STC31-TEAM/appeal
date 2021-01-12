package ru.innopolis.stc31.appeal.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import java.time.LocalDate;

/**
 * User data transfer object
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class UserDTO {
    private long id;
    private String login;
    private String username;
    private String email;
    private long phone;
    private LocalDate birthday;
    private short status;
    private long mapRoleId;
    private long companyId;
    private long countryId;
    private long cityId;
    private long streetId;
}
