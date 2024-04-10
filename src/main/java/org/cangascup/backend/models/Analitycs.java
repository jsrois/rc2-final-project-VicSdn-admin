package org.cangascup.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "analitycs")
public class Analitycs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_player;
    private Integer goal;
    private Integer assist;
    private Integer yellow_card;
    private Integer red_card;
    private Integer mvp;

    public Analitycs() {
    }

    public Integer getID_player() {
        return ID_player;
    }

    public void setID_player(Integer iD_player) {
        ID_player = iD_player;
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

}
