/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
/**
 *
 * @author coppg
 */
@Entity
@Table(name="Recensione")
public class Recensione implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="testo")
	private String testo;
        
        @Column(name="voto")
            private Integer voto;
        
        @Column(name="titolo")
	private String titolo;
        
        
        @OneToMany
        @JoinColumn(name="id_utente", referencedColumnName="id")
        private Integer id_utente;
        
        @OneToMany
        @JoinColumn(name="id_struttura", referencedColumnName="id")
        private Integer id_struttura;

    public Recensione(Integer id, String testo, Integer voto, String titolo) {
        this.id = id;
        this.testo = testo;
        this.voto = voto;
        this.titolo = titolo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public Integer getVoto() {
        return voto;
    }

    public void setVoto(Integer voto) {
        this.voto = voto;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
        
        
        
}




