package ru.innopolis.stc31.appeal.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "album_links")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AlbumLink {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "id_link")
    private long albumLinkId;

    @Column(name = "link")
    private String link;
}
