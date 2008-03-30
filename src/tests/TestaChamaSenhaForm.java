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

import junit.framework.TestCase;
import database.bean.Login;
import database.bean.Solicitacao;
import forms.ChamaSenhaForm;

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
		solicitacao2.setClasse("2� via");
		solicitacao2.setSenhaASerChamada("sgv01");
		chama1.setChamaSenha(solicitacao2);
		assertEquals("2� via", chama1.getChamaSenha().getClasse());
		assertEquals("SGV01", chama1.getChamaSenha().getSenhaASerChamada());
	}

}
