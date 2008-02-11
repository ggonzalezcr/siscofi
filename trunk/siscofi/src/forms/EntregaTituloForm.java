package forms;

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

import org.apache.struts.action.ActionForm;

import coletaDados.EntregaTitulo;

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
 * CCT -  CENTRO DE CIÊNCIA E TECNOLOGIA
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
