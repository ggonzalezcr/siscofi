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

import junit.framework.TestCase;
import util.DataUtil;
import coletaDados.TempoAvaliacao;
import forms.TempoAvaliacaoForm;

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
 * Classe que testa a classe TempoAvaliacaoForm
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class TestaTempoAvaliacaoForm extends TestCase {

	protected TempoAvaliacaoForm taf;
	protected TempoAvaliacao ta;
	
	/**
	 * Construtor
	 */
	public TestaTempoAvaliacaoForm(String arg0) {
		super(arg0);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		taf = new TempoAvaliacaoForm();
		ta = new TempoAvaliacao();
		ta.setDataAtual(DataUtil.gerarData("01","02","2008"));
		ta.setQuantidadePessoas(10);
		ta.setTempoMedioAvaliacao(5.3);
		taf.setTempoAvaliacao(ta);
	}

	/**
	 * Testa o metodo getQuantidadePessoas().
	 */
	public void testGetQuantidadePessoas() {
		assertEquals(10, taf.getQuantidadePessoas());
	}

	/**
	 * Testa o metodo setQuantidadePessoas().
	 */
	public void testSetQuantidadePessoas() {
		taf.setQuantidadePessoas(12);
		assertEquals(12, taf.getQuantidadePessoas());
	}

	/**
	 * Testa o metodo getTempoMedioAvaliacao().
	 */
	public void testGetTempoMedioAvaliacao() {
		assertEquals(5.3, taf.getTempoMedioAvaliacao());
	}

	/**
	 * Testa o metodo setTempoMedioAvaliacao().
	 */
	public void testSetTempoMedioAvaliacao() {
		taf.setTempoMedioAvaliacao(6.4);
		assertEquals(6.4, taf.getTempoMedioAvaliacao());
	}

	/**
	 * Testa o metodo getTempoAvaliacao().
	 */
	public void testGetTempoAvaliacao() {
		assertEquals(ta, taf.getTempoAvaliacao());
	}

	/**
	 * Testa o metodo setTempoAvaliacao().
	 */
	public void testSetTempoAvaliacao() {
		TempoAvaliacao ta2 = new TempoAvaliacao();
		ta2.setDataAtual(new Date());
		taf.setTempoAvaliacao(ta2);
		assertEquals(ta2, taf.getTempoAvaliacao());
	}

}
