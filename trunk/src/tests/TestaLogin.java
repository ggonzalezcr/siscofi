package tests;

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

import database.bean.Login;
import junit.framework.TestCase;

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
 * Classe que testa a classe Login
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */
public class TestaLogin extends TestCase {

	 Login login1 = new Login();
	 Login login2 = new Login();
	 
	/**
	 * Construtor
	 */
	public TestaLogin(String arg0) {
		super(arg0);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * Test method for {@link database.bean.Login#getGuiche()}.
	 */
	public void testGetGuiche() {
		login1.setGuiche("01");
		assertEquals("01", login1.getGuiche());
		login2.setGuiche("02");
		assertEquals("02", login2.getGuiche());
	}

	/**
	 * Test method for {@link database.bean.Login#setGuiche(java.lang.String)}.
	 */
	public void testSetGuiche() {
		login1.setGuiche("01");
		assertEquals("01", login1.getGuiche());
		login2.setGuiche("02");
		assertEquals("02", login2.getGuiche());

	}

	/**
	 * Test method for {@link database.bean.Login#getLogin()}.
	 */
	public void testGetLogin() {
		login1.setLogin("admin");
		assertEquals("admin", login1.getLogin());
		login2.setLogin("admin2");
		assertEquals("admin2", login2.getLogin());
	}

	/**
	 * Test method for {@link database.bean.Login#setLogin(java.lang.String)}.
	 */
	public void testSetLogin() {
		login1.setLogin("admin");
		assertEquals("admin", login1.getLogin());
		login1.setLogin("admin2");
		assertEquals("admin2", login1.getLogin());
		
	}

	/**
	 * Test method for {@link database.bean.Login#getPassword()}.
	 */
	public void testGetPassword() {
		login1.setPassword("admin");
		assertEquals("admin", login1.getPassword());
		login2.setPassword("admin2");
		assertEquals("admin2", login2.getPassword());
	}

	/**
	 * Test method for {@link database.bean.Login#setPassword(java.lang.String)}.
	 */
	public void testSetPassword() {
		login1.setPassword("admin");
		assertEquals("admin", login1.getPassword());
		login1.setPassword("admin2");
		assertEquals("admin2", login1.getPassword());
	}

}
