package ru.innopolis.stc31.appeal.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idCity;
    private String streetName;
}
