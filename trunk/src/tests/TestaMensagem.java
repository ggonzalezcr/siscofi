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
