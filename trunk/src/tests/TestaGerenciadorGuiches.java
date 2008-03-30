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

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import controller.GerenciadorGuiches;

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
	 * Teste para o m�todo {@link controller.GerenciadorGuiches#addGuiche(java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	public void testAddGuiche() {
		String ip = "192.168.54.2";
		assertEquals("", gerenciador.getGuiche(ip));
		gerenciador.addGuiche(ip, "01", "ESP", "Jos�");
		assertEquals("01", gerenciador.getGuiche(ip));
	}

	/**
	 * Teste para o m�todo {@link controller.GerenciadorGuiches#getAtendente(java.lang.String)}.
	 */
	public void testGetAtendente() {
		String atendente = "Jos�";
		assertEquals("", gerenciador.getAtendente("01"));
		gerenciador.addGuiche("192.168.10.10", "01", "ESP", atendente);
		assertEquals(atendente, gerenciador.getAtendente("01"));
	}

	/**
	 * Teste para o m�todo {@link controller.GerenciadorGuiches#contemGuiche(java.lang.String)}.
	 */
	public void testContemGuiche() {
		assertFalse(gerenciador.contemGuiche("01"));
		gerenciador.addGuiche("192.168.10.10", "01", "ESP", "Jos�");
		assertTrue(gerenciador.contemGuiche("01"));
	}

	/**
	 * Teste para o m�todo {@link controller.GerenciadorGuiches#contemIP(java.lang.String)}.
	 */
	public void testContemIP() {
		String ip = "192.168.54.2";
		assertFalse(gerenciador.contemIP(ip));
		gerenciador.addGuiche(ip, "01", "ESP", "Jos�");
		assertTrue(gerenciador.contemIP(ip));
	}

	/**
	 * Teste para o m�todo {@link controller.GerenciadorGuiches#getGuiche(java.lang.String)}.
	 */
	public void testGetGuiche() {
		String ip = "192.168.54.2";
		assertEquals("", gerenciador.getGuiche(ip));
		gerenciador.addGuiche(ip, "01", "ESP", "Jos�");
		assertEquals("01", gerenciador.getGuiche(ip));
	}

	/**
	 * Teste para o m�todo {@link controller.GerenciadorGuiches#getIp(java.lang.String)}.
	 */
	public void testGetIp() {
		String ip = "192.168.54.2";
		assertEquals("", gerenciador.getIp("01"));
		gerenciador.addGuiche(ip, "01", "ESP", "Jos�");
		assertEquals(ip, gerenciador.getIp("01"));
	}

	/**
	 * Teste para o m�todo {@link controller.GerenciadorGuiches#removeGuiche(java.lang.String)}.
	 */
	public void testRemoveGuiche() {
		String ip = "192.168.54.2";
		assertEquals("", gerenciador.getGuiche(ip));
		gerenciador.addGuiche(ip, "01", "ESP", "Jos�");
		assertEquals("01", gerenciador.getGuiche(ip));
		gerenciador.removeGuiche(ip);
		assertEquals("", gerenciador.getGuiche(ip));
	}

	/**
	 * Teste para o m�todo {@link controller.GerenciadorGuiches#alterarClasse(java.lang.String, java.lang.String)}.
	 */
	public void testAlterarClasse() {
		String ip = "192.168.54.2";
		String classe1 = "ESP"; 
		String classe2 = "GERAL";
		gerenciador.alterarClasse(ip, classe1);
		assertEquals("", gerenciador.getClasse(ip));
		gerenciador.addGuiche(ip, "01", classe1, "Jos�");
		assertEquals(classe1, gerenciador.getClasse(ip));
		gerenciador.alterarClasse(ip, classe2);
		assertEquals(classe2, gerenciador.getClasse(ip));
	}
	
	/**
	 * Teste para o m�todo {@link controller.GerenciadorGuiches#getClasse(java.lang.String)}.
	 */
	public void testGetClasse() {
		String ip = "192.168.54.2";
		String classe1 = "ESP";
		String classe2 = "GERAL";
		assertEquals("", gerenciador.getClasse(ip));
		gerenciador.addGuiche(ip, "01", classe1, "Jos�");
		assertEquals(classe1, gerenciador.getClasse(ip));
		gerenciador.alterarClasse(ip, classe2);
		assertEquals(classe2, gerenciador.getClasse(ip));
	}

	/**
	 * Teste para o m�todo {@link controller.GerenciadorGuiches#getGuiches(java.lang.String)}.
	 */
	public void testGetGuiches() {
		String classe = "ESP";
		assertEquals(0, gerenciador.getGuiches(classe));
		gerenciador.addGuiche("150.160.0.1", "01", classe, "Jos�");
		assertEquals(1, gerenciador.getGuiches(classe));
		gerenciador.addGuiche("150.160.0.2", "02", classe, "Jos�");
		assertEquals(2, gerenciador.getGuiches(classe));
	}

	/**
	 * Teste para o m�todo {@link controller.GerenciadorGuiches#getGuichesClasse(java.lang.String)}.
	 */
	public void testGetGuichesClasse() {
		List<String> lista= new ArrayList<String>();
		String classe = "ESP";
		assertEquals(lista, gerenciador.getGuichesClasse(classe));
		gerenciador.addGuiche("150.160.0.1", "01", classe, "Jos�");
		gerenciador.addGuiche("150.160.0.2", "02", classe, "Jos�");
		lista.add("01");
		lista.add("02");
		assertEquals(lista, gerenciador.getGuichesClasse(classe));
	}

}
