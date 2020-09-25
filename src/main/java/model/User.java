/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package model;

import java.io.Serializable;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import exceptions.CredentialsException;
import exceptions.MailNotValid;
import exceptions.passwordException;




/*
 * Author: Alessio Spina
 * Class: User
 * Description: An entity is annotated as @Entity, and has a special relationship with your database - generally 
 * 				each instance of an entity corresponds to a single row and the class itself corresponds to the table 
 * 				in which those rows are stored. In any case, we supply annotations for persistence on our entity classes. 
 * 				[User is a Entity who rappresents a list of accounts situated in the table "User" of DB.]
 * 				
 * 				Un'entità è annotata come @Entity e ha una relazione speciale con il tuo database - in generale
 * 				ogni istanza di un'entità corrisponde a una singola riga e la classe stessa corrisponde alla tabella
 * 				in cui sono archiviate tali righe.
 * */

@Entity
@Table(name="user")
public class User implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	

	@Column(name="nome")
	private String nome;
	
        @Column(name="cognome")
	private String cognome;
        
       	

	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;

    public User(String nome, String cognome, String username, String password) {
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.password = password;
    }
	

	
	
	
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws CredentialsException {
		if(nome.length()==0 || !checkCredentials(nome))
			throw new CredentialsException("Nome inserito non valido. \nN.B. Spazi e Numeri non sono accettati");
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) throws CredentialsException {
		if(cognome.length()==0 || !checkCredentials(cognome))
			throw new CredentialsException("Cognome inserito non valido. \nN.B. Spazi e Numeri non sono accettati");
		this.cognome = cognome;
	}
        
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) throws MailNotValid {
		
		if(username != null) {
		 Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
         Matcher mat = pattern.matcher(username);		
         if(!mat.matches())
        	throw new MailNotValid("eMail non valida!");
		}
		
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) throws passwordException {
		if(password.length()<=5 || !checkPassword(password))
			throw new passwordException("Password inserita non valida");
		else
			this.password = password;
	}


	
	
	
	public boolean checkPassword(String password) {
		int count = 0;
		for(int i=0; i<password.length(); i++) {
			char x = password.charAt(i);
			
			if(Character.isWhitespace(x))
				break;
			else
				count++;
		}
		
		if(count == password.length())
			return true;
		else
			return false;
		
	}
	

	public boolean checkCredentials(String name) {
		int count = 0;
		for(int i=0; i<name.length(); i++) {
			char x = name.charAt(i);
			
			if(Character.isJavaLetter(x))
				count++;
			else
				break;
		}
		
		if(count == name.length())
			return true;
		else
			return false;
	}
}