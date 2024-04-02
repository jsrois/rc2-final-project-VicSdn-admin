package org.cangascup.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "players")
public class Players {
    private Integer ID_player;
    private String name;
    private String second_name;
    private String dni;
    @Column(name="ID_team")
    private Integer ID_team;

    
    public Integer getID_player() {
        return ID_player;
    }
    public void setID_player(Integer iD_player) {
        ID_player = iD_player;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSecond_name() {
        return second_name;
    }
    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public Integer getID_team() {
        return ID_team;
    }
    public void setID_team(Integer iD_team) {
        ID_team = iD_team;
    }
}