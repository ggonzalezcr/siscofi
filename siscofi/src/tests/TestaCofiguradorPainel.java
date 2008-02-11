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

import junit.framework.TestCase;
import database.bean.ConfiguradorPainel;

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
 * Classe que testa a classe ConfiguradorPainel
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes
 * 
 * @version 1.0
 */
public class TestaCofiguradorPainel extends TestCase {

	ConfiguradorPainel conf;
	
	/**
	 * @param name
	 */
	public TestaCofiguradorPainel(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		conf = new ConfiguradorPainel();
	}

	/**
	 * Test method for {@link database.bean.ConfiguradorPainel#getClockPosition()}.
	 */
	public void testGetClockPosition() {
		assertEquals("320", conf.getClockPosition());
		conf.setClockPosition("10");
		assertEquals("10", conf.getClockPosition());
	}

	/**
	 * Test method for {@link database.bean.ConfiguradorPainel#getBgColor()}.
	 */
	public void testGetBgColor() {
		assertEquals("FFFFFF", conf.getBgColor());
		conf.setBgColor("000000");
		assertEquals("000000", conf.getBgColor());
	}

	/**
	 * Test method for {@link database.bean.ConfiguradorPainel#getShowClock()}.
	 */
	public void testGetShowClock() {
		assertEquals(1, conf.getShowClock());
		conf.setShowClock(0);
		assertEquals(0, conf.getShowClock());
	}

	/**
	 * Test method for {@link database.bean.ConfiguradorPainel#getMensagem()}.
	 */
	public void testGetMensagem() {
		assertEquals("mensagem aqui", conf.getMensagem());
		conf.setMensagem("outra mensagem");
		assertEquals("outra mensagem", conf.getMensagem());
	}

	/**
	 * Test method for {@link database.bean.ConfiguradorPainel#getInterval()}.
	 */
	public void testGetInterval() {
		assertEquals(30, conf.getInterval());
		conf.setInterval(10);
		assertEquals(10, conf.getInterval());
	}

	/**
	 * Test method for {@link database.bean.ConfiguradorPainel#getRepeat()}.
	 */
	public void testGetRepeat() {
		assertEquals(3, conf.getRepeat());
		conf.setRepeat(2);
		assertEquals(2, conf.getRepeat());
	}

	/**
	 * Test method for {@link database.bean.ConfiguradorPainel#getCorMensagem()}.
	 */
	public void testGetCorMensagem() {
		assertEquals("FFF00F", conf.getCorMensagem());
		conf.setCorMensagem("00FF00");
		assertEquals("00FF00", conf.getCorMensagem());
	}

	/**
	 * Test method for {@link database.bean.ConfiguradorPainel#getConfigurador()}.
	 */
	public void testGetConfigurador() {
		conf = ConfiguradorPainel.getConfigurador();
		assertEquals("FFFFFF", conf.getBgColor());
	}

	/**
	 * Test method for {@link database.bean.ConfiguradorPainel#getSpeed()}.
	 */
	public void testGetSpeed() {
		assertEquals(30, conf.getSpeed());
		conf.setSpeed(50);
		assertEquals(50, conf.getSpeed());
		
	}

}
