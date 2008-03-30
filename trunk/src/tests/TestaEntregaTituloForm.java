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

import junit.framework.TestCase;
import coletaDados.EntregaTitulo;
import forms.EntregaTituloForm;

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
 * Classe que testa a classe EntregaTituloForm
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class TestaEntregaTituloForm extends TestCase {

	EntregaTituloForm form;
	EntregaTitulo entregaTitulo;
	
	protected void setUp() throws Exception {
		super.setUp();
		form = new EntregaTituloForm();
		entregaTitulo = new EntregaTitulo();
	}

	public final void testGetEntregaTitulo() {
		assertEquals(null, form.getEntregaTitulo());
		form.setEntregaTitulo(entregaTitulo);
		assertEquals(entregaTitulo, form.getEntregaTitulo());
	}

	public final void testSetEntregaTitulo() {
		form.setEntregaTitulo(entregaTitulo);
		assertEquals(entregaTitulo, form.getEntregaTitulo());
		entregaTitulo.setQuantidadePessoas(10);
		form.setEntregaTitulo(entregaTitulo);
		EntregaTitulo temp = form.getEntregaTitulo();
		assertEquals(10, temp.getQuantidadePessoas());
	}

}
