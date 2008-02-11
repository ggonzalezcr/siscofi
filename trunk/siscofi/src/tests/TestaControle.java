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
import database.bean.Controle;

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
 * Testes da classe Controle.
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes
 * 
 * @version 1.0
 */
public class TestaControle extends TestCase {

	//Atributos
	protected Controle controle1;

	protected Controle controle2;

	protected Controle controle3;


	public TestaControle(String name) {

		super(name);

	}

	public static void main(String[] args) {

		junit.textui.TestRunner.run(suite());

	}

	protected void setUp() {

		controle1 = new Controle();
		controle1.setClasse("Segunda Via");
		controle1.setQuantidade(2);
		controle1.setUltimaSenha(1);
		controle1.setPrefixo("111");
		
		controle2 = new Controle();
		controle2.setClasse("Recadastramento");
		controle2.setQuantidade(10);
		controle2.setUltimaSenha(2);
		controle2.setPrefixo("222");
		
		controle3 = new Controle();
		controle3.setClasse("Tipo3");
		controle3.setQuantidade(15);
		controle3.setUltimaSenha(10);
		controle3.setPrefixo("333");
		
		
	}

	public static Test suite() {

		return new TestSuite(TestaControle.class);

	}

	/**
	 * Testa o método incrementaQuantidade
	 */
	public void testIncrementaQuantidade() {
		
		controle1.incrementaQuantidade(10);
		controle2.incrementaQuantidade(20);
		controle3.incrementaQuantidade(30);
		
		assertEquals("1", 12, controle1.getQuantidade());
		assertEquals("2", 30, controle2.getQuantidade());
		assertEquals("3", 45, controle3.getQuantidade());
		
		
	}
	
	/**
	 * Testa o método avança()
	 */
	public void testAvanca() {
		
		controle1.setQuantidade(-1);
		assertEquals("1", false, controle1.avancar(controle1.getClasse()));
		assertEquals("2", true, controle2.avancar(controle1.getClasse()));
		
		controle2.avancar(controle1.getClasse());
		controle3.avancar(controle1.getClasse());
	
		assertEquals("3", "222 04", controle2.getSenha());
		assertEquals("3", 4, controle2.getUltimaSenha());
		assertEquals("4", 8, controle2.getQuantidade());
	
		assertEquals("5", "333 11", controle3.getSenha());
		assertEquals("5", 11, controle3.getUltimaSenha());
		assertEquals("6", 14, controle3.getQuantidade());
		
	}
	
	/**
	 * Testa o método toString()
	 */
	public void testToString() {
		assertEquals("1", "classe=Segunda Via,prefixo=111,quantidade=2,ultimo=1,QuantidadeInicial=0, cor=", controle1.toString());
		assertEquals("2", "classe=Recadastramento,prefixo=222,quantidade=10,ultimo=2,QuantidadeInicial=0, cor=", controle2.toString());
		assertEquals("3", "classe=Tipo3,prefixo=333,quantidade=15,ultimo=10,QuantidadeInicial=0, cor=", controle3.toString());
	}
	
}
