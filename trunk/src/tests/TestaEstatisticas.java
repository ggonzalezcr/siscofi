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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

import junit.framework.TestCase;
import util.DataUtil;
import database.bean.Avaliacao;
import estatisticas.avaliacao.EstatisticaResposta;
import estatisticas.avaliacao.Estatisticas;

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
 * Testes da classe Estatisticas.
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */
public class TestaEstatisticas extends TestCase {

	Date data;
	Estatisticas est1, est2;
	Avaliacao av1, av2;
	List<Avaliacao> lista;
	protected void setUp() throws Exception {
		super.setUp();
		Date data = DataUtil.getDataAtual();
		est1 = new Estatisticas();
		est2 = new Estatisticas();
		av1 = new Avaliacao();
		av1.setResposta1("1");
		av1.setResposta2("3");
		av1.setResposta3("5");
		av1.setResposta4("2");
		av1.setResposta5("4");
		av1.setResposta6("SIM");
		av1.setResposta7("NAO");
		av1.setData(data);
		av2 = new Avaliacao();
		av2.setResposta1("1");
		av2.setResposta2("2");
		av2.setResposta3("3");
		av2.setResposta4("4");
		av2.setResposta5("1");
		av2.setResposta6("SIM");
		av2.setResposta7("NAO");
		av2.setData(data);
		lista = new ArrayList<Avaliacao>();
		lista.add(av1);
		lista.add(av2);
		est1.geraEstatistica(lista);
	}

	public void testGetContagem() {
		assertEquals(2, est1.getContagem());
		assertEquals(0, est2.getContagem());
		est2.setContagem(2);
		assertEquals(2, est2.getContagem());
		
	}

	public void testSetContagem() {
		assertEquals(0, est2.getContagem());
		est2.setContagem(124);
		assertEquals(124, est2.getContagem());
	}

	public void testGetData() {
		est1.setData(data);
		assertEquals(data, est1.getData());
	}

	public void testSetData() {
		est1.setData(data);
		assertEquals(data, est1.getData());
		est1.setData(null);
		assertEquals(null, est1.getData());
	}

	public void testGetMapaEstatisticaResposta() {
		assertTrue(est1.getMapaEstatisticaResposta().size() == 5);
		assertTrue(est2.getMapaEstatisticaResposta().size() == 0);
	}

	public void testSetMapaEstatisticaResposta() {
		assertTrue(est1.getMapaEstatisticaResposta().size() == 5);
		est1.setMapaEstatisticaResposta(new HashMap<Integer, EstatisticaResposta>());
		assertTrue(est1.getMapaEstatisticaResposta().size() == 0);
	}

	public void testAddEstatistica() {
		est2.addEstatistica(1, new EstatisticaResposta());
		assertTrue(est2.getMapaEstatisticaResposta().size() == 1);
	}

	public void testGeraEstatistica() {
		assertEquals(0, est2.getContagem());
		est2.geraEstatistica(lista);
		assertEquals(2, est2.getContagem());
	}

	public void testContabilizaEstatisticas() {
		assertEquals(0, est2.getContagem());
		List<Estatisticas> lista = new ArrayList<Estatisticas>();
		lista.add(est1);
		est1.contabilizaEstatisticas(lista);
		assertEquals(2, est1.getContagem());
	}

	public void testToString() {
		assertEquals("Data: Fri Mar 07 00:00:00 GMT-03:00 2008 Contagem: 2", est1.toString());
		assertEquals("Data: Fri Mar 07 00:00:00 GMT-03:00 2008 Contagem: 0", est2.toString());
	}

	public void testGetRespostas06() {
		assertEquals(0, est2.getRespostas06().size());
		est2.geraEstatistica(lista);
		assertEquals(1, est2.getRespostas06().size());
	}

	public void testSetRespostas06() {
		assertEquals(1, est1.getRespostas06().size());
		est2.setRespostas06(new TreeSet<String>());
		assertEquals(0, est2.getRespostas06().size());
	}

	public void testGetRespostas07() {
		assertEquals(0, est2.getRespostas07().size());
		est2.geraEstatistica(lista);
		assertEquals(1, est2.getRespostas07().size());
	}

	public void testSetRespostas07() {
		assertEquals(1, est1.getRespostas07().size());
		est2.setRespostas07(new TreeSet<String>());
		assertEquals(0, est2.getRespostas07().size());
	}

}
