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

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import database.bean.TempoAtendimento;

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
 * Classe que testa a classe TempoAtendimento
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */
public class TestaTempoAtendimento extends TestCase {

	TempoAtendimento tm1;
	TempoAtendimento tm2;
	
	public TestaTempoAtendimento(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		tm1 = new TempoAtendimento();
		tm2 = new TempoAtendimento();
	}

	/**
	 * Metodo que retorna uma suite de teste para a classe TempoAtendimento
	 * @return uma suite de teste.
	 */
	public static Test suite() {
		return new TestSuite(TestaTempoAtendimento.class);
	}
	
	/**
	 * Testa todos os metodos da classe TempoAtendimento
	 */
	public void testaGetAndSet(){
		tm1.setTempoMedio(2.0);
		tm1.setUltimoTempo(60000);
		
		assertEquals(tm1.getTempoMedio(), 2.0);
		assertEquals(tm1.getUltimoTempo(), 60000);
		
		tm2.setTempoMedio(5.0);
		tm2.setUltimoTempo(60000);
		
		assertEquals(tm2.getTempoMedio(), 5.0);
		assertEquals(tm2.getUltimoTempo(), 60000);
	}

	public void testaContabilizaTempos(){
		tm1.setTempoMedio(0.0);
		tm1.setUltimoTempo(60000);
		assertFalse(tm1.contabilizaTempos(1, 0.5, 2.0, 15.0, 60000));
		assertFalse(tm1.contabilizaTempos(1, 0.5, 2.0, 15.0, 1020000));
		assertFalse(tm1.contabilizaTempos(1, 0.5, 2.0, 15.0, 360000));
		assertFalse(tm1.contabilizaTempos(1, 0.5, 2.0, 15.0, 500000));
		assertFalse(tm1.contabilizaTempos(1, 0.5, 2.0, 15.0, 990000));
		assertTrue(tm1.contabilizaTempos(1, 0.5, 2.0, 15.0, 720000));
		assertTrue(tm1.contabilizaTempos(2, 0.5, 2.0, 15.0, 1200000));
		assertTrue(tm1.contabilizaTempos(2, 0.5, 2.0, 15.0, 1740000));
	}
}
