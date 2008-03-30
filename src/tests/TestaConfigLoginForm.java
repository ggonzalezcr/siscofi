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

package tests;

import controller.TiposLogin;
import junit.framework.TestCase;
import forms.ConfigLoginForm;

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
 * Classe que testa a classe ConfigLoginForm
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class TestaConfigLoginForm extends TestCase {

	private ConfigLoginForm conf;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		conf = new ConfigLoginForm();
		conf.setTipoLogin(TiposLogin.LOGIN_BD);
	}

	/**
	 * Test method for {@link forms.ConfigLoginForm#getTipoLogin()}.
	 */
	public void testGetNumero() {
		assertEquals(TiposLogin.LOGIN_BD, conf.getTipoLogin());
		conf.setTipoLogin(TiposLogin.LOGIN_LDAP);
		assertEquals(TiposLogin.LOGIN_LDAP, conf.getTipoLogin());
	}

	/**
	 * Test method for {@link forms.ConfigLoginForm#setTipoLogin(String)}.
	 */
	public void testSetNumero() {
		assertEquals(TiposLogin.LOGIN_BD, conf.getTipoLogin());
		conf.setTipoLogin(TiposLogin.LOGIN_LDAP);
		conf.setTipoLogin("qualquer");
		assertEquals("qualquer", conf.getTipoLogin());
	}

}
