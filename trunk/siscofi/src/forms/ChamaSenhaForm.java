package forms;

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
 *
 * Você deve ter recebido uma cópia da Licença Pública Geral GNU
 * junto com este programa, se não, escreva para a Fundação do Software
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
 * CCT -  CENTRO DE CIÊNCIA E TECNOLOGIA
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
	 * Método que retorna um objeto do tipo Login
	 * @return O login
	 */
	public Login getLogin() {
		return login;
	}

	/**
	 * Método que modifica o objeto Login
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
	 * Método que define se uma String é vazia ou não
	 * @param valor String a ser analisada
	 * @return True se for vazia ou false, caso contrário
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
//		 verifica o guichê
		if (stringVazia(login.getGuiche())) {
		erros.add("guiche", new ActionMessage("erro.guiche"));
		}
		return erros;
		}
}
