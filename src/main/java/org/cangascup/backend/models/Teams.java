package org.cangascup.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "teams")
public class Teams {
    private Integer ID_team;
    private String name_team;
    private String ubication;
    private Integer points;
    private Integer group;


    public Integer getID_team() {
        return ID_team;
    }
    public void setID_team(Integer iD_team) {
        ID_team = iD_team;
    }
    public String getName_team() {
        return name_team;
    }
    public void setName_team(String name_team) {
        this.name_team = name_team;
    }
    public String getUbication() {
        return ubication;
    }
    public void setUbication(String ubication) {
        this.ubication = ubication;
    }
    public Integer getPoints() {
        return points;
    }
    public void setPoints(Integer points) {
        this.points = points;
    }
    public Integer getGroup() {
        return group;
    }
    public void setGroup(Integer group) {
        this.group = group;
    }
}
