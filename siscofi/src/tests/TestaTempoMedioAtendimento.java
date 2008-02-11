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

import database.bean.Formulario;
import estatisticas.atendimento.TempoMedioAtendimento;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
 * CCT -  CENTRO DE CIÊNCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO 1
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES
 */

/**
 * Classe que testa a classe TempoMedioAtendimento
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes
 * 
 * @version 1.0
 */
public class TestaTempoMedioAtendimento extends TestCase {

	TempoMedioAtendimento tm1;
	TempoMedioAtendimento tm2;
	
	public TestaTempoMedioAtendimento(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		tm1 = new TempoMedioAtendimento();
		tm2 = new TempoMedioAtendimento();
	}

	/**
	 * Metodo que retorna uma suite de teste para a classe TempoMedioAtendimento
	 * @return uma suite de teste.
	 */
	public static Test suite() {
		return new TestSuite(TestaTempoMedioAtendimento.class);
	}
	
	/**
	 * Testa todos os metodos da classe TempoMedioAtendimento
	 *
	 */
	public void testaAll(){
		assertTrue(tm1.addTempoAtendimento(0, 0.5, 2.0, 15.0, "01", 60000));

		assertFalse(tm1.addTempoAtendimento(1, 0.5, 2.0, 15.0, "01", 60000));
		assertFalse(tm1.addTempoAtendimento(1, 0.5, 2.0, 15.0, "01", 1020000));

		assertEquals(tm1.getTempoAtual(300000, "01"), 4.0);
		
		assertFalse(tm1.addTempoAtendimento(1, 0.5, 2.0, 15.0, "01", 360000));
		
		assertEquals(tm1.getTempoMedio("01"), 5.0);
		
		assertEquals(tm1.getTempoAtual(500000, "01"), 2.3333333333333335);
		assertFalse(tm1.addTempoAtendimento(1, 0.5, 2.0, 15.0, "01", 500000));
		assertEquals(tm1.getTempoAtual(990000, "01"), 10.5);
		assertFalse(tm1.addTempoAtendimento(1, 0.5, 2.0, 15.0, "01", 990000));

		assertEquals(tm1.getTempoAtual(720000, "01"), 6.0);
		assertTrue(tm1.addTempoAtendimento(1, 0.5, 2.0, 15.0, "01", 720000));
		assertEquals(tm1.getTempoAtual(1200000, "01"), 8.0);
		assertTrue(tm1.addTempoAtendimento(1, 0.5, 2.0, 15.0, "01", 1200000));
		assertEquals(tm1.getTempoAtual(1740000, "01"), 9.0);
		assertTrue(tm1.addTempoAtendimento(1, 0.5, 2.0, 15.0, "01", 1740000));

	}

}
