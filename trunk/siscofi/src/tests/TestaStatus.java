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
import database.bean.Status;


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
 * Classe que testa a classe Status
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes
 * 
 * @version 1.0
 */
public class TestaStatus extends TestCase {
	
	private Status status;

	/**
	 * @param arg0
	 */
	public TestaStatus(String arg0) {
		super(arg0);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		status = new Status();
	}

	/**
	 * Testa o metodo {@link database.bean.Status#isStarted()}.
	 */
	public final void testIsStarted() {
		assertFalse(status.isStarted());
		status.setStarted(true);
		assertTrue(status.isStarted());
		status.setStarted(false);
		assertFalse(status.isStarted());
	}

	/**
	 * Testa o metodo {@link database.bean.Status#setStarted(boolean)}.
	 */
	public final void testSetStarted() {
		status.setStarted(true);
		assertTrue(status.isStarted());
		status.setStarted(false);
		assertFalse(status.isStarted());
	}

	/**
	 * Testa o metodo {@link database.bean.Status#getId()}.
	 */
	public final void testGetId() {
		assertEquals(Status.ID_STATUS,status.getId());
		status.setId("a12");
		assertEquals("a12",status.getId());
	}

	/**
	 * Testa o metodo {@link database.bean.Status#setId(java.lang.String)}.
	 */
	public final void testSetId() {
		status.setId("b11");
		assertEquals("b11",status.getId());
		status.setId("a12");
		assertEquals("a12",status.getId());
	}

}
