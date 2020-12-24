package ru.innopolis.stc31.appeal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Model for the users table
 */
@Entity
public class UserModel extends AbstractModel {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String login;
    private int roleId;
    private int rate;

    /**
     * Default constructor
     */
    public UserModel() {

    }

    /**
     * @param name   User name
     * @param login  User login
     * @param roleId User role_id
     * @param rate   User rate
     */
    public UserModel(String name, String login, int roleId, int rate) {
        this.name = name;
        this.login = login;
        this.roleId = roleId;
        this.rate = rate;
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", roleId=" + roleId +
                ", rate=" + rate +
                '}';
    }
}

