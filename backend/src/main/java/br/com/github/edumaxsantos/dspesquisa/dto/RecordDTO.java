package br.com.github.edumaxsantos.dspesquisa.dto;

import br.com.github.edumaxsantos.dspesquisa.entities.Record;
import br.com.github.edumaxsantos.dspesquisa.entities.enums.Platform;

import java.io.Serializable;
import java.time.LocalDateTime;

public class RecordDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private LocalDateTime moment;
    private String name;
    private Integer age;
    private String gameTitle;
    private Platform gamePlatform;
    private String genreName;

    public RecordDTO() {
    }

    public RecordDTO(Record entity) {
        id = entity.getId();
        moment = entity.getMoment();
        name = entity.getName();
        age = entity.getAge();
        gameTitle = entity.getGame().getTitle();
        gamePlatform = entity.getGame().getPlatform();
        genreName = entity.getGame().getGenre().getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public Platform getGamePlatform() {
        return gamePlatform;
    }

    public void setGamePlatform(Platform gamePlatform) {
        this.gamePlatform = gamePlatform;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
