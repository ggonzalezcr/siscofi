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

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import database.bean.Atendimento;
import database.bean.Atendimentos;


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
 * Classe que testa a classe Atendimentos
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes
 * 
 * @version 1.0
 */

public class TestaAtendimentos extends TestCase {

	private Atendimentos atds;
	
	/**
	 * @param arg0
	 */
	public TestaAtendimentos(String arg0) {
		super(arg0);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		atds = new Atendimentos();
	}


	/**
	 * Metodo que retorna uma suite de teste para a classe testaAtendimentos
	 * @return uma suite de teste.
	 */
	public static Test suite() {
		return new TestSuite(TestaAtendimentos.class);
	}

	/**
	 * Test method for {@link database.bean.Atendimentos#addAtendimento(database.bean.Atendimento)}.
	 */
	public void testAddAtendimento() {
		atds.addAtendimento(new Atendimento());
		assertEquals(1, atds.getListagem().size());
	}

	/**
	 * Test method for {@link database.bean.Atendimentos#removeAtendimento(database.bean.Atendimento)}.
	 */
	public void testRemoveAtendimento() {
		Atendimento atd = new Atendimento();
		atds.addAtendimento(atd);
		atds.removeAtendimento(atd);
		assertEquals(0, atds.getListagem().size());
	}

	/**
	 * Test method for {@link database.bean.Atendimentos#getAtendimento(int)}.
	 */
	public void testGetAtendimento() {
		assertTrue(atds.getListagem().size() == 0);
		Atendimento atd1 = new Atendimento();
		atd1.setAtendimentosRestantes(10);
		Atendimento atd2 = new Atendimento();
		atd2.setTotalAtendidos(90);
		atds.addAtendimento(atd1);
		atds.addAtendimento(atd2);
		assertTrue(atds.getAtendimento(0).getAtendimentosRestantes() == 10);
		assertTrue(atds.getAtendimento(1).getTotalAtendidos() == 90);
	}

	/**
	 * Test method for {@link database.bean.Atendimentos#getListagem()}.
	 */
	public void testGetListagem() {
		atds = new Atendimentos();
		List lista = new ArrayList<Atendimento>();
		Atendimento atd1 = new Atendimento();
		atd1.setClasseAtendimento("classe1");
		Atendimento atd2 = new Atendimento();
		atd2.setClasseAtendimento("classe2");
		Atendimento atd3 = new Atendimento();
		atd3.setClasseAtendimento("classe3");
		atds.addAtendimento(atd1);
		atds.addAtendimento(atd2);
		atds.addAtendimento(atd3);
		System.out.println(atds);
		lista = atds.getListagem();
		assertTrue(lista.size() == 3);
	}

	/**
	 * Test method for {@link database.bean.Atendimentos#setListagem(java.util.List)}.
	 */
	public void testSetListagem() {
		List lista = new ArrayList<Atendimento>();
		Atendimento atd1 = new Atendimento();
		atd1.setClasseAtendimento("classe1");
		Atendimento atd2 = new Atendimento();
		atd2.setClasseAtendimento("classe2");
		Atendimento atd3 = new Atendimento();
		atd3.setClasseAtendimento("classe3");
		lista.add(atd1);
		lista.add(atd2);
		lista.add(atd3);
		atds.setListagem(lista);
		assertTrue(atds.getListagem().size() == 3);
	}

}
