package ru.innopolis.stc31.appeal.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * @deprecated (map roles are not needed anymore,
 *remove MapRolesRepository and other related classes)
 */
@Deprecated
@Entity
@Table(name = "map_roles")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MapRoles {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "id_user")
    private long userId;

    @Column(name = "id_company")
    private long companyId;

    @Column(name = "id_role")
    private int roleId;
}
