package ru.innopolis.stc31.appeal.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

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
    private String name;
    private String surname;
    private String password;
    private String email;
    private long phone; // TO DO нужно поменять формат поля для телефона в модели и в БД на String
    private String birthday;
    private short status;
    private long companyId;
    private long countryId;
    private long cityId;
    private long streetId;
}
