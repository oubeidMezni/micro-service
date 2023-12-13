package com.esprit.forum.forum.entity;

import javax.persistence.*;

import java.io.Serializable;

@Entity
public class Forum implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 795450928237931201L;

    @Id
    @GeneratedValue
    private int idForum;
    private String titre;
    private String description;

    public void setIdForum(int idForum) {
        this.idForum = idForum;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdForum() {
        return idForum;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public Forum() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Forum(String titre, String description) {
        super();
        this.titre = titre;
        this.description = description;
    }

}
