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

import coletaDados.EntregaTitulo;

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
 * CCT -  CENTRO DE CI�NCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO II
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES
 */

/**
 * Classe que representa um Form da classe EntregaTitulo
 * 
 * @author Carlos Trajano
 * @author Hamon Barros
 * @author Rodrigo Lopes
 * 
 * @version 1.0
 */

public class EntregaTituloForm extends ActionForm {

	// Atributos de classe
	private static final long serialVersionUID = 1L;

	private EntregaTitulo entregaTitulo = new EntregaTitulo();
	
	private int quantidadePessoas;
	private double tempoMedioEntrega;
	
	

	/**
	 * Determina o quantidadePessoas.
	 * @return o valor de quantidadePessoas.
	 */
	public int getQuantidadePessoas() {
		return entregaTitulo.getQuantidadePessoas();
	}

	/**
	 * Altera o valor do quantidadePessoas.
	 * @param quantidadePessoas novo valor do quantidadePessoas.
	 */
	public void setQuantidadePessoas(int quantidadePessoas) {
		entregaTitulo.setQuantidadePessoas(quantidadePessoas);
	}

	/**
	 * Determina o tempoMedioEntrega.
	 * @return o valor de tempoMedioEntrega.
	 */
	public double getTempoMedioEntrega() {
		return entregaTitulo.getTempoMedioEntrega();
	}

	/**
	 * Altera o valor do tempoMedioEntrega.
	 * @param tempoMedioEntrega novo valor do tempoMedioEntrega.
	 */
	public void setTempoMedioEntrega(double tempoMedioEntrega) {
		entregaTitulo.setTempoMedioEntrega(tempoMedioEntrega);
	}

	/**
	 * Determina um objeto entregaTitulo.
	 * @return objeto entregaTitulo.
	 */
	public EntregaTitulo getEntregaTitulo() {
		return entregaTitulo;
	}

	/**
	 * Altera o objeto entregaTitulo.
	 * @param entregaTitulo novo objeto entregaTitulo.
	 */
	public void setEntregaTitulo(EntregaTitulo entregaTitulo) {
		this.entregaTitulo = entregaTitulo;
	}
	
	

}
