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

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import database.bean.TempoAtendimento;

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
