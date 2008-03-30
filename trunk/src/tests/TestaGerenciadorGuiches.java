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

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import controller.GerenciadorGuiches;

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
 * Testes da classe GerenciadorGuiches.
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */


public class TestaGerenciadorGuiches extends TestCase {

	private GerenciadorGuiches gerenciador;
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		gerenciador = new GerenciadorGuiches();
	}

	/**
	 * Teste para o método {@link controller.GerenciadorGuiches#addGuiche(java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	public void testAddGuiche() {
		String ip = "192.168.54.2";
		assertEquals("", gerenciador.getGuiche(ip));
		gerenciador.addGuiche(ip, "01", "ESP", "José");
		assertEquals("01", gerenciador.getGuiche(ip));
	}

	/**
	 * Teste para o método {@link controller.GerenciadorGuiches#getAtendente(java.lang.String)}.
	 */
	public void testGetAtendente() {
		String atendente = "José";
		assertEquals("", gerenciador.getAtendente("01"));
		gerenciador.addGuiche("192.168.10.10", "01", "ESP", atendente);
		assertEquals(atendente, gerenciador.getAtendente("01"));
	}

	/**
	 * Teste para o método {@link controller.GerenciadorGuiches#contemGuiche(java.lang.String)}.
	 */
	public void testContemGuiche() {
		assertFalse(gerenciador.contemGuiche("01"));
		gerenciador.addGuiche("192.168.10.10", "01", "ESP", "José");
		assertTrue(gerenciador.contemGuiche("01"));
	}

	/**
	 * Teste para o método {@link controller.GerenciadorGuiches#contemIP(java.lang.String)}.
	 */
	public void testContemIP() {
		String ip = "192.168.54.2";
		assertFalse(gerenciador.contemIP(ip));
		gerenciador.addGuiche(ip, "01", "ESP", "José");
		assertTrue(gerenciador.contemIP(ip));
	}

	/**
	 * Teste para o método {@link controller.GerenciadorGuiches#getGuiche(java.lang.String)}.
	 */
	public void testGetGuiche() {
		String ip = "192.168.54.2";
		assertEquals("", gerenciador.getGuiche(ip));
		gerenciador.addGuiche(ip, "01", "ESP", "José");
		assertEquals("01", gerenciador.getGuiche(ip));
	}

	/**
	 * Teste para o método {@link controller.GerenciadorGuiches#getIp(java.lang.String)}.
	 */
	public void testGetIp() {
		String ip = "192.168.54.2";
		assertEquals("", gerenciador.getIp("01"));
		gerenciador.addGuiche(ip, "01", "ESP", "José");
		assertEquals(ip, gerenciador.getIp("01"));
	}

	/**
	 * Teste para o método {@link controller.GerenciadorGuiches#removeGuiche(java.lang.String)}.
	 */
	public void testRemoveGuiche() {
		String ip = "192.168.54.2";
		assertEquals("", gerenciador.getGuiche(ip));
		gerenciador.addGuiche(ip, "01", "ESP", "José");
		assertEquals("01", gerenciador.getGuiche(ip));
		gerenciador.removeGuiche(ip);
		assertEquals("", gerenciador.getGuiche(ip));
	}

	/**
	 * Teste para o método {@link controller.GerenciadorGuiches#alterarClasse(java.lang.String, java.lang.String)}.
	 */
	public void testAlterarClasse() {
		String ip = "192.168.54.2";
		String classe1 = "ESP"; 
		String classe2 = "GERAL";
		gerenciador.alterarClasse(ip, classe1);
		assertEquals("", gerenciador.getClasse(ip));
		gerenciador.addGuiche(ip, "01", classe1, "José");
		assertEquals(classe1, gerenciador.getClasse(ip));
		gerenciador.alterarClasse(ip, classe2);
		assertEquals(classe2, gerenciador.getClasse(ip));
	}
	
	/**
	 * Teste para o método {@link controller.GerenciadorGuiches#getClasse(java.lang.String)}.
	 */
	public void testGetClasse() {
		String ip = "192.168.54.2";
		String classe1 = "ESP";
		String classe2 = "GERAL";
		assertEquals("", gerenciador.getClasse(ip));
		gerenciador.addGuiche(ip, "01", classe1, "José");
		assertEquals(classe1, gerenciador.getClasse(ip));
		gerenciador.alterarClasse(ip, classe2);
		assertEquals(classe2, gerenciador.getClasse(ip));
	}

	/**
	 * Teste para o método {@link controller.GerenciadorGuiches#getGuiches(java.lang.String)}.
	 */
	public void testGetGuiches() {
		String classe = "ESP";
		assertEquals(0, gerenciador.getGuiches(classe));
		gerenciador.addGuiche("150.160.0.1", "01", classe, "José");
		assertEquals(1, gerenciador.getGuiches(classe));
		gerenciador.addGuiche("150.160.0.2", "02", classe, "José");
		assertEquals(2, gerenciador.getGuiches(classe));
	}

	/**
	 * Teste para o método {@link controller.GerenciadorGuiches#getGuichesClasse(java.lang.String)}.
	 */
	public void testGetGuichesClasse() {
		List<String> lista= new ArrayList<String>();
		String classe = "ESP";
		assertEquals(lista, gerenciador.getGuichesClasse(classe));
		gerenciador.addGuiche("150.160.0.1", "01", classe, "José");
		gerenciador.addGuiche("150.160.0.2", "02", classe, "José");
		lista.add("01");
		lista.add("02");
		assertEquals(lista, gerenciador.getGuichesClasse(classe));
	}

}
