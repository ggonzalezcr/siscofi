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
import coletaDados.EntregaTitulo;
import database.EntregaTituloDAO;
import estatisticas.atendimento.DadosAtendimento;
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
			fail("Esta linha n�o deve ser executada!");
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
