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

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import database.bean.Atendimento;

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
 * CCT -  CENTRO DE CIÊNCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO 1
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES
 */

/**
 * Classe que testa a classe Atendimento
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes
 * 
 * @version 1.0
 */

public class TestaAtendimento extends TestCase {

	protected Atendimento atd1, atd2;
	
	
	
	/**
	 * Cria um novo TestaAtendimento.
	 * @param name
	 */
	public TestaAtendimento(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		atd1 =  new Atendimento();
		atd2 =  new Atendimento();
		
	}
	
	/**
	 * Metodo que retorna uma suite de teste para a classe testaAtendimento
	 * @return uma suite de teste.
	 */
	public static Test suite() {
		return new TestSuite(TestaAtendimento.class);
	}

	/**
	 * Test method for {@link database.bean.Atendimento#getTotalAtendidos()}.
	 */
	public void testGetTotalAtendidos() {
		atd1.setTotalAtendidos(3);
		assertEquals("1", 3, atd1.getTotalAtendidos());
		assertEquals("2", 0 , atd2.getTotalAtendidos());
	}

	/**
	 * Test method for {@link database.bean.Atendimento#getAtendimentosRestantes()}.
	 */
	public void testGetAtendimentosRestantes() {
		atd1.setAtendimentosRestantes(10);
		assertEquals("1", 10, atd1.getAtendimentosRestantes());
		assertEquals("2",0 , atd2.getAtendimentosRestantes());
	}

	/**
	 * Test method for {@link database.bean.Atendimento#compareTo(database.bean.Atendimento)}.
	 */
	public void testCompareTo() {
		assertFalse(atd1.equals(atd2));
		atd1 = new Atendimento();
		assertTrue(atd1.equals(atd1));
	}

}
