package ru.innopolis.stc31.appeal.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;

/**
 * Ticket data transfer object
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class TicketDTO {
    private long id;
    private long idUser;
    private Integer idCompany;
    private long idCountry;
    private long idCity;
    private long idStreet;
    private long idTypesServices;
    private long idAlbumLink;
    private String titles;
    private String description;
    private LocalDate openDate;
    private LocalDate closeDate;
    private int countLikes;
    private int countDisLikes;
    private short status;
    private CompanyDTO companyDTO;
    private CityDTO cityDTO;

    public int getLikes() {
        return countLikes - countDisLikes;
    }

    public String getLikesString() {
        int diff = getLikes();

        if (diff == 0) return "0";

        return diff > 0 ? "+" + diff : "" + diff;
    }
}
