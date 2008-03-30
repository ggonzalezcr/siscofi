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

import junit.framework.TestCase;
import database.bean.Login;
import database.bean.Solicitacao;
import forms.ChamaSenhaForm;

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
public class TestaChamaSenhaForm extends TestCase {

	ChamaSenhaForm chama1 = new ChamaSenhaForm();
	ChamaSenhaForm chama2 = new ChamaSenhaForm();
	
	/**
	 * Construtor
	 */
	public TestaChamaSenhaForm(String arg0) {
		super(arg0);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * Test method for {@link forms.ChamaSenhaForm#getGuiche()}.
	 */
	public void testGetGuiche() {
		chama1.setGuiche("01");
		assertEquals("01", chama1.getGuiche());
		chama2.setGuiche("02");
		assertEquals("02", chama2.getGuiche());
	}

	/**
	 * Test method for {@link forms.ChamaSenhaForm#setGuiche(java.lang.String)}.
	 */
	public void testSetGuiche() {
		chama1.setGuiche("01");
		assertEquals("01", chama1.getGuiche());
		chama1.setGuiche("02");
		assertEquals("02", chama1.getGuiche());
	}

	/**
	 * Test method for {@link forms.ChamaSenhaForm#getLogin()}.
	 */
	public void testGetLogin() {
		Login login = new Login();
		login.setGuiche("01");
		login.setLogin("admin");
		login.setPassword("admin");
		chama1.setLogin(login);
		assertEquals("01", chama1.getLogin().getGuiche());
		assertEquals("admin", chama1.getLogin().getLogin());
		assertEquals("admin", chama1.getLogin().getPassword());		
	}

	/**
	 * Test method for {@link forms.ChamaSenhaForm#setLogin(database.bean.Login)}.
	 */
	public void testSetLogin() {
		Login login = new Login();
		login.setGuiche("01");
		login.setLogin("admin");
		login.setPassword("admin");
		chama1.setLogin(login);
		assertEquals("01", chama1.getLogin().getGuiche());
		assertEquals("admin", chama1.getLogin().getLogin());
		assertEquals("admin", chama1.getLogin().getPassword());		
		Login login2 = new Login();
		login2.setGuiche("02");
		login2.setLogin("admin2");
		login2.setPassword("admin2");
		chama1.setLogin(login2);
		assertEquals("02", chama1.getLogin().getGuiche());
		assertEquals("admin2", chama1.getLogin().getLogin());
		assertEquals("admin2", chama1.getLogin().getPassword());		
		
	}

	/**
	 * Test method for {@link forms.ChamaSenhaForm#getChamaSenha()}.
	 */
	public void testGetChamaSenha() {
		Solicitacao solicitacao = new Solicitacao();
		solicitacao.setClasse("atendimento");
		solicitacao.setSenhaASerChamada("ATD01");
		chama1.setChamaSenha(solicitacao);
		assertEquals("atendimento", chama1.getChamaSenha().getClasse());
		assertEquals("ATD01", chama1.getChamaSenha().getSenhaASerChamada());
	}

	/**
	 * Test method for {@link forms.ChamaSenhaForm#setChamaSenha(database.bean.Solicitacao)}.
	 */
	public void testSetChamaSenha() {
		Solicitacao solicitacao = new Solicitacao();
		solicitacao.setClasse("atendimento");
		solicitacao.setSenhaASerChamada("ATD01");
		chama1.setChamaSenha(solicitacao);
		assertEquals("atendimento", chama1.getChamaSenha().getClasse());
		assertEquals("ATD01", chama1.getChamaSenha().getSenhaASerChamada());
		Solicitacao solicitacao2 = new Solicitacao();
		solicitacao2.setClasse("2ª via");
		solicitacao2.setSenhaASerChamada("sgv01");
		chama1.setChamaSenha(solicitacao2);
		assertEquals("2ª via", chama1.getChamaSenha().getClasse());
		assertEquals("SGV01", chama1.getChamaSenha().getSenhaASerChamada());
	}

}
