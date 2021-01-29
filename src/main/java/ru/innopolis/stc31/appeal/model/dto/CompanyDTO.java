package ru.innopolis.stc31.appeal.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Company data transfer object
 */
@Data
@AllArgsConstructor
@Accessors(chain = true)
public class CompanyDTO {

    private long id;
    private long userId;
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
    private String fullAddress;
    private int countClosedTickets;

    public CompanyDTO() {

    }
}
