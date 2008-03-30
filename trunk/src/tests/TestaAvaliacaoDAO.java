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
import database.bean.Avaliacao;
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
 * Classe que testa a classe AvaliacaoDAO
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */
public class TestaAvaliacaoDAO extends TestCase {

	AvaliacaoDAO dao = new AvaliacaoDAO();
	/**
	 * Construtor
	 */
	public TestaAvaliacaoDAO(String arg0) {
		super(arg0);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * Test method for {@link database.AvaliacaoDAO#generateTable()}.
	 */
	public void testGenerateTable() {
		try{
			dao.generateTable();
		}catch (Exception e){
			fail("Conexão falhou!");
		}
	}

	/**
	 * Test method for {@link database.AvaliacaoDAO#writeAvaliacao(database.bean.Avaliacao)}.
	 */
	public void testAll() {
		Avaliacao avaliacao = new Avaliacao();
		Date date = new Date();
		avaliacao.setData(date);
		avaliacao.setResposta1("OK1");
		avaliacao.setResposta2("OK2");
		avaliacao.setResposta3("OK3");
		avaliacao.setResposta4("OK4");
		avaliacao.setResposta5("OK5");
		avaliacao.setResposta6("OK6");
		avaliacao.setResposta7("OK7");
		try{
			dao.writeAvaliacao(avaliacao);
		}catch (Exception e) {
			fail("Não foi possivel gravar a avaliacao!");
		}
		try {
			Avaliacao avaliacao2 = dao.readAvaliacao(date);
			assertEquals("OK1", avaliacao2.getResposta1());
			assertEquals("OK2", avaliacao2.getResposta2());
			assertEquals("OK3", avaliacao2.getResposta3());
			assertEquals("OK4", avaliacao2.getResposta4());
			assertEquals("OK5", avaliacao2.getResposta5());
			assertEquals("OK6", avaliacao2.getResposta6());
			assertEquals("OK7", avaliacao2.getResposta7());
		} catch (NotFoundInDBException e) {
			fail("Não foi possível ler a avaliação");
		}
		try{
			dao.removeAvaliacao(date);
		}catch (Exception e) {
			fail("Não foi possivel remover a avaliacao");
		}
	}

}
