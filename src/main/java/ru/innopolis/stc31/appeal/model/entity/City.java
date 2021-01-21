package ru.innopolis.stc31.appeal.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cities")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class City {

    @Id
    @GeneratedValue
    private long id;
    private long countryId;
    private String cityName;
}
