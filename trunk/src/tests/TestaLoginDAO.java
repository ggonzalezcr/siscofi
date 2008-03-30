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

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
 * CCT -  CENTRO DE CIÊNCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO II
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES DA SILVA
 */

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import database.LoginDAO;
import database.bean.Login;

public class TestaLoginDAO extends TestCase{

	
	private LoginDAO lDAO;
	
	/**
	 * Contrutor da classe
	 * @param name o nome da emissao
	 */
	public TestaLoginDAO(String name) {

		super(name);
	}
	
	public void setUp(){
		lDAO = new LoginDAO();
	}
	
	/**
	 * Metodo que seta um suite de testes para a classe
	 * @return a suite de teste
	 */
	public static Test suite() {

		return new TestSuite(TestaLoginDAO.class);

	}
	
	/**
	 * Testa o metodo que valida o login baseado em dados do BD.
	 */
	public void testValidaLogin(){
		Login login = new Login();
		login.setGuiche("01");
		login.setLogin("admin");
		login.setPassword("admin");
		assertTrue(lDAO.validaLogin(login));
		
		login.setGuiche("01");
		login.setLogin("carlos");
		login.setPassword("carlos");
		assertFalse(lDAO.validaLogin(login));
		
	}

}
