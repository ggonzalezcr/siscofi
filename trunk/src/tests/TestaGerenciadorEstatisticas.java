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

import junit.framework.TestCase;
import database.AvaliacaoDAO;
import database.EstatisticasDAO;
import database.bean.Avaliacao;
import estatisticas.avaliacao.GerenciadorEstatisticas;
import exceptions.NotFoundInDBException;

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
			fail("Não deveria lançar exceção!");
		}
	}

}
