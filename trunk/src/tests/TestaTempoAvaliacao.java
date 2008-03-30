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

import java.util.Date;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import util.DataUtil;
import coletaDados.TempoAvaliacao;
import database.bean.Atendimento;

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
		assertEquals("dados de " + DataUtil.formatarDataHora(ta1.getDataAtual()) + ", quantidade de pessoas que avaliaram o atendimento 0, tempo medio de avaliação 0.0","dados de " + DataUtil.formatarDataHora(ta1.getDataAtual()) + ", quantidade de pessoas que avaliaram o atendimento " + ta1.getQuantidadePessoas() + ", tempo medio de avaliação " + ta1.getTempoMedioAvaliacao());
		assertEquals("dados de " + DataUtil.formatarDataHora(ta2.getDataAtual()) + ", quantidade de pessoas que avaliaram o atendimento 0, tempo medio de avaliação 0.0","dados de " + DataUtil.formatarDataHora(ta2.getDataAtual()) + ", quantidade de pessoas que avaliaram o atendimento " + ta2.getQuantidadePessoas() + ", tempo medio de avaliação " + ta2.getTempoMedioAvaliacao());
	}

}
