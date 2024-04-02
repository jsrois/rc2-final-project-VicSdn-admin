package org.cangascup.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "analitycs")
public class Analitycs {
    private Integer ID_statistics;
    private Integer goal;
    private Integer assist;
    private Integer yellow_card;
    private Integer red_card;
    private Integer mvp;

    @Column(name="ID_players")
    private Integer ID_player;

    public Integer getID_statistics() {
        return ID_statistics;
    }

    public void setID_statistics(Integer iD_statistics) {
        ID_statistics = iD_statistics;
    }

    public Integer getGoal() {
        return goal;
    }

    public void setGoal(Integer goal) {
        this.goal = goal;
    }

    public Integer getAssist() {
        return assist;
    }

    public void setAssist(Integer assist) {
        this.assist = assist;
    }

    public Integer getYellow_card() {
        return yellow_card;
    }

    public void setYellow_card(Integer yellow_card) {
        this.yellow_card = yellow_card;
    }

    public Integer getRed_card() {
        return red_card;
    }

    public void setRed_card(Integer red_card) {
        this.red_card = red_card;
    }

    public Integer getMvp() {
        return mvp;
    }

    public void setMvp(Integer mvp) {
        this.mvp = mvp;
    }

    public Integer getID_player() {
        return ID_player;
    }

    public void setID_player(Integer iD_player) {
        ID_player = iD_player;
    }
}
