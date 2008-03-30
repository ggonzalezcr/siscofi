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

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
 * CCT -  CENTRO DE CI�NCIA E TECNOLOGIA
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
