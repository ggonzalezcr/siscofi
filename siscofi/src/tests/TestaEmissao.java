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
import database.bean.Emissao;

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
 * Testes da classe Emissao.
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes
 * 
 * @version 1.0
 */

public class TestaEmissao extends TestCase{
	
	
	private Emissao emissao;
	
	/**
	 * Contrutor da classe
	 * @param name o nome da emissao
	 */
	public TestaEmissao(String name) {

		super(name);
	}
	
	public void setUp(){
		emissao = new Emissao();
	}
	
	/**
	 * Metodo que seta um suite de testes para a classe
	 * @return a suite de teste
	 */
	public static Test suite() {

		return new TestSuite(TestaEmissao.class);

	}

	/**
	 * Testa o metodo getTotal da classe emissao.
	 */
	public void testGetTotal(){
		assertEquals("1", 1, emissao.getTotal());
	}
	
	public void testReset(){
		emissao.reset();
		assertEquals("1", 1, emissao.getTotal());
	}
	
}
