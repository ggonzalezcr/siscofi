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

import junit.framework.TestCase;
import database.bean.Conexao;

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
 * Classe que testa a classe Conexão
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */
public class TestaConexao extends TestCase {

	private Conexao con;
	
	/**
	 * @param name
	 */
	public TestaConexao(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		con = new Conexao();
	}

	/**
	 * Test method for {@link database.bean.Conexao#getPorta()}.
	 */
	public void testGetPorta() {
		assertEquals("5433", con.getPorta());
		con.setPorta("12345");
		assertEquals("12345", con.getPorta());
	}

	/**
	 * Test method for {@link database.bean.Conexao#getIp()}.
	 */
	public void testGetIp() {
		assertEquals("localhost", con.getIp());
		con.setIp("150.165.54.2:8080");
		assertEquals("150.165.54.2:8080", con.getIp());
	}

	/**
	 * Test method for {@link database.bean.Conexao#getLogin()}.
	 */
	public void testGetLogin() {
		assertNull(con.getLogin());
		con.setLogin("seuLunga");
		assertEquals("seuLunga", con.getLogin());
	}

	/**
	 * Test method for {@link database.bean.Conexao#getSenha()}.
	 */
	public void testGetSenha() {
		assertNull(con.getSenha());
		con.setSenha("12345");
		assertEquals("12345", con.getSenha());
	}

	/**
	 * Test method for {@link database.bean.Conexao#save(database.bean.Conexao)}.
	 */
	public void testSave() {
		
	}

	/**
	 * Test method for {@link database.bean.Conexao#getConexao()}.
	 */
	public void testGetConexao() {
		con = Conexao.getConexao();
		assertEquals("localhost", con.getIp());
	}

}
