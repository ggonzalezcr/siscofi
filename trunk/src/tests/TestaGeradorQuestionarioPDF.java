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

 * Voc� deve ter recebido uma c�pia da Licen�a P�blica Geral GNU
 * junto com este programa, se n�o, escreva para a Funda��o do Software
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
 * CCT -  CENTRO DE CI�NCIA E TECNOLOGIA
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
