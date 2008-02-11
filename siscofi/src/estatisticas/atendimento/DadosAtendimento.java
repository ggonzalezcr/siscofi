package estatisticas.atendimento;

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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.hibernate.annotations.CollectionOfElements;

import util.DataUtil;

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
 * CCT -  CENTRO DE CIÊNCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO 2
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES DA SILVA
 */

/**
 * Classe que armazena dados sobre atendimentos realizado em uma determinada data. 
 * 
 * @author Carlos Trajano
 * @author Hamon Barros
 * @author Rodrigo Lopes
 * 
 * @version 1.0
 */

@Entity
public class DadosAtendimento {
	
	@Id
	private Date data;
	
	//Total de atendimentos realizados na data.
	private int totalAtendimentos;
	
	//Tempo medio de atendimento-
	private double tempoMedio;
	
	//Mapeamento do atendente para o total de atendimentos realizados pelo mesmo
	@CollectionOfElements(fetch=FetchType.EAGER)
	@JoinTable(name="atendenteAtendimentos", joinColumns=@JoinColumn(name="id_Atendente"))
	@Column(name="Atendimentos")
	Map<String, Integer> atendenteAtendimentos;
	
	//Mapeamento do guichê para o total de atendimentos realizados no mesmo
	@CollectionOfElements(fetch=FetchType.EAGER)
	@JoinTable(name="guicheAtendimentos", joinColumns=@JoinColumn(name="id_guiche"))
	@Column(name="Atendimentos")
	Map<Integer, Integer> guicheAtendimentos;
	
	//Mapeamento da classe de atendimento para o total de atendimentos realizados na mesma
	@CollectionOfElements(fetch=FetchType.EAGER)
	@JoinTable(name="classeAtendimentos", joinColumns=@JoinColumn(name="id_classe"))
	@Column(name="Atendimentos")
	Map<String, Integer> classeAtendimentos;
	
	/**
	 * 
	 * Cria uma novo DadosAtendimento.
	 */
	public DadosAtendimento() {
		data = DataUtil.getDataAtual();
		atendenteAtendimentos = new HashMap<String, Integer>();
		classeAtendimentos =  new HashMap<String, Integer>();
		guicheAtendimentos =  new HashMap<Integer, Integer>();
	}

	/**
	 * Determina o valor de data.
	 * @return o valor de data.
	 */
	public Date getData() {
		return data;
	}

	/**
	 * ALtera o valor de data.
	 * @param data o novo valor para data.
	 */
	public void setData(Date data) {
		this.data = data;
	}

	/**
	 * Determina o mapa de atendenteAtendimentos.
	 * @return o valor de atendenteAtendimentos. Um mapa que relaciona os atendentes com o total de atendimento realizado pelos atendentes.
	 */
	public Map<String, Integer> getAtendenteAtendimentos() {
		return atendenteAtendimentos;
	}

	/**
	 * ALtera o mapa de atendenteAtendimentos.
	 * @param atendenteAtendimentos o novo mapa atendenteAtendimentos. Um mapa que relaciona os atendentes com o total de atendimento realizado pelos atendentes.
	 */
	public void setAtendenteAtendimentos(Map<String, Integer> atendenteAtendimentos) {
		this.atendenteAtendimentos = atendenteAtendimentos;
	}

	/**
	 * Determina o mapa de guicheAtendimentos.
	 * @return o valor de guicheAtendimentos. Um mapa que relaciona os guichês com o total de atendimento realizado nos guichês.
	 */
	public Map<Integer, Integer> getGuicheAtendimentos() {
		return guicheAtendimentos;
	}

	/**
	 * ALtera o mapa de guicheAtendimentos. Um mapa que relaciona os guichês com o total de atendimento realizado nos guichês.
	 * @param guicheAtendimentos o novo mapa de guicheAtendimentos.
	 */
	public void setGuicheAtendimentos(Map<Integer, Integer> guicheAtendimentos) {
		this.guicheAtendimentos = guicheAtendimentos;
	}

	/**
	 * Determina o valor do mapa classeAtendimentos. Um mapa que relaciona as classes de atendimento com o total de atendimento realizado nas classes.
	 * @return o o mapa classeAtendimentos.
	 */
	public Map<String, Integer> getClasseAtendimentos() {
		return classeAtendimentos;
	}

	/**
	 * ALtera o mapa de classeAtendimentos. Um mapa que relaciona as classes de atendimento com o total de atendimento realizado nas classes.
	 * @param classeAtendimentos o novo mapa classeAtendimentos.
	 */
	public void setClasseAtendimentos(Map<String, Integer> classeAtendimentos) {
		this.classeAtendimentos = classeAtendimentos;
	}
	
	/**
	 * Incrementa em 01 a contagem de atendimentos para um guichê, atendente e classe de atendimento. 
	 * @param guiche O guichê a ser atualiza a contagem.
	 * @param atendente O atendente a ser atualiza a contagem.
	 * @param classe A classe a ser atualiza a contagem.
	 */
	public void atualizaContagem(int guiche, String atendente, String classe){
		atualizaAtendente(atendente);
		atualizaGuiche(guiche);
		atualizaClasse(classe);
		totalAtendimentos++;
	}

	/**
	 * Incrementa em 01 a contagem de atendimentos para uma classe.
	 * @param classe A classe a ser atualiza a contagem.
	 */
	private void atualizaClasse(String classe) {
		int contagemClasse = 1;
		if(classeAtendimentos.containsKey(classe)){
			contagemClasse = contagemClasse + classeAtendimentos.get(classe);
		}
		classeAtendimentos.put(classe, contagemClasse);
	}

	/**
	 * Incrementa em 01 a contagem de atendimentos para um guichê.
	 * @param classe O guichê a ser atualiza a contagem.
	 */
	private void atualizaGuiche(int guiche) {
		int contagemGuiche = 1;
		if(guicheAtendimentos.containsKey(guiche)){
			contagemGuiche = contagemGuiche + guicheAtendimentos.get(guiche);
		}
		guicheAtendimentos.put(guiche, contagemGuiche);
	}

	/**
	 * Incrementa em 01 a contagem de atendimentos para um atendente.
	 * @param classe o atendente a ser atualiza a contagem.
	 */
	private void atualizaAtendente(String atendente) {
		int contagemAtendente = 1;
		if(atendenteAtendimentos.containsKey(atendente)){
			contagemAtendente = contagemAtendente + atendenteAtendimentos.get(atendente);
		}
		atendenteAtendimentos.put(atendente, contagemAtendente);
	}

	/**
	 * Determina o valor de total atendimentos realizados na data.
	 * @return o valor de totalAtendimentos.
	 */
	public int getTotalAtendimentos() {
		return totalAtendimentos;
	}

	/**
	 * ALtera o total atendimentos realizados na data.
	 * @param totalAtendimentos o novo total de atendimentos.
	 */
	public void setTotalAtendimentos(int totalAtendimentos) {
		this.totalAtendimentos = totalAtendimentos;
	}

	/**
	 * Determina o tempo medio de atendimento
	 * @return O tempo medio de atendimento
	 */
	public double getTempoMedio() {
		return tempoMedio;
	}

	/**
	 * Altera o tempo medio de atendimento
	 * @param tempoMedio O novo tempo medio
	 */
	public void setTempoMedio(double tempoMedio) {
		this.tempoMedio = tempoMedio;
	}
	
	/**
	 * Determina uma String que representa o objeto.
	 */
	public String toString() {
		return DataUtil.formatarData(data) + ", classes=" + classeAtendimentos + ", atendentes=" + atendenteAtendimentos + ", guiches" + guicheAtendimentos + ", total de atendimentos=" + totalAtendimentos + ", tempo medio de atendimento=" + tempoMedio;
	}

	
}
