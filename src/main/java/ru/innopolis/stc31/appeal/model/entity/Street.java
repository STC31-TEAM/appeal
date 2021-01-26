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
@Table(name = "streets")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Street {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long idCity;
    private String streetName;
}
