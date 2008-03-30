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

package tests;

import controller.TiposLogin;
import junit.framework.TestCase;
import forms.ConfigLoginForm;

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
