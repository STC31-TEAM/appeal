package ru.innopolis.stc31.appeal.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tickets")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(name = "id_country")
    private long countryId;

    @Column(name = "id_city")
    private long cityId;

    @Column(name = "id_street")
    private long streetId;

    @Column(name = "id_user")
    private long creatorUserId;

    @Column(name = "id_company")
    private Integer companyId;

    @Column(name = "id_service_type")
    private long serviceTypeId;

    @Column(name = "id_album_link")
    private long albumLinkId;

    private String title;
    private String description;
    private short status;

    @Column(name = "open_date")
    private LocalDate openedOn;

    @Column(name = "close_date")
    private LocalDate closedOn;

    @Column(name = "count_likes")
    private int likes;

    @Column(name = "count_dislikes")
    private int dislikes;

}