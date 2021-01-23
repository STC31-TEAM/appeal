package ru.innopolis.stc31.appeal.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;

/**
 * Ticket data transfer object
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class TicketDTO {
    private long id;
    private long idUser;
    private long idCompany;
    private long idCountry;
    private long idCity;
    private long idStreet;
    private long idTypesServices;
    private long idLink;
    private String titles;
    private String description;
    private LocalDate openDate;
    private LocalDate closeDate;
    private int countLikes;
    private int countDisLikes;
    private short status;

}
