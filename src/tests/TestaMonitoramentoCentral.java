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


import coletaDados.MonitoramentoCentral;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

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
 * Classe que fornece testes para a classe
 * MonitoramentoCentral
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class TestaMonitoramentoCentral extends TestCase {

	private MonitoramentoCentral monitoramento;
	
	public TestaMonitoramentoCentral(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		monitoramento = new MonitoramentoCentral();
	}

	/**
	 * Metodo que retorna uma suite de teste para a classe TestaMonitoramentoCentral
	 * @return uma suite de teste.
	 */
	public static Test suite() {
		return new TestSuite(TestaMonitoramentoCentral.class);
	}
	
	public void testClasseAtendimento(){
		monitoramento.setClasseAtendimento("Segunda Via");
		assertEquals("Segunda Via", monitoramento.getClasseAtendimento());
	}
	
	public void testAtendimentos(){
		monitoramento.setAtendimentos(50);
		assertEquals(50, monitoramento.getAtendimentos());
	}
	
	public void testSenhasASeremAtendidas(){
		monitoramento.setSenhasASeremAtendidas(30);
		assertEquals(30, monitoramento.getSenhasASeremAtendidas());
	}
	
	public void testTempoMedioAtendimento(){
		monitoramento.setTempoMedioAtendimento(2.250045);
		assertEquals("2,25", monitoramento.getTempoMedioAtendimento());
		
	}
	
	public void testGuichesAtivos(){
		monitoramento.setGuichesAtivos(10);
		assertEquals(10, monitoramento.getGuichesAtivos());
	}
}
