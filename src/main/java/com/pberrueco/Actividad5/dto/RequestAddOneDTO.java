package com.pberrueco.Actividad5.dto;

public class RequestAddOneDTO {

    private String name;
    private String surname;
    private Integer notamedia;
    private Long universidad;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getNotamedia() {
        return notamedia;
    }

    public void setNotamedia(Integer notamedia) {
        this.notamedia = notamedia;
    }

    public Long getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Long universidad) {
        this.universidad = universidad;
    }



}
