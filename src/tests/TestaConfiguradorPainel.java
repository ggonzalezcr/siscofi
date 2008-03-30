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

 * Você deve ter recebido uma cópia da Licença Pública Geral GNU
 * junto com este programa, se não, escreva para a Fundação do Software
 * Livre(FSF) Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA
 * 
 * Copyright 2007, 2008 Carlos Trajano de Oliveira, Hamon Barros Henriques, Rodrigo Lopes da Silva
 */


import database.bean.ConfiguradorPainel;
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
 * 			RODRIGO LOPES DA SILVA
 */

/**
 * Classe que realiza os testes da classe ConfiguradorPainel. 
 * 
 * @author Carlos Trajano de Oliveira
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class TestaConfiguradorPainel extends TestCase {

	private ConfiguradorPainel configurador;
	
	public TestaConfiguradorPainel(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		configurador = new ConfiguradorPainel();
	}

	/**
	 * Metodo que retorna uma suite de teste para a classe
	 * TestaConfiguradorPainel
	 * 
	 * @return uma suite de teste.
	 */
	public static Test suite() {
		return new TestSuite(TestaConfiguradorPainel.class);
	}
	
	public void testGetsAndSeters(){
		//Posição do relógio
		assertEquals("320", configurador.getClockPosition());
		configurador.setClockPosition("150");
		assertEquals("150", configurador.getClockPosition());
		
		//Cor de Fundo do painel
		assertEquals("FFFFFF", configurador.getBgColor());
		configurador.setBgColor("000000");
		assertEquals("000000", configurador.getBgColor());
		
		//Mensagem
		assertEquals("mensagem aqui", configurador.getMensagem());
		configurador.setMensagem("outra mensagem");
		assertEquals("outra mensagem", configurador.getMensagem());
		
		//Intervalo da mensagem
		assertEquals(30, configurador.getInterval());
		configurador.setInterval(25);
		assertEquals(25, configurador.getInterval());
		
		//Cor da Mensagem
		assertEquals("FFF00F", configurador.getCorMensagem());
		configurador.setCorMensagem("FFFFFF");
		assertEquals("FFFFFF", configurador.getCorMensagem());
		
		//speed
		assertEquals(30, configurador.getSpeed());
		configurador.setSpeed(50);
		assertEquals(50, configurador.getSpeed());
		
		//repeat 
		assertEquals(3, configurador.getRepeat());
		configurador.setRepeat(5);
		assertEquals(5, configurador.getRepeat());
		
		//duraçãoExibição
		assertEquals(2, configurador.getDuracaoExibicao());
		configurador.setDuracaoExibicao(5);
		assertEquals(5, configurador.getDuracaoExibicao());
		
		//destacarUltimaSenha
		assertEquals(1, configurador.getDestacarUltimaSenha());
		configurador.setDestacarUltimaSenha(0);
		assertEquals(0, configurador.getDestacarUltimaSenha());
		
	}
}
