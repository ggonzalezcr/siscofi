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


import util.GeradorQuestionarioPDF;
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
 * Classe que implementa os testes da classe GeradorQuestionarioPDF
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class TestaGeradorQuestionarioPDF extends TestCase {

	private GeradorQuestionarioPDF gerador;
	
	public TestaGeradorQuestionarioPDF(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		gerador = new GeradorQuestionarioPDF();
	}

	/**
	 * Metodo que retorna uma suite de teste para a classe
	 * TestaGeradorQuestionarioPDF
	 * 
	 * @return uma suite de teste.
	 */
	public static Test suite() {
		return new TestSuite(TestaGeradorQuestionarioPDF.class);
	}
	
	public void testGerarPDFQuestionario(){
		try{
		gerador = new GeradorQuestionarioPDF();
		gerador.geraPDF();
		}catch (Exception e){
			assertFalse(true);
		}
	}
}
