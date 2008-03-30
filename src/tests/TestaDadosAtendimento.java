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

import java.util.HashMap;
import java.util.Map;

import util.DataUtil;

import junit.framework.TestCase;
import estatisticas.atendimento.DadosAtendimento;

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
 * CCT -  CENTRO DE CIÊNCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO 2
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES DA SILVA
 */

/**
 * Teste de Unidade para a classe DadosAtendimento
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */
public class TestaDadosAtendimento extends TestCase {
	
	private DadosAtendimento da1, da2;
	private Map<String, Integer> atendentes1 = new HashMap<String, Integer>();
	private Map<Integer, Integer> guiches1 = new HashMap<Integer, Integer>();
	private Map<String, Integer> classes1 = new HashMap<String, Integer>();
	private Map<String, Integer> atendentes2 = new HashMap<String, Integer>();
	private	Map<Integer, Integer> guiches2 = new HashMap<Integer, Integer>();
	private Map<String, Integer> classes2 = new HashMap<String, Integer>();
 

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		da1 = new DadosAtendimento();
		da2 = new DadosAtendimento();
		
		atendentes1.put("joaol", 8);
		atendentes1.put("marianaa", 5);
		atendentes1.put("johnny", 2);
		guiches1.put(01, 10);
		guiches1.put(02, 5);	
		classes1.put("ABC", 10);
		classes1.put("SEI", 5);
		da1.setAtendenteAtendimentos(atendentes1);
		da1.setGuicheAtendimentos(guiches1);
		da1.setClasseAtendimentos(classes1);
		da1.setData(DataUtil.gerarData("01", "02", "07"));
		da1.setTotalAtendimentos(15);
	
		da2.setAtendenteAtendimentos(atendentes2);
		da2.setClasseAtendimentos(classes2);
		da2.setGuicheAtendimentos(guiches2);
		da2.setData(DataUtil.gerarData("10", "11", "12"));
		da2.setTotalAtendimentos(0);
	}

	/**
	 * Teste para o método {@link estatisticas.atendimento.DadosAtendimento#getData()}.
	 */
	public final void testGetData() {
		assertEquals(DataUtil.gerarData("01", "02", "07"), da1.getData());
		da1.setData(DataUtil.gerarData("01", "10", "07"));
		assertEquals(DataUtil.gerarData("01", "10", "07"), da1.getData());
		assertEquals(DataUtil.gerarData("10", "11", "12"), da2.getData());
	}

	/**
	 * Teste para o método {@link estatisticas.atendimento.DadosAtendimento#setData(java.util.Date)}.
	 */
	public final void testSetData() {
		da1.setData(DataUtil.gerarData("01", "10", "07"));
		assertEquals(DataUtil.gerarData("01", "10", "07"), da1.getData());
		da1.setData(DataUtil.gerarData("01", "02", "07"));
		assertEquals(DataUtil.gerarData("01", "02", "07"), da1.getData());
		assertEquals(DataUtil.gerarData("10", "11", "12"), da2.getData());
	}

	/**
	 * Teste para o método {@link estatisticas.atendimento.DadosAtendimento#getAtendenteAtendimentos()}.
	 */
	public final void testGetAtendenteAtendimentos() {
		assertEquals(da1.getAtendenteAtendimentos(), atendentes1);
		assertEquals(da2.getAtendenteAtendimentos(), atendentes2);
		da1.setAtendenteAtendimentos(atendentes2);
		assertEquals(da2.getAtendenteAtendimentos(), atendentes2);
		
	}

	/**
	 * Teste para o método {@link estatisticas.atendimento.DadosAtendimento#setAtendenteAtendimentos(java.util.Map)}.
	 */
	public final void testSetAtendenteAtendimentos() {
		da1.setAtendenteAtendimentos(atendentes2);
		assertEquals(da2.getAtendenteAtendimentos(), atendentes2);
		da1.setAtendenteAtendimentos(atendentes1);
		assertEquals(da1.getAtendenteAtendimentos(), atendentes1);
		da2.setAtendenteAtendimentos(atendentes1);
		assertEquals(da2.getAtendenteAtendimentos(), atendentes1);
	}

	/**
	 * Teste para o método {@link estatisticas.atendimento.DadosAtendimento#getGuicheAtendimentos()}.
	 */
	public final void testGetGuicheAtendimentos() {
		assertEquals(da1.getGuicheAtendimentos(), guiches1);
		da1.setGuicheAtendimentos(guiches2);
		assertEquals(da1.getGuicheAtendimentos(), guiches2);
		assertEquals(da2.getGuicheAtendimentos(), guiches2);
	}

	/**
	 * Teste para o método {@link estatisticas.atendimento.DadosAtendimento#setGuicheAtendimentos(java.util.Map)}.
	 */
	public final void testSetGuicheAtendimentos() {
		da1.setGuicheAtendimentos(guiches2);
		assertEquals(da1.getGuicheAtendimentos(), guiches2);
		da1.setGuicheAtendimentos(guiches1);
		assertEquals(da1.getGuicheAtendimentos(), guiches1);
		da2.setGuicheAtendimentos(guiches1);
		assertEquals(da2.getGuicheAtendimentos(), guiches1);
	}

	/**
	 * Teste para o método {@link estatisticas.atendimento.DadosAtendimento#getClasseAtendimentos()}.
	 */
	public final void testGetClasseAtendimentos() {
		assertEquals(da1.getClasseAtendimentos(), classes1);
		da1.setClasseAtendimentos(classes2);
		assertEquals(da1.getClasseAtendimentos(), classes2);
		assertEquals(da2.getClasseAtendimentos(), classes2);
	}

	/**
	 * Teste para o método {@link estatisticas.atendimento.DadosAtendimento#setClasseAtendimentos(java.util.Map)}.
	 */
	public final void testSetClasseAtendimentos() {
		da1.setClasseAtendimentos(classes2);
		assertEquals(da1.getClasseAtendimentos(), classes2);
		da1.setClasseAtendimentos(classes1);
		assertEquals(da1.getClasseAtendimentos(), classes1);
		da2.setClasseAtendimentos(classes1);
		assertEquals(da2.getClasseAtendimentos(), classes1);
	}

	/**
	 * Teste para o método {@link estatisticas.atendimento.DadosAtendimento#atualizaContagem(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	public final void testAtualizaContagem() {
		assertTrue(da1.getAtendenteAtendimentos().get("johnny") == 2);
		assertTrue(da1.getClasseAtendimentos().get("ABC") == 10);
		assertTrue(da1.getGuicheAtendimentos().get(2) == 5);
		assertTrue(da1.getTotalAtendimentos() == 15);
		da1.atualizaContagem(03, "johnny", "ABC");
		assertTrue(da1.getTotalAtendimentos() == 16);
		assertTrue(da1.getAtendenteAtendimentos().get("johnny") == 3);
		assertTrue(da1.getClasseAtendimentos().get("ABC") == 11);
		assertTrue(da1.getGuicheAtendimentos().get(02) == 5);
	}

	/**
	 * Teste para o método {@link estatisticas.atendimento.DadosAtendimento#getTotalAtendimentos()}.
	 */
	public final void testGetTotalAtendimentos() { 
		assertTrue(da1.getTotalAtendimentos() == 15);
		assertTrue(da2.getTotalAtendimentos() == 0);
		da2.setTotalAtendimentos(450);
		assertTrue(da2.getTotalAtendimentos() == 450);
	}
	

	/**
	 * Teste para o método {@link estatisticas.atendimento.DadosAtendimento#getTempoMedio}.
	 */
	public final void testGetTempoMedio() {
		assertTrue(da1.getTempoMedio() == 0);
		assertTrue(da2.getTempoMedio() == 0);
		da2.setTempoMedio(450);
		assertTrue(da2.getTempoMedio() == 450);
	}
	
	/**
	 * Teste para o método {@link estatisticas.atendimento.DadosAtendimento#setTempoMedio}.
	 */
	public final void testSetTempoMedio() {
		da2.setTempoMedio(450);
		assertTrue(da2.getTempoMedio() == 450);
		da2.setTempoMedio(1000.012);
		assertTrue(da2.getTempoMedio() == 1000.012);
	}

	/**
	 * Teste para o método {@link estatisticas.atendimento.DadosAtendimento#setTotalAtendimentos(int)}.
	 */
	public final void testSetTotalAtendimentos() {
		da2.setTotalAtendimentos(450);
		assertTrue(da2.getTotalAtendimentos() == 450);
		da2.setTotalAtendimentos(-15);
		assertTrue(da2.getTotalAtendimentos() == -15);
		da1.setTotalAtendimentos(250);
		assertTrue(da1.getTotalAtendimentos() == 250);
	}

}
