package ru.innopolis.stc31.appeal.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors
public class Role {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "role")
    private String title;
}
