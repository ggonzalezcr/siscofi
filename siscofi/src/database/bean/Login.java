package database.bean;

/**
 * Este arquivo é parte do programa Siscofi
 * 
 * Siscofi é um software livre; você pode redistribui-lo e/ou
 * modificá-lo dentro dos termos da Licença Pública Geral GNU como
 * publicada pela Fundação do Software Livre (FSF); na versão 3 da
 * Licença.
 * 
 * Este programa é distribuído na esperança que possa ser útil,
 * mas SEM NENHUMA GARANTIA; sem uma garantia implícita de ADEQUAÇÂO a qualquer
 * MERCADO ou APLICAÇÃO EM PARTICULAR. Veja a
 * Licença Pública Geral GNU para maiores detalhes.

 * Você deve ter recebido uma cópia da Licença Pública Geral GNU
 * junto com este programa, se não, escreva para a Fundação do Software
 * Livre(FSF) Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA
 * 
 * Copyright 2007, 2008 Carlos Trajano de Oliveira, Hamon Barros Henriques, Rodrigo Lopes da Silva
 */

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
 * CCT -  CENTRO DE CIÊNCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO 1
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES DA SILVA
 */

/**
 * Bean que armazena as características do login do sistema
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
	 * @return o guichê
	 */
	public String getGuiche() {
		return guiche;
	}

	/**
	 * @param guiche O novo guichê
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
