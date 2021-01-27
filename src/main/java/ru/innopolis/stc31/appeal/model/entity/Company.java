package ru.innopolis.stc31.appeal.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "companies")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "id_user")
    private long userId;

    @Column(name = "id_service_type")
    private long serviceTypeId;

    @Column(name = "id_country")
    private long countryId;

    @Column(name = "id_city")
    private long cityId;

    @Column(name = "id_street")
    private long streetId;

    private String login;
    private String password;
    private String email;
    private long phone;
    private String title;
    private short status;
}
