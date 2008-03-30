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
 *
 * Voc� deve ter recebido uma c�pia da Licen�a P�blica Geral GNU
 * junto com este programa, se n�o, escreva para a Funda��o do Software
 * Livre(FSF) Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA
 *
 */ 

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Entity;

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
 * Objetos dessa classe representa um dado momento da avali��o do atendimento.
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

@Entity
public class TempoAvaliacao{

    //Data/hora atual
	@Id
	private Date dataAtual;
	
	//Quantidade de pessoas que avaliaram o atendimento
	private int quantidadePessoas;
	
	//Tempo m�dio de avalia��o do atendimento
	private double tempoMedioAvaliacao;
	
	/**
	 * Construtror
	 */
	public TempoAvaliacao(){
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
	 * Determina a quantidade de pessoas que avaliaram o atendimento.
	 * entrega das senhas.
	 * @return o valor de quantidadePessoas.
	 */
	public int getQuantidadePessoas() {
		return quantidadePessoas;
	}

	/**
	 * Altera o valor da quantidade de pessoas que avaliaram o atendimento
	 * @param quantidadePessoas novo valor de quantidadePessoas.
	 */
	public void setQuantidadePessoas(int quantidadePessoas) {
		this.quantidadePessoas = quantidadePessoas;
	}

	/**
	 * Determina o tempo m�dio de avalia��o do atendimento.
	 * @return o valor de tempoMedioEntrega.
	 */
	public double getTempoMedioAvaliacao() {
		return tempoMedioAvaliacao;
	}

	/**
	 * Altera o valor do tempo m�dio de avalia��o do atendimento.
	 * @param tempoMedioAvaliacao novo valor de tempoMedioEntrega.
	 */
	public void setTempoMedioAvaliacao(double tempoMedioAvaliacao) {
		this.tempoMedioAvaliacao = tempoMedioAvaliacao;
	}
	
	@Override
	public String toString() {
		return "dados de " + DataUtil.formatarDataHora(dataAtual) + ", quantidade de pessoas que avaliaram o atendimento " + quantidadePessoas + ", tempo medio de avalia��o " + tempoMedioAvaliacao; 
	}
	
	@Override
	public boolean equals(Object arg0) {
		if (arg0 instanceof TempoAvaliacao) {
			TempoAvaliacao ta = (TempoAvaliacao) arg0;
			if(this.dataAtual == ta.dataAtual && 
				this.quantidadePessoas == ta.quantidadePessoas && 
				this.tempoMedioAvaliacao == ta.tempoMedioAvaliacao)
				return true;
		}
		return false;
	} 
		
}
