package dev.aytodesk.aytodeks.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Incidence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIncidence;

    private String titleIncidence;
    private String despriptionIncidence;
    private String typeIncidence;
    private String dateIncidence;

    public Incidence() {
    }

    public Incidence(Long idIncidence, String titleIncidence, String despriptionIncidence, String typeIncidence,
            String dateIncidence) {
        this.idIncidence = idIncidence;
        this.titleIncidence = titleIncidence;
        this.despriptionIncidence = despriptionIncidence;
        this.typeIncidence = typeIncidence;
        this.dateIncidence = dateIncidence;
    }

    public Long getIdIncidence() {
        return idIncidence;
    }

    public void setIdIncidence(Long idIncidence) {
        this.idIncidence = idIncidence;
    }

    public String getTitleIncidence() {
        return titleIncidence;
    }

    public void setTitleIncidence(String titleIncidence) {
        this.titleIncidence = titleIncidence;
    }

    public String getDespriptionIncidence() {
        return despriptionIncidence;
    }

    public void setDespriptionIncidence(String despriptionIncidence) {
        this.despriptionIncidence = despriptionIncidence;
    }

    public String getTypeIncidence() {
        return typeIncidence;
    }

    public void setTypeIncidence(String typeIncidence) {
        this.typeIncidence = typeIncidence;
    }

    public String getDateIncidence() {
        return dateIncidence;
    }

    public void setDateIncidence(String dateIncidence) {
        this.dateIncidence = dateIncidence;
    }

}
