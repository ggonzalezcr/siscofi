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
import coletaDados.EntregaTitulo;
/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
 * CCT -  CENTRO DE CI�NCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO 1
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES
 */

/**
 * Classe que testa a classe EntregaTitulo
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes
 * 
 * @version 1.0
 */

public class TestaEntregaTitulo extends TestCase {
	
	private EntregaTitulo entregaTitulo;

	protected void setUp() throws Exception {
		super.setUp();
		entregaTitulo = new EntregaTitulo();
	}


	public final void testGetDataAtual() {
		Date d = DataUtil.getDataAtual();
		entregaTitulo.setDataAtual(d);
		assertEquals(d.toString(), entregaTitulo.getDataAtual().toString());
	}

	public final void testSetDataAtual() {
		Date d = DataUtil.getDataAtual();
		entregaTitulo.setDataAtual(d);
		assertEquals(d.toString(), entregaTitulo.getDataAtual().toString());
	}

	public final void testGetQuantidadePessoas() {
		assertEquals(0, entregaTitulo.getQuantidadePessoas());
		entregaTitulo.setQuantidadePessoas(450);
		assertEquals(450, entregaTitulo.getQuantidadePessoas());
	}

	public final void testSetQuantidadePessoas() {
		entregaTitulo.setQuantidadePessoas(450);
		assertEquals(450, entregaTitulo.getQuantidadePessoas());
		entregaTitulo.setQuantidadePessoas(125);
		assertEquals(125, entregaTitulo.getQuantidadePessoas());
	}

	public final void testGetTempoMedioEntrega() {
		assertEquals(entregaTitulo.getTempoMedioEntrega(), 0.0);
		entregaTitulo.setTempoMedioEntrega(1.3);
		assertEquals(entregaTitulo.getTempoMedioEntrega(), 1.3);
	}

	public final void testSetTempoMedioEntrega() {
		entregaTitulo.setTempoMedioEntrega(1.5);
		assertEquals(entregaTitulo.getTempoMedioEntrega(), 1.5);
		entregaTitulo.setTempoMedioEntrega(0.05);
		assertEquals(entregaTitulo.getTempoMedioEntrega(), 0.05);
	}

}
