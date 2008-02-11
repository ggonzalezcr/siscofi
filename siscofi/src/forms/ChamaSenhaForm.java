package forms;

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
 *
 * Voc� deve ter recebido uma c�pia da Licen�a P�blica Geral GNU
 * junto com este programa, se n�o, escreva para a Funda��o do Software
 * Livre(FSF) Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA
 *
 * Copyright 2007, 2008 Carlos Trajano de Oliveira, Hamon Barros Henriques, Rodrigo Lopes da Silva
 */

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import database.bean.Login;
import database.bean.Solicitacao;

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
 * CCT -  CENTRO DE CI�NCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO 1
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES
 */

/**
 * Classe que representa um Form da classe ChamaSenha
 * 
 * @author Carlos Trajano
 * @author Hamon Barros
 * @author Rodrigo Lopes
 * 
 * @version 1.0
 */

public class ChamaSenhaForm extends ActionForm {

	// Atributos de classe
	private static final long serialVersionUID = 1L;

	private Solicitacao chamaSenha = new Solicitacao();
	private Login login = new Login();
	private String guiche;

	public String getGuiche() {
		return login.getGuiche();
	}

	public void setGuiche(String guiche) {
		this.guiche = guiche;
		login.setGuiche(guiche);
	}

	/**
	 * M�todo que retorna um objeto do tipo Login
	 * @return O login
	 */
	public Login getLogin() {
		return login;
	}

	/**
	 * M�todo que modifica o objeto Login
	 * @param login O novo login
	 */
	public void setLogin(Login login) {
		this.login = login;
	}

	/**
	 * Metodo quer retorna um objeto do tipo chamaSenha
	 * 
	 * @return o objeto chamaSenha
	 */
	public Solicitacao getChamaSenha() {
		return chamaSenha;
	}

	/**
	 * Metodo que modifica o objeto chamaSenha
	 * 
	 * @param chamaSenha
	 *            o objeto chamaSenha
	 */
	public void setChamaSenha(Solicitacao chamaSenha) {
		this.chamaSenha = chamaSenha;
	}

	/**
	 * M�todo que define se uma String � vazia ou n�o
	 * @param valor String a ser analisada
	 * @return True se for vazia ou false, caso contr�rio
	 */
	private boolean stringVazia(String valor) {
		return valor == null || valor.trim().length() == 0;
	}
	
	public ActionErrors validate(ActionMapping map, HttpServletRequest req) {
		ActionErrors erros = new ActionErrors();
//		 verifica o login
		if (stringVazia(login.getLogin())) {
		erros.add("login", new ActionMessage("erro.login"));
		}
//		 verifica o password
		if (stringVazia(login.getPassword())) {
		erros.add("password", new ActionMessage("erro.password"));
		}
//		 verifica o guich�
		if (stringVazia(login.getGuiche())) {
		erros.add("guiche", new ActionMessage("erro.guiche"));
		}
		return erros;
		}
}
