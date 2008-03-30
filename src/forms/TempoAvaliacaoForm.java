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
 */

import org.apache.struts.action.ActionForm;

import coletaDados.TempoAvaliacao;

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
