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
import java.util.List;

import junit.framework.TestCase;
import util.DataUtil;
import coletaDados.TempoAvaliacao;
import database.TempoAvaliacaoDAO;
import exceptions.NotFoundInDBException;

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
 * Classe que testa a classe TempoAvaliacaoDAO
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */
public class TestaTempoAvaliacaoDAO extends TestCase {

	protected TempoAvaliacaoDAO dao;
	private TempoAvaliacao ta;
	
	/**
	 * Construtor
	 */
	public TestaTempoAvaliacaoDAO(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		dao = new TempoAvaliacaoDAO();
		ta = new TempoAvaliacao();
		Date d = DataUtil.gerarData("01", "02", "2008");
		ta.setDataAtual(d);
		ta.setQuantidadePessoas(10);
		ta.setTempoMedioAvaliacao(5.2);
	}
	
	/**
	 * Testa o metodo generateTable.
	 */
	public void testGenerateTable() {
		dao.generateTable();
	}


	/**
	 * Testa o metodo writeTempoAvaliacao.
	 */
	public void testWriteTempoAvaliacao() {
		dao.writeTempoAvaliacao(ta);
	}

	/**
	 * Testa o metodo readTempoAvaliacao.
	 */
	public void testReadTempoAvaliacao() {
		Date d = DataUtil.gerarData("01", "02", "2008");
		try {
			dao.readTempoAvaliacao(d);
		} catch (NotFoundInDBException e) {
			e.printStackTrace();
			fail("N�o deveria lan�ar exce��o!");
		}
	}

	/**
	 * Testa o metodo listaDeTempoAvaliacao.
	 */
	public void testListaDeTempoAvaliacao() {
		Date d1 = DataUtil.gerarData("01", "01", "2008");
		Date d2 = DataUtil.gerarData("01", "03", "2008");

		try {
			List<TempoAvaliacao> l = dao.listaDeTempoAvaliacao(d1, d2);
			assertTrue(l.size() == 1);
			TempoAvaliacao t = l.get(0);
			assertTrue(t.getQuantidadePessoas() == ta.getQuantidadePessoas());
			assertTrue(t.getTempoMedioAvaliacao() == ta.getTempoMedioAvaliacao());
			assertTrue(DataUtil.gerarData(t.getDataAtual().toString()) == DataUtil.gerarData(t.getDataAtual().toString()));
		} catch (NotFoundInDBException e) {
			e.printStackTrace();
			fail("N�o deveria lan�ar exce��o!");
		}
	}

	/**
	 * Testa o metodo removeTempoAvaliacoa.
	 */
	public void testRemoveTempoAvaliacao() {
		Date d = DataUtil.gerarData("01", "02", "2008");
		try {
			dao.removeTempoAvaliacao(d);
		} catch (NotFoundInDBException e) {
			e.printStackTrace();
			fail("N�o deveria lan�ar exce��o!");
		}
	}

}
