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

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import database.bean.Atendimento;

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
 * CCT -  CENTRO DE CI�NCIA E TECNOLOGIA
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
