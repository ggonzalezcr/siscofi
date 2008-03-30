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

import java.util.Date;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import util.DataUtil;
import coletaDados.TempoAvaliacao;
import database.bean.Atendimento;

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
 * Classe que testa a classe TempoAvaliacao
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class TestaTempoAvaliacao extends TestCase {

	protected TempoAvaliacao ta1, ta2;
	
	
	
	/**
	 * Cria um novo TestaTempoAvaliacao.
	 * @param name
	 */
	public TestaTempoAvaliacao(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		ta1 =  new TempoAvaliacao();
		ta2 =  new TempoAvaliacao();
		
	}
	
	/**
	 * Metodo que retorna uma suite de teste para a classe testaAtendimento
	 * @return uma suite de teste.
	 */
	public static Test suite() {
		return new TestSuite(TestaTempoAvaliacao.class);
	}

	/**
	 * Testa o metodo getDataAtual
	 */
	public void testGetDataAtual() {
		assertNotNull(ta1.getDataAtual());
		assertNotNull(ta2.getDataAtual());
		assertTrue(ta1.getDataAtual().compareTo(new Date(System.currentTimeMillis())) < 0);
		assertTrue(ta2.getDataAtual().compareTo(new Date(System.currentTimeMillis())) < 0);
	}

	/**
	 * Testa o metodo setDataAtual
	 */
	public void testSetDataAtual() {
		Date d = new Date(System.currentTimeMillis());
		ta1.setDataAtual(d);
		ta2.setDataAtual(d);
		assertEquals(d, ta1.getDataAtual());
		assertEquals(d, ta2.getDataAtual());
	}

	/**
	 * Testa o metodo getQuantidadePessoas
	 */
	public void testGetQuantidadePessoas() {
		assertEquals(0, ta1.getQuantidadePessoas());
		assertEquals(0, ta2.getQuantidadePessoas());
	}

	/**
	 * Testa o metodo setQuantidadePessoas
	 */
	public void setQuantidadePessoas() {
		ta1.setQuantidadePessoas(2);
		ta2.setQuantidadePessoas(3);
		assertEquals(2, ta1.getQuantidadePessoas());
		assertEquals(3, ta2.getQuantidadePessoas());
	}

	/**
	 * Testa o metodo getTempoMedioAvaliacao
	 */
	public void testGetTempoMedioAvaliacao() {
		assertEquals(0.0, ta1.getTempoMedioAvaliacao());
		assertEquals(0.0, ta2.getTempoMedioAvaliacao());
	}

	/**
	 * Testa o metodo setTempoMedioAvaliacao
	 */
	public void testSetTempoMedioAvaliacao() {
		ta1.setTempoMedioAvaliacao(1.2);
		ta2.setTempoMedioAvaliacao(1.3);
		assertEquals(1.2, ta1.getTempoMedioAvaliacao());
		assertEquals(1.3, ta2.getTempoMedioAvaliacao());		
	}
	
	/**
	 * Testa o metodo toString
	 */
	public void testToString() {
		assertEquals("dados de " + DataUtil.formatarDataHora(ta1.getDataAtual()) + ", quantidade de pessoas que avaliaram o atendimento 0, tempo medio de avalia��o 0.0","dados de " + DataUtil.formatarDataHora(ta1.getDataAtual()) + ", quantidade de pessoas que avaliaram o atendimento " + ta1.getQuantidadePessoas() + ", tempo medio de avalia��o " + ta1.getTempoMedioAvaliacao());
		assertEquals("dados de " + DataUtil.formatarDataHora(ta2.getDataAtual()) + ", quantidade de pessoas que avaliaram o atendimento 0, tempo medio de avalia��o 0.0","dados de " + DataUtil.formatarDataHora(ta2.getDataAtual()) + ", quantidade de pessoas que avaliaram o atendimento " + ta2.getQuantidadePessoas() + ", tempo medio de avalia��o " + ta2.getTempoMedioAvaliacao());
	}

}
