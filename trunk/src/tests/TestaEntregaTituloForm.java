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
import coletaDados.EntregaTitulo;
import forms.EntregaTituloForm;

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
