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

import controller.ConfiguracaoBD;
import junit.framework.TestCase;


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
 * Classe que testa a classe ConfiguracaoBD
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */
public class TestaConfiguracaoBD extends TestCase {

	/**
	 * @param arg0
	 */
	public TestaConfiguracaoBD(String arg0) {
		super(arg0);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * Test method for {@link controller.ConfiguracaoBD#getHibernateConnectionDriver_class()}.
	 */
	public void testGetHibernateConnectionDriver_class() {
		ConfiguracaoBD.setHibernateConnectionDriver_class("DriverTeste");
		assertEquals("DriverTeste", ConfiguracaoBD.getHibernateConnectionDriver_class());
	}

	/**
	 * Test method for {@link controller.ConfiguracaoBD#setHibernateConnectionDriver_class(java.lang.String)}.
	 */
	public void testSetHibernateConnectionDriver_class() {
		ConfiguracaoBD.setHibernateConnectionDriver_class("DriverTeste");
		assertEquals("DriverTeste", ConfiguracaoBD.getHibernateConnectionDriver_class());
		ConfiguracaoBD.setHibernateConnectionDriver_class("DriverTeste2");
		assertEquals("DriverTeste2", ConfiguracaoBD.getHibernateConnectionDriver_class());
	}

	/**
	 * Test method for {@link controller.ConfiguracaoBD#getHibernateConnectionPassword()}.
	 */
	public void testGetHibernateConnectionPassword() {
		ConfiguracaoBD.setHibernateConnectionPassword("admin");
		assertEquals("admin", ConfiguracaoBD.getHibernateConnectionPassword());
	}

	/**
	 * Test method for {@link controller.ConfiguracaoBD#setHibernateConnectionPassword(java.lang.String)}.
	 */
	public void testSetHibernateConnectionPassword() {
		ConfiguracaoBD.setHibernateConnectionPassword("admin");
		assertEquals("admin", ConfiguracaoBD.getHibernateConnectionPassword());
		ConfiguracaoBD.setHibernateConnectionPassword("admin2");
		assertEquals("admin2", ConfiguracaoBD.getHibernateConnectionPassword());
	}

	/**
	 * Test method for {@link controller.ConfiguracaoBD#getHibernateConnectionUrl()}.
	 */
	public void testGetHibernateConnectionUrl() {
		ConfiguracaoBD.setHibernateConnectionUrl("localhost:2356");
		assertEquals("localhost:2356", ConfiguracaoBD.getHibernateConnectionUrl());
	}

	/**
	 * Test method for {@link controller.ConfiguracaoBD#setIP(java.lang.String, java.lang.String)}.
	 */
	public void testSetIP() {
		ConfiguracaoBD.setHibernateConnectionUrl("jdbc:postgresql://localhost:2354/postgres");
		assertEquals("jdbc:postgresql://localhost:2354/postgres", ConfiguracaoBD.getHibernateConnectionUrl());
		ConfiguracaoBD.setIP("154.165.69.8", "28");
		assertEquals("jdbc:postgresql://154.165.69.8:28/postgres", ConfiguracaoBD.getHibernateConnectionUrl());
	}

	/**
	 * Test method for {@link controller.ConfiguracaoBD#setHibernateConnectionUrl(java.lang.String)}.
	 */
	public void testSetHibernateConnectionUrl() {
		ConfiguracaoBD.setHibernateConnectionUrl("localhost:2356");
		assertEquals("localhost:2356", ConfiguracaoBD.getHibernateConnectionUrl());
		ConfiguracaoBD.setHibernateConnectionUrl("localhost2:5623");
		assertEquals("localhost2:5623", ConfiguracaoBD.getHibernateConnectionUrl());
	}

	/**
	 * Test method for {@link controller.ConfiguracaoBD#getHibernateConnectionUsername()}.
	 */
	public void testGetHibernateConnectionUsername() {
		ConfiguracaoBD.setHibernateConnectionUsername("teste");
		assertEquals("teste", ConfiguracaoBD.getHibernateConnectionUsername());
	}

	/**
	 * Test method for {@link controller.ConfiguracaoBD#setHibernateConnectionUsername(java.lang.String)}.
	 */
	public void testSetHibernateConnectionUsername() {
		ConfiguracaoBD.setHibernateConnectionUsername("teste");
		assertEquals("teste", ConfiguracaoBD.getHibernateConnectionUsername());
		ConfiguracaoBD.setHibernateConnectionUsername("teste2");
		assertEquals("teste2", ConfiguracaoBD.getHibernateConnectionUsername());
	}

	/**
	 * Test method for {@link controller.ConfiguracaoBD#getHibernateDialect()}.
	 */
	public void testGetHibernateDialect() {
		ConfiguracaoBD.setHibernateDialect("Dialect");
		assertEquals("Dialect", ConfiguracaoBD.getHibernateDialect());
	}

	/**
	 * Test method for {@link controller.ConfiguracaoBD#setHibernateDialect(java.lang.String)}.
	 */
	public void testSetHibernateDialect() {
		ConfiguracaoBD.setHibernateDialect("Dialect");
		assertEquals("Dialect", ConfiguracaoBD.getHibernateDialect());
		ConfiguracaoBD.setHibernateDialect("Dialect2");
		assertEquals("Dialect2", ConfiguracaoBD.getHibernateDialect());
	}

	/**
	 * Test method for {@link controller.ConfiguracaoBD#getIp()}.
	 */
	public void testGetIp() {
		ConfiguracaoBD.setIP("123.654.879.62", "2548");
		assertEquals("123.654.879.62", ConfiguracaoBD.getIp());
	}

	/**
	 * Test method for {@link controller.ConfiguracaoBD#getPorta()}.
	 */
	public void testGetPorta() {
		ConfiguracaoBD.setIP("123.654.879.62", "2548");
		assertEquals("2548", ConfiguracaoBD.getPorta());
	}

}
