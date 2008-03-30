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
import util.Cor;
import util.Mensagem;

public class TestaMensagem extends TestCase{

	private Mensagem msg1;
	private Mensagem msg2;
	
	public TestaMensagem(String name){
		
		super(name);
	}
	
	public static Test suite() {

		return new TestSuite(TestaMensagem.class);

	}
	
	protected void setUp() {
		msg1 = new Mensagem("Mensagem 1",Cor.NomeValorCor("PRETO"));
		msg2 = new Mensagem("Mensagem 2", Cor.NomeValorCor("VERDE1"));
	}
	
	public static void main(String[] args) {

		junit.textui.TestRunner.run(suite());

	}
	
	public void testToString(){
		assertEquals("1",  "Mensagem 1 000000", msg1.toString());
		assertEquals("2",  "Mensagem 2 00FF00", msg2.toString());
	}
}
