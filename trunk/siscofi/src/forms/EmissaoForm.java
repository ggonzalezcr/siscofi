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

import org.apache.struts.action.ActionForm;

import database.bean.Emissao;
import database.bean.Login;

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
	 * Coloca o valor da quantidade de impressão para 1(um)
	 */
	public void reset(){
		emissao.reset();
	}

}
