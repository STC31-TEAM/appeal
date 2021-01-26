package ru.innopolis.stc31.appeal.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * @author Munir Makhmutov
 * @version 1.0.0
 */
@Entity
@Table(name = "cities")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class City {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "id_country")
    private long countryId;

    @Column(name = "city_name")
    private String cityName;
}
