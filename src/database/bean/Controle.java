package database.bean;

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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
 * Bean que armazena os dados de um Controle de atendimento.
 * 
 * @author Carlos Trajano
 * @author Hamon Barros
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 * 
 */

// Uso de hibernate 3 com annotation
@Entity
public class Controle implements Comparable<Controle> {

	@Id
	private String classe ="";// Nome da classe de atendimento

	private int quantidade = 0;// Quantidade de senha emitadas

	private int ultimaSenha = 0;// Ultima senha chamada

	private String cor = "";// Cor da senha para ser exibida no painel.

	@Column(name = "prefixo", nullable = false, length = 3)
	private String prefixo = "";// prefixo da classe de atendimento

	private String ultimoGuiche = "";

	private int quantidadeInicial = 0;

	/**
	 * Determina a quantidade inicial de senha para o controle.
	 * 
	 * @return the quantidadeInicial
	 */
	public int getQuantidadeInicial() {
		return quantidadeInicial;
	}

	/**
	 * Altera a quantidade inicial para este controle.
	 * 
	 * @param quantidadeInicial
	 *            o novo valor da quantidadeInicial.
	 */
	public void setQuantidadeInicial(int quantidadeInicial) {
		this.quantidadeInicial = quantidadeInicial;
	}

	/**
	 * Determina o ultimo guiche que realizou uma chamada.
	 * 
	 * @return o último guiche.
	 */
	public String getUltimoGuiche() {
		return ultimoGuiche;
	}

	/**
	 * Altera o último guiche chamado que realizou uma chamada.
	 * 
	 * @param ultimoGuiche
	 *            novo valor do último guiche.
	 */
	public void setUltimoGuiche(String ultimoGuiche) {
		this.ultimoGuiche = ultimoGuiche;
	}

	/**
	 * Dtermina o prefixo que determina essa classe de atendimento. Obs.: Todo
	 * prefixo é formado por caracteres maiúsculos.
	 * 
	 * @return o prefixo da classe.
	 */
	public String getPrefixo() {
		return prefixo;
	}

	/**
	 * Altera o prefico que define essa classe atendimento. Obs.: Todo prefixo é
	 * formado por caracteres maiúsculos.
	 * 
	 * @param prefixo
	 *            novo prefixo da classe.
	 */
	public void setPrefixo(String prefixo) {
		String pre = prefixo.toUpperCase();
		try {
			this.prefixo = pre.substring(0, 3);
		} catch (Exception e) {
		}
	}

	/**
	 * Determina o nome da classe de atendimento do controle.
	 * 
	 * @return O nome da classe de atendimento do controle.
	 */
	public String getClasse() {
		return classe;
	}

	/**
	 * Altera o nome da classe de atendimento do controle.
	 * 
	 * @param classe
	 *            O novo nome da classe de atendimento do controle.
	 */
	public void setClasse(String classe) {
		this.classe = classe;
	}

	/**
	 * Determina a quantidade de senha emitidas para este controle
	 * 
	 * @return a quantidade de senha emitidas para este controle
	 */
	public int getQuantidade() {
		return quantidade;
	}

	/**
	 * Altera a quantidade de senha emitidas para este controle
	 * 
	 * @param quantidade
	 *            A nova quantidade de senha emitidas para este controle
	 */
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * Determina o número da última senha chamada.
	 * 
	 * @return O número da última senha chamada.
	 */
	public int getUltimaSenha() {
		return ultimaSenha;
	}

	/**
	 * Altera o número da última senha chamada
	 * 
	 * @param ultimo
	 *            o novo número da última senha chamada.
	 */
	public void setUltimaSenha(int ultimo) {
		this.ultimaSenha = ultimo;
	}

	/**
	 * Incrementa a quantidade de senha chamadas.
	 * 
	 * @param incremento
	 *            O valor do incremento.
	 */
	public void incrementaQuantidade(int incremento) {
		setQuantidade(this.getQuantidade() + incremento);

	}

	//
	/**
	 * Avança o controle para a próxima chamada, dessa forma incrementa o valor
	 * da ultima senha e decrementa a quantidade.
	 * 
	 * @param guiche
	 *            O número do guiche que fez a última chamada.
	 * 
	 * @return True se for possível avançar e False em caso contrário. Não é
	 *         possível avançar quando a quantidade de atendimento é zero.
	 */
	public boolean avancar(String guiche) {
		if (quantidade <= 0) {
			return false;
		}
		ultimaSenha++;
		quantidade--;
		ultimoGuiche = guiche;
		return true;
	}

	/**
	 * Gera String representando o controle.
	 * 
	 * @return String que representa o controle.
	 */
	public String toString() {
		return "classe=" + classe + ",prefixo=" + prefixo + ",quantidade="
				+ quantidade + ",ultimo=" + ultimaSenha + ",QuantidadeInicial="
				+ quantidadeInicial + ", cor=" + cor;
	}

	/**
	 * Determina a próxima senha a ser chamada (prefixo + senha). Ao contrário de getUltimaSenha que
	 * apenas determina o número da próxima senha
	 * 
	 * @return Próxima senha a ser chamada.
	 */
	public String getSenha() {
		String valor;
		if(ultimaSenha < 10){
			valor = ((ultimaSenha + 100) + "").substring(1);
		} else{
			valor = ultimaSenha + "";
		}
		return prefixo + " " + valor;
	}

	/**
	 * Metodo que retorna a senha a ser impressa
	 * 
	 * @return a senha a ser impressa
	 */
	public String senhaASerImpressa() {
		int valor = ultimaSenha + quantidade;
		if(valor < 10){
			return prefixo + " 0" + valor;
		} 
		return prefixo + " " + valor;
	}

	/**
	 * Determina a cor que a senha deve apresentar ao ser exibida no painel.
	 * 
	 * @return a cor a ser senha.
	 */
	public String getCor() {
		return cor;
	}

	/**
	 * Altera a cor da senha para exibição no painel
	 * 
	 * @param novaCor
	 *            uma string com a nova cor da senha.
	 */
	public void setCor(String novaCor) {
		cor = novaCor;
	}

	/**
	 * Compara o controle com outro controle.
	 * 
	 * @return inteiro menor que 0 se este controle for menor, 0 se forem iguais
	 *         e inteiro maior que 0 se este controle for maior
	 */
	public int compareTo(Controle o) {
		return classe.compareTo(o.classe);
	}
	
}
