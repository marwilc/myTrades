package com.marwilc.mistrueques.model;

/**
 * Created by marwilc on 5/13/18.
 * Package name  com.marwilc.mistrueques.model
 * Time 2:33 PM
 * Project  MisTrueques
 * Esta clase representa el modelo de menssages
 */

public class InboxMenssage {

    private String userName;
    private String contentMenssage;
    private String dateMenssage;
    private int idProfilePicture;

    public InboxMenssage(String userName, String contentMenssage, String dateMenssage, int idProfilePicture) {
        this.userName = userName;
        this.contentMenssage = contentMenssage;
        this.dateMenssage = dateMenssage;
        this.idProfilePicture = idProfilePicture;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContentMenssage() {
        return contentMenssage;
    }

    public void setContentMenssage(String contentMenssage) {
        this.contentMenssage = contentMenssage;
    }

    public String getDateMenssage() {
        return dateMenssage;
    }

    public void setDateMenssage(String dateMenssage) {
        this.dateMenssage = dateMenssage;
    }

    public int getIdProfilePicture() {
        return idProfilePicture;
    }

    public void setIdProfilePicture(int idProfilePicture) {
        this.idProfilePicture = idProfilePicture;
    }
}
