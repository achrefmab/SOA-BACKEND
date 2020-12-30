package com.projet.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "etudiant")
public class Etudiant {
		@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
		
		  private long id;
		  private int code;
		  public Etudiant() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Etudiant(long id, int code, String adresse, String tel, String email, String login, String pwd,
				Date cree) {
			super();
			this.id = id;
			this.code = code;
			this.adresse = adresse;
			this.tel = tel;
			this.email = email;
			this.login = login;
			this.pwd = pwd;
			this.cree = cree;
		}
		@Override
		public String toString() {
			return "Etudiant [id=" + id + ", code=" + code + ", adresse=" + adresse + ", tel=" + tel + ", email="
					+ email + ", login=" + login + ", pwd=" + pwd + ", cree=" + cree + "]";
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public int getCode() {
			return code;
		}
		public void setCode(int code) {
			this.code = code;
		}
		public String getAdresse() {
			return adresse;
		}
		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}
		public String getTel() {
			return tel;
		}
		public void setTel(String tel) {
			this.tel = tel;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getLogin() {
			return login;
		}
		public void setLogin(String login) {
			this.login = login;
		}
		public String getPwd() {
			return pwd;
		}
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
		public Date getCree() {
			return cree;
		}
		public void setCree(Date cree) {
			this.cree = cree;
		}
		private String adresse;
		  private String tel;
		  private String email;
		  private String login;
		  private String pwd;
		  private Date cree;
		 

}
