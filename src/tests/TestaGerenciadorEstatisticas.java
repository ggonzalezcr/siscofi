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
import database.AvaliacaoDAO;
import database.EstatisticasDAO;
import database.bean.Avaliacao;
import estatisticas.avaliacao.GerenciadorEstatisticas;
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
 * Classe que testa a classe GerenciadorEstatisticas
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class TestaGerenciadorEstatisticas extends TestCase {
	
	protected GerenciadorEstatisticas ge;
	protected AvaliacaoDAO avDAO;
	protected EstatisticasDAO esDAO;
	protected Avaliacao av;
	
	/**
	 * Construtor
	 */
	public TestaGerenciadorEstatisticas(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		avDAO = new AvaliacaoDAO();
		esDAO = new EstatisticasDAO();
		avDAO.generateTable();
		esDAO.generateTable();
		av = new Avaliacao();
		av.setData(new Date());
		av.setResposta1("1");
		av.setResposta2("2");
		av.setResposta3("3");
		av.setResposta4("4");
		av.setResposta5("5");
		av.setResposta6("resposta6");
		av.setResposta7("resposta7");
		avDAO.writeAvaliacao(av);
	}

	/**
	 * Testa o metodo gerarEstatisticasAvaliacao().
	 */
	public void testGerarEstatisticasAvaliacao() {
		try {
			assertFalse(avDAO.listaDeAvaliacoes(new Date()).isEmpty());
			ge = new GerenciadorEstatisticas();
			ge.gerarEstatisticasAvaliacao();
			assertTrue(avDAO.listaDeAvaliacoes(new Date()).isEmpty());
		} catch (NotFoundInDBException e) {
			e.printStackTrace();
			fail("N�o deveria lan�ar exce��o!");
		}
	}

}
