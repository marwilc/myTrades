package com.marwilc.mistrueques.model;

/**
 * Created by marwilc on 5/23/18.
 * Package name  com.marwilc.mistrueques.model
 * Time 10:14 PM
 * Project  MisTrueques
 */
public class Trade {
    private String descripcion;
    private String date;
    private Integer idPicture;

    public Trade(String descripcion, String date, int idPicture) {
        this.descripcion = descripcion;
        this.date = date;
        this.idPicture = idPicture;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getIdPicture() {
        return idPicture;
    }

    public void setIdPicture(Integer idPicture) {
        this.idPicture = idPicture;
    }
}
