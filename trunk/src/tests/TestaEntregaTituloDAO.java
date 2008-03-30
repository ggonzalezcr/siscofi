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
import coletaDados.EntregaTitulo;
import database.EntregaTituloDAO;
import estatisticas.atendimento.DadosAtendimento;
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
 * Classe que testa a classe EntregaTituloDAO
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */
public class TestaEntregaTituloDAO extends TestCase {

	private EntregaTituloDAO entrega;
	private EntregaTitulo entregaT1, entregaT2;
	private Date data1, data2;
	private List<DadosAtendimento> listagem;

	@Override
	protected void setUp() throws Exception {
		entrega = new EntregaTituloDAO();
		data1 = DataUtil.gerarData("01", "02", "2001");
		data2 = DataUtil.gerarData("01", "02", "2002");
		entregaT1 = new EntregaTitulo();
		entregaT2 = new EntregaTitulo();
		entregaT1.setDataAtual(data1);
		entregaT1.setQuantidadePessoas(10);
		entregaT1.setTempoMedioEntrega(12.5);
		entregaT2.setDataAtual(data2);
		entregaT2.setQuantidadePessoas(25);
		entregaT2.setTempoMedioEntrega(2.333);
		entrega.writeEntregaTitulo(entregaT1);
		entrega.writeEntregaTitulo(entregaT2);
	}

	public void testReadDadosAtendimento() {
		try {
			assertEquals(entregaT1.toString(), entrega.readEntregaTitulo(data1).toString());
			assertEquals(entregaT2.toString(), entrega.readEntregaTitulo(data2).toString());
			entregaT2.setDataAtual(data1);
			entrega.writeEntregaTitulo(entregaT2);
			assertEquals(entregaT2.toString(), entrega.readEntregaTitulo(data1).toString());
		} catch (NotFoundInDBException e) {
			fail("erro inesperado");
		}

	}

	public void testWriteDadosAtendimento() {
		try {
			entregaT2.setDataAtual(data1);
			entrega.writeEntregaTitulo(entregaT2);
			assertEquals(entregaT2.toString(), entrega.readEntregaTitulo(data1).toString());
			Date data3 = DataUtil.getDataHora();
			entregaT2.setDataAtual(data3);
			entrega.writeEntregaTitulo(entregaT2);
			assertEquals(entregaT2.toString(), entrega.readEntregaTitulo(data3).toString());
		} catch (NotFoundInDBException e) {
			fail("erro inesperado");
		}
	}

	public void testRemoveDadosAtendimento() {
		try {
			assertEquals(entregaT1.toString(), entrega.readEntregaTitulo(data1).toString());
			entrega.removeEntregaTitulo(data1);
			assertEquals(entregaT1.toString(), entrega.readEntregaTitulo(data1).toString());
			fail("Esta linha não deve ser executada!");
		} catch (NotFoundInDBException e) {
		}
		
	}

	public void testListaDeDadosAtendimento() {
		try {
			List<EntregaTitulo> listagem = entrega.listaDeEntregaTitulo(data1, data2);
			assertTrue(listagem.size() == 2);
		} catch (NotFoundInDBException e) {
			fail("erro inesperado");
		}
	}
	
}
