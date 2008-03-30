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
 */

import org.apache.struts.action.ActionForm;

import coletaDados.TempoAvaliacao;

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
 * Classe que representa um Form da classe Emissao
 * 
 * @author Carlos Trajano
 * @author Hamon Barros
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class TempoAvaliacaoForm extends ActionForm {

	private TempoAvaliacao tempoAvaliacao = new TempoAvaliacao();
	
	private int quantidadePessoas;
	private double tempoMedioAvaliacao;
		

	/**
	 * Determina o quantidadePessoas.
	 * @return o valor de quantidadePessoas.
	 */
	public int getQuantidadePessoas() {
		return tempoAvaliacao.getQuantidadePessoas();
	}

	/**
	 * Altera o valor do quantidadePessoas.
	 * @param quantidadePessoas novo valor do quantidadePessoas.
	 */
	public void setQuantidadePessoas(int quantidadePessoas) {
		tempoAvaliacao.setQuantidadePessoas(quantidadePessoas);
	}

	/**
	 * Determina o tempoMedioAvalaicao.
	 * @return o valor de tempoMedioAvaliacao.
	 */
	public double getTempoMedioAvaliacao() {
		return tempoAvaliacao.getTempoMedioAvaliacao();
	}

	/**
	 * Altera o valor do tempoMedioAvaliacao.
	 * @param tempoMedioAvaliacao novo valor do tempoMedioAvaliacao.
	 */
	public void setTempoMedioAvaliacao(double tempoMedioAvaliacao) {
		tempoAvaliacao.setTempoMedioAvaliacao(tempoMedioAvaliacao);
	}

	/**
	 * Determina um objeto TempoAvaliacao.
	 * @return objeto tempoAvaliacao.
	 */
	public TempoAvaliacao getTempoAvaliacao() {
		return tempoAvaliacao;
	}

	/**
	 * Altera o objeto tempoAvaliacao.
	 * @param tempoAvaliacao novo objeto tempoAvaliacao.
	 */
	public void setTempoAvaliacao(TempoAvaliacao tempoAvaliacao) {
		this.tempoAvaliacao = tempoAvaliacao;
	}
}
