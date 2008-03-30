package coletaDados;
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

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import util.DataUtil;

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

/**
 * Objetos dessa classe representa um dado momento da entrega de t�tulos
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
	
	//Quantidade de pessoas na entrega de t�tulo
	private int quantidadePessoas;
	
	//Tempo m�dio de entrega de t�tulo
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
	 * Determina a quantidadePessoas na entrega de t�tulos.
	 * @return o valor de quantidadePessoas.
	 */
	public int getQuantidadePessoas() {
		return quantidadePessoas;
	}

	/**
	 * Altera o valor do quantidadePessoas na entrega de t�tulos.
	 * @param quantidadePessoas novo valor de quantidadePessoas.
	 */
	public void setQuantidadePessoas(int quantidadePessoas) {
		this.quantidadePessoas = quantidadePessoas;
	}

	/**
	 * Determina o tempo m�dio para entrega de t�tulos.
	 * @return o valor de tempoMedioEntrega.
	 */
	public double getTempoMedioEntrega() {
		return tempoMedioEntrega;
	}

	/**
	 * Altera o valor do tempo m�dio para entrega de t�tulos.
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
