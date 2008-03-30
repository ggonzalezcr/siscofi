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

import database.bean.Atendimentos;

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
 * Classe que representa um Form da classe Estatisticas
 * 
 * @author Carlos Trajano
 * @author Hamon Barros
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class EstatisticasForm extends ActionForm {

	// Atributos de classe
	private static final long serialVersionUID = 1L;

	private Atendimentos atendimentos;

	private int variacao;
	
	private double tempoMinimoAtendimento;
	
	private double tempoMaximoAtendimento;
	
	private double fluxoChegada;
	
	/**
	 * Retorna o fluxo de chegada de eleitores na central
	 * @return O fluxo de chegada
	 */
	public double getFluxoChegada() {
		return fluxoChegada;
	}

	/**
	 * Altera o fluxo de chegada de eleitores na central
	 * @param fluxoChegada O novo fluxo de chegada
	 */
	public void setFluxoChegada(double fluxoChegada) {
		this.fluxoChegada = fluxoChegada;
	}

	/**
	 * Retorna o valor do atributo tempoMinimoAtendimento
	 * @return o valor do atributo tempoMinimoAtendimento
	 */
	public double getTempoMinimoAtendimento() {
		return tempoMinimoAtendimento;
	}

	/**
	 * Altera o valor do atributo tempoMinimoAtendimento
	 * @param tempoMinimoAtendimento O novo valor do atributo tempoMinimoAtendimento 
	 */
	public void setTempoMinimoAtendimento(double tempoMinimoAtendimento) {
		this.tempoMinimoAtendimento = tempoMinimoAtendimento;
	}

	/**
	 * Retorna o valor do atributo tempoMaximoAtendimento
	 * @return o valor do atributo tempoMaximoAtendimento
	 */
	public double getTempoMaximoAtendimento() {
		return tempoMaximoAtendimento;
	}

	/**
	 * Altera o valor do atributo tempoMaximoAtendimento
	 * @param tempoMaximoAtendimento O novo valor do atributo tempoMaximoAtendimento 
	 */
	public void setTempoMaximoAtendimento(double tempoMaximoAtendimento) {
		this.tempoMaximoAtendimento = tempoMaximoAtendimento;
	}

	public int getVariacao() {
		return variacao;
	}

	public void setVariacao(int desvioPadrao) {
		this.variacao = desvioPadrao;
	}

	public Atendimentos getAtendimentos() {
		return atendimentos;
	}

	public void setAtendimentos(Atendimentos atendimentos) {
		this.atendimentos = atendimentos;
	}

}
