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
import java.util.List;

import junit.framework.TestCase;
import util.DataUtil;
import database.EstatisticasDAO;
import estatisticas.avaliacao.Estatisticas;
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
 * Testes da classe EstatisticasDAO.
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class TestaEstatisticasDAO extends TestCase {

	EstatisticasDAO dao = new EstatisticasDAO();
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * Test method for {@link database.EstatisticasDAO#readEstatisticas(java.util.Date)}.
	 */
	public void testReadAvaliacao() {
		Date data = DataUtil.gerarData("21", "12","2199");
		Estatisticas est1;
		try {
			est1 = dao.readEstatisticas(data);
			fail("deveria lançar exceção por não encontrar no BD");
		} catch (NotFoundInDBException e) {
		}
		Estatisticas estatisticas = new Estatisticas();
		estatisticas.setData(data);
		dao.writeEstatistica(estatisticas);
		try {
			est1 = dao.readEstatisticas(data);
			assertEquals(data, est1.getData());
			dao.removeEstatistica(data);
		} catch (NotFoundInDBException e) {
			fail("Não deve ocorrer");
		}
	}

	/**
	 * Test method for {@link database.EstatisticasDAO#writeEstatistica(estatisticas.avaliacao.Estatisticas)}.
	 */
	public void testWriteEstatistica() {
		Date data = DataUtil.gerarData("21", "12","2199");
		Estatisticas est1;
		Estatisticas estatisticas = new Estatisticas();
		estatisticas.setData(data);
		dao.writeEstatistica(estatisticas);
		try {
			est1 = dao.readEstatisticas(data);
			assertEquals(data, est1.getData());
			dao.removeEstatistica(data);
		} catch (NotFoundInDBException e) {
			fail("Não deve ocorrer");
		}
	}

	/**
	 * Test method for {@link database.EstatisticasDAO#removeEstatisticas(java.util.Date)}.
	 */
	public void testRemoveAvaliacao() {
		Date data = DataUtil.gerarData("21", "12","2199");
		Estatisticas est1;
		Estatisticas estatisticas = new Estatisticas();
		estatisticas.setData(data);
		dao.writeEstatistica(estatisticas);
		try {
			est1 = dao.readEstatisticas(data);
			assertEquals(data, est1.getData());
			dao.removeEstatistica(data);
		} catch (NotFoundInDBException e) {
			fail("Não deve ocorrer");
		}
	}

	/**
	 * Test method for {@link database.EstatisticasDAO#listaDeEstatisticas(java.util.Date, java.util.Date)}.
	 */
	public void testListaDeEstatisticas() {
		Date data1 = DataUtil.gerarData("21", "12","2198");
		Estatisticas estatisticas1 = new Estatisticas();
		estatisticas1.setData(data1);
		dao.writeEstatistica(estatisticas1);
		Date data2 = DataUtil.gerarData("21", "12","2199");
		Estatisticas estatisticas2 = new Estatisticas();
		estatisticas2.setData(data2);
		dao.writeEstatistica(estatisticas2);
		try {
			List<Estatisticas> lista = dao.listaDeEstatisticas(data1, data2);
			assertTrue(lista.size() == 2);	
			dao.removeEstatistica(data1);
			dao.removeEstatistica(data2);
		} catch (NotFoundInDBException e) {
			fail("Não deve ocorrer");
		}
	}

	/**
	 * Test method for {@link database.EstatisticasDAO#generateTable()}.
	 */
	public void testGenerateTable() {
		try {
			dao.generateTable();
		} catch (Exception e) {
			fail("Não deve ocorrer");
		}
	}

}
