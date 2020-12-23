package ru.innopolis.stc31.appeal.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDate;

/**
 * @author Sergey Fomin
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
}
