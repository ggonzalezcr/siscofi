package coletaDados;
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

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import util.DataUtil;

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

/**
 * Objetos dessa classe representa um dado momento da entrega de títulos
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

@Entity
public class EntregaTitulo {
	
	//Data/hora atual da entrega
	@Id
	private Date dataAtual;
	
	//Quantidade de pessoas na entrega de título
	private int quantidadePessoas;
	
	//Tempo médio de entrega de título
	private double tempoMedioEntrega;
	
	public EntregaTitulo(){
		dataAtual = DataUtil.getDataHora();
	}

	/**
	 * Determina a dataAtual.
	 * @return o valor de dataAtual.
	 */
	public Date getDataAtual() {
		return dataAtual;
	}

	/**
	 * Altera o valor da dataAtual.
	 * @param dataAtual novo valor da dataAtual.
	 */
	public void setDataAtual(Date dataAtual) {
		this.dataAtual = dataAtual;
	}

	/**
	 * Determina a quantidadePessoas na entrega de títulos.
	 * @return o valor de quantidadePessoas.
	 */
	public int getQuantidadePessoas() {
		return quantidadePessoas;
	}

	/**
	 * Altera o valor do quantidadePessoas na entrega de títulos.
	 * @param quantidadePessoas novo valor de quantidadePessoas.
	 */
	public void setQuantidadePessoas(int quantidadePessoas) {
		this.quantidadePessoas = quantidadePessoas;
	}

	/**
	 * Determina o tempo médio para entrega de títulos.
	 * @return o valor de tempoMedioEntrega.
	 */
	public double getTempoMedioEntrega() {
		return tempoMedioEntrega;
	}

	/**
	 * Altera o valor do tempo médio para entrega de títulos.
	 * @param tempoMedioEntrega novo valor de tempoMedioEntrega.
	 */
	public void setTempoMedioEntrega(double tempoMedioEntrega) {
		this.tempoMedioEntrega = tempoMedioEntrega;
	}
	
	@Override
	public String toString() {
		return "dados de " + DataUtil.formatarDataHora(dataAtual) + ", quantidade de pessoas na entrega de titulo " + quantidadePessoas + ", tempo medio na entrega de titulo " + tempoMedioEntrega; 
	}

}
