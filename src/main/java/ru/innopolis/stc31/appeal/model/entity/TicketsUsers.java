package ru.innopolis.stc31.appeal.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "tickets_users")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TicketsUsers {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "id_user")
    private long userId;

    @Column(name = "id_ticket")
    private long ticketId;

    @Column(name = "user_reaction")
    private boolean userReaction;
}