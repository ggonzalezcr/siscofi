package database.bean;

/**
 * Este arquivo � parte do programa Siscofi
 * 
 * Siscofi � um software livre; voc� pode redistribui-lo e/ou
 * modific�-lo dentro dos termos da Licen�a P�blica Geral GNU como
 * publicada pela Funda��o do Software Livre (FSF); na vers�o 3 da
 * Licen�a.
 * 
 * Este programa � distribu�do na esperan�a que possa ser �til,
 * mas SEM NENHUMA GARANTIA; sem uma garantia impl�cita de ADEQUA��O a qualquer
 * MERCADO ou APLICA��O EM PARTICULAR. Veja a
 * Licen�a P�blica Geral GNU para maiores detalhes.

 * Voc� deve ter recebido uma c�pia da Licen�a P�blica Geral GNU
 * junto com este programa, se n�o, escreva para a Funda��o do Software
 * Livre(FSF) Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA
 * 
 * Copyright 2007, 2008 Carlos Trajano de Oliveira, Hamon Barros Henriques, Rodrigo Lopes da Silva
 */

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
 * CCT -  CENTRO DE CI�NCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO 1
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES DA SILVA
 */

/**
 * Bean que armazena as caracter�sticas do login do sistema
 *
 * @author Carlos Trajano
 * @author Hamon Barros
 * @author Rodrigo Lopes
 * 
 * @version 1.0
 *
 */
@Entity
public class Login {
	//Atributos
	@Id
	private String login = "admin";
	private String password = "admin";
	private String guiche;
	

	/**
	 * @return o guich�
	 */
	public String getGuiche() {
		return guiche;
	}

	/**
	 * @param guiche O novo guich�
	 */
	public void setGuiche(String guiche) {
		this.guiche = guiche;
	}
	/**
	 * @return O login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @param login O novo login
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * @return O password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password O novo password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
