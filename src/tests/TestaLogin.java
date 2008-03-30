package tests;

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

import database.bean.Login;
import junit.framework.TestCase;

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
