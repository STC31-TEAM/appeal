package ru.innopolis.stc31.appeal.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Munir Makhmutov
 * @version 1.0.0
 */
@Entity
@Table(name = "streets")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Street {

    @Id
    @GeneratedValue
    private long id;
    private long streetId;
    private String streetName;
}
