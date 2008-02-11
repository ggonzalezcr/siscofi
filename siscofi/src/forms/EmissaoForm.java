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

import org.apache.struts.action.ActionForm;

import database.bean.Emissao;
import database.bean.Login;

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
 * Classe que representa um Form da classe Emissao
 * 
 * @author Carlos Trajano
 * @author Hamon Barros
 * @author Rodrigo Lopes
 * 
 * @version 1.0
 */

public class EmissaoForm extends ActionForm {

	private static final long serialVersionUID = 1L;

	// Atributos de classe
	private Emissao emissao = new Emissao();
	private Login login = new Login();

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
	 * Metodo que retorna a Emissao
	 * 
	 * @return a emissao
	 */
	public Emissao getEmissao() {
		return emissao;
	}

	/**
	 * Metodo que modifica a emissao
	 * @param emissao a nova emissao
	 */
	public void setEmissao(Emissao emissao) {
		this.emissao = emissao;
	}
	
	/**
	 * Coloca o valor da quantidade de impress�o para 1(um)
	 */
	public void reset(){
		emissao.reset();
	}

}
