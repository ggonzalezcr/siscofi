package forms;

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

import org.apache.struts.action.ActionForm;

import database.bean.Formulario;

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
 * Classe que representa um Form para exibi��o do formulario
 * 
 * @author Carlos Trajano
 * @author Hamon Barros
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */
public class FormularioForm extends ActionForm{

	// Atributos
	private Formulario formulario = new Formulario();
	private String resposta1;
	private String resposta2;
	private String resposta3;	
	private String resposta4;
	private String resposta5;

	public String getResposta1() {
		return formulario.getResposta1();
	}

	public void setResposta1(String resposta1) {
		this.resposta1 = resposta1;
		this.formulario.setResposta1(resposta1);
	}

	public String getResposta2() {
		return formulario.getResposta2();
	}

	public void setResposta2(String resposta2) {
		this.resposta2 = resposta2;
		this.formulario.setResposta2(resposta2);
	}
	
	public String getResposta3() {
		return formulario.getResposta3();
	}

	public void setResposta3(String resposta3) {
		this.resposta3 = resposta3;
		this.formulario.setResposta3(resposta3);
	}
	public String getResposta4() {
		return formulario.getResposta4();
	}

	public void setResposta4(String resposta4) {
		this.resposta4 = resposta4;
		this.formulario.setResposta4(resposta4);
	}
	public String getResposta5() {
		return formulario.getResposta5();
	}

	public void setResposta5(String resposta5) {
		this.resposta5 = resposta5;
		this.formulario.setResposta5(resposta5);
	}

	/**
	 * Retorna o valor do atributo formulario
	 * @return o valor do atributo formulario
	 */
	public Formulario getFormulario() {
		return formulario;
	}

	/**
	 * Altera o valor do atributo formulario
	 * @param formulario O novo valor do atributo formulario 
	 */
	public void setFormulario(Formulario formulario) {
		this.formulario = formulario;
	}

	
}
