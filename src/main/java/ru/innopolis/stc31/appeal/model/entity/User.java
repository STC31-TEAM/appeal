package ru.innopolis.stc31.appeal.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "id_role")
    private long roleId;

    @Column(name = "id_company")
    private long companyId;

    @Column(name = "id_country")
    private long countryId;

    @Column(name = "id_city")
    private long cityId;

    @Column(name = "id_street")
    private long streetId;

    private String login;
    private String password;
    private String email;
    private String phone;
    private String name;
    private String surname;
    private LocalDate birthday;
    private short status;
}