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
import database.bean.Guiche;

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
 * Testes da classe Guiche.
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */



public class TestaGuiche extends TestCase {
	
	private Guiche guiche1, guiche2;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		guiche1 = new Guiche();
		guiche1.setAtendente("John");
		guiche1.setClasse("Aposentados");
		guiche1.setIp("192.168.10.45");
		guiche1.setIDGuiche("01");
		guiche2 = new Guiche();
	}

	/**
	 * Test method for {@link database.bean.Guiche#getAtendente()}.
	 */
	public void testGetAtendente() {
		assertEquals("John", guiche1.getAtendente());
		guiche1.setAtendente("John z�");
		assertEquals("John z�", guiche1.getAtendente());
		assertEquals("", guiche2.getAtendente());
	}

	/**
	 * Test method for {@link database.bean.Guiche#setAtendente(java.lang.String)}.
	 */
	public void testSetAtendente() {
		assertEquals("John", guiche1.getAtendente());
		guiche1.setAtendente("Johnn");
		assertEquals("Johnn", guiche1.getAtendente());
		assertEquals("", guiche2.getAtendente());
	}

	/**
	 * Test method for {@link database.bean.Guiche#getIp()}.
	 */
	public void testGetIp() {
		assertEquals("192.168.10.45", guiche1.getIp());
		assertEquals("", guiche2.getIp());
		guiche2.setIp("192.168.10.45");
		assertEquals("192.168.10.45", guiche2.getIp());
	}

	/**
	 * Test method for {@link database.bean.Guiche#setIp(java.lang.String)}.
	 */
	public void testSetIp() {
		assertEquals("192.168.10.45", guiche1.getIp());
		guiche1.setIp("192.168.102.45");
		assertEquals("192.168.102.45", guiche1.getIp());
		assertEquals("", guiche2.getIp());
		guiche2.setIp("192.168.10.45");
		assertEquals("192.168.10.45", guiche2.getIp());
	}

	/**
	 * Test method for {@link database.bean.Guiche#getClasse()}.
	 */
	public void testGetClasse() {
		assertEquals("Aposentados", guiche1.getClasse());
		assertEquals("", guiche2.getClasse());
		guiche2.setClasse("geral");
		assertEquals("geral", guiche2.getClasse());
	}

	/**
	 * Test method for {@link database.bean.Guiche#setClasse(java.lang.String)}.
	 */
	public void testSetClasse() {
		assertEquals("", guiche2.getClasse());
		guiche2.setClasse("geral");
		assertEquals("geral", guiche2.getClasse());
		guiche2.setClasse("");
		assertEquals("", guiche2.getClasse());
	}
	
	/**
	 * Test method for {@link database.bean.Guiche#getIDGuiche()}.
	 */
	public void testGetIDGuiche() {
		assertEquals("01", guiche1.getIDGuiche());
		assertEquals("", guiche2.getIDGuiche());
		guiche2.setIDGuiche("ABC01");
		assertEquals("ABC01", guiche2.getIDGuiche());
	}

	/**
	 * Test method for {@link database.bean.Guiche#setIDGuiche(java.lang.String)}.
	 */
	public void testSetIDGuiche() {
		assertEquals("", guiche2.getIDGuiche());
		guiche2.setIDGuiche("DEF1234");
		assertEquals("DEF1234", guiche2.getIDGuiche());
		guiche2.setIDGuiche("");
		assertEquals("", guiche2.getIDGuiche());
	}

}
