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
 *
 * Você deve ter recebido uma cópia da Licença Pública Geral GNU
 * junto com este programa, se não, escreva para a Fundação do Software
 * Livre(FSF) Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA
 *
 */ 

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Entity;

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
 * Objetos dessa classe representa um dado momento da avalição do atendimento.
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
	
	//Tempo médio de avaliação do atendimento
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
	 * Determina o tempo médio de avaliação do atendimento.
	 * @return o valor de tempoMedioEntrega.
	 */
	public double getTempoMedioAvaliacao() {
		return tempoMedioAvaliacao;
	}

	/**
	 * Altera o valor do tempo médio de avaliação do atendimento.
	 * @param tempoMedioAvaliacao novo valor de tempoMedioEntrega.
	 */
	public void setTempoMedioAvaliacao(double tempoMedioAvaliacao) {
		this.tempoMedioAvaliacao = tempoMedioAvaliacao;
	}
	
	@Override
	public String toString() {
		return "dados de " + DataUtil.formatarDataHora(dataAtual) + ", quantidade de pessoas que avaliaram o atendimento " + quantidadePessoas + ", tempo medio de avaliação " + tempoMedioAvaliacao; 
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
