package estatisticas.atendimento;

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
 * Copyright 2007, 2008 Carlos Trajano de Oliveira, Hamon Barros Henriques, Rodrigo Lopes da Silva
 */

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import database.DadosAtendimentoDAO;
import exceptions.NotFoundInDBException;

import util.DataUtil;

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
 * CCT -  CENTRO DE CI�NCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO 2
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES DA SILVA
 */

/**
 * Bean que armazena um resumo dos atendimentos realizados em um certo per�odo. 
 * 
 * @author Carlos Trajano
 * @author Hamon Barros
 * @author Rodrigo Lopes
 * 
 * @version 1.0
 */

public class ResumoAtendimento {
	
	//Tempo Medio de Atendimento
	private double tempoMedioAtendimento;
	
	//Data inicial do per�odo
	private String dataInicial;
	
	//Data final do per�odo
	private String dataFinal;
	
	//Total de atendimentos realizados no per�odo
	private int totalAtendimentos;
	
	//Mapeamento do atendente para o total de atendimento realizado pelo mesmo
	Map<String, Integer> atendenteTotalAtendimento;
	
	//Mapeamento do guich� para o total de atendimento realizado no mesmo
	Map<Integer, Integer> guicheTotalAtendimento;
	
	//Mapeamento da classe de atendimento para o total de atendimento realizado na mesma
	Map<String, Integer> classeTotalAtendimento;
	
	//Armazena a m�dia de atendimento por classe
	private double mediaClasse;
	
	//Armazena a m�dia de atendimento por guich�
	private double mediaGuiche;
	
	//Armazena a m�dia de atendimentos por atendente
	private double mediaAtendente;
	
	public ResumoAtendimento(String dataInicial, String dataFinal, List<DadosAtendimento> atendimentos) {
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		atendenteTotalAtendimento = new HashMap<String, Integer>();
		guicheTotalAtendimento = new HashMap<Integer, Integer>();
		classeTotalAtendimento = new HashMap<String, Integer>();
		tempoMedioAtendimento = tempoMedioAtendimento(atendimentos);
		gerarResumo(atendimentos);
	}

	private double tempoMedioAtendimento(List<DadosAtendimento> atendimentos) {
		double media = 0.0;
		for (DadosAtendimento dados : atendimentos){
			media += dados.getTempoMedio();
		}
		return media/ (atendimentos.size() + 0.0);
	}

	/**
	 * Gera o resumo dos atendimentos a partir de uma lista de dados de atendimentos. 
	 * @param atendimentos Lista de dados de atendimento.
	 */
	private void gerarResumo(List<DadosAtendimento> atendimentos) {
		for(DadosAtendimento atendimento: atendimentos){
			somaClasse(atendimento.getClasseAtendimentos());
			somaGuiches(atendimento.getGuicheAtendimentos());
			somaAtendente(atendimento.getAtendenteAtendimentos());
			totalAtendimentos = totalAtendimentos + atendimento.getTotalAtendimentos();
		}
		if(totalAtendimentos > 0){
			mediaAtendente = (totalAtendimentos + 0.0 )/ atendenteTotalAtendimento.size();
			mediaGuiche = (totalAtendimentos + 0.0) / guicheTotalAtendimento.size();
			mediaClasse = (totalAtendimentos  + 0.0)/ classeTotalAtendimento.size();
		} else{
			mediaAtendente = 0;
			mediaGuiche = 0;
			mediaClasse = 0;
		}
	}

	/**
	 * Soma o total de atendimentos para cada atendente com o total recebido no par�metro.
	 * @param classeAtendimentos atendente a serem somados.
	 */
	private void somaAtendente(Map<String, Integer> atendenteAtendimentos) {
		for(String chave: atendenteAtendimentos.keySet()){
			int total = atendenteAtendimentos.get(chave);
			if(atendenteTotalAtendimento.containsKey(chave)){
				total += atendenteTotalAtendimento.get(chave);
			} 
			atendenteTotalAtendimento.put(chave, total);
		}
	}

	/**
	 * Soma o total de atendimentos para cada guich� com o total recebido no par�metro.
	 * @param classeAtendimentos guich�s a serem somadas.
	 */
	private void somaGuiches(Map<Integer, Integer> guicheAtendimentos) {
		for(int chave: guicheAtendimentos.keySet()){
			int total = guicheAtendimentos.get(chave);
			if(guicheTotalAtendimento.containsKey(chave)){
				total += guicheTotalAtendimento.get(chave);
			} 
			guicheTotalAtendimento.put(chave, total);
		}
	}

	/**
	 * Soma o total de atendimentos para cada classe com o total recebido no par�metro.
	 * @param classeAtendimentos classes a serem somadas.
	 */
	private void somaClasse(Map<String, Integer> classeAtendimentos) {
		for(String chave: classeAtendimentos.keySet()){
			int total = classeAtendimentos.get(chave);
			if(classeTotalAtendimento.containsKey(chave)){
				total += classeTotalAtendimento.get(chave);
			} 
			classeTotalAtendimento.put(chave, total);
		}
	}

	/**
	 * Determina um mapeamento dos atendentes para o total de atendimentos.
	 * @return Mapa de atendenteTotalAtendimento.
	 */
	public Map<String, Integer> getAtendenteTotalAtendimento() {
		return atendenteTotalAtendimento;
	}
	
	/**
	 * Determina um mapeamento dos atendentes para o percentual de atendimentos por atendente.
	 * @return Mapa de percentual de atendimentos.
	 */
	public Map<String, String> getAtendentePercentualAtendimento() {
		Map<String, String> mapa = new HashMap<String, String>();
		for(String atendente: atendenteTotalAtendimento.keySet()){
			double percentual = (atendenteTotalAtendimento.get(atendente)+0.0) / totalAtendimentos;
			String stringPercentual = formataPorcentagem(percentual);
			mapa.put(atendente, stringPercentual);
		}
		return mapa;
	}
	
	/**
	 * Determina um mapeamento dos guich�s para o percentual de atendimentos por guich�.
	 * @return Mapa de percentual de atendimentos.
	 */
	public Map<Integer, String> getGuichePercentualAtendimento() {
		Map<Integer, String> mapa = new HashMap<Integer, String>();
		for(int guiche: guicheTotalAtendimento.keySet()){
			double percentual = (guicheTotalAtendimento.get(guiche) + 0.0) / totalAtendimentos;
			String stringPercentual = formataPorcentagem(percentual);
			mapa.put(guiche, stringPercentual);
		}
		return mapa;
	}
	
	/**
	 * Determina um mapeamento das classes para o percentual de atendimentos por classe.
	 * @return Mapa de percentual de atendimentos.
	 */
	public Map<String, String> getClassePercentualAtendimento() {
		Map<String, String> mapa = new HashMap<String, String>();
		for(String classe: classeTotalAtendimento.keySet()){
			int i = classeTotalAtendimento.get(classe);
			double percentual = (classeTotalAtendimento.get(classe)+0.0) / totalAtendimentos;
			String stringPercentual = formataPorcentagem(percentual);
			mapa.put(classe, stringPercentual);
		}
		return mapa;
	}

	/**
	 * Formata a String da porcentagem, utilizando o padr�o dd,d%, onde d
	 * representa um d�gito
	 * 
	 * @param porcentagem
	 *            porcentagem a ser formatada
	 * @return A porcentagem formatada
	 */
	private String formataPorcentagem(double porcentagem) {
		String valor = Double.toString(porcentagem * 100.0) + 0.00000;
		valor = valor.substring(0, valor.indexOf(".") + 3) + "%";
		return valor;
	}

	/**
	 * Altera o mapeamento dos atendentes para o total de atendimentos.
	 * @param atendenteTotalAtendimento Novo mapa atendenteTotalAtendimento.
	 */
	public void setAtendenteTotalAtendimento(
			Map<String, Integer> atendenteTotalAtendimento) {
		this.atendenteTotalAtendimento = atendenteTotalAtendimento;
	}

	/**
	 * Determina um mapeamento das classes para o total de atendimentos.
	 * @return o valor de classeTotalAtendimento.
	 */
	public Map<String, Integer> getClasseTotalAtendimento() {
		return classeTotalAtendimento;
	}

	/**
	 * Altera o mapeamento das classes para o total de atendimentos.
	 * @param classeTotalAtendimento novo mapa de classeTotalAtendimento.
	 */
	public void setClasseTotalAtendimento(
			Map<String, Integer> classeTotalAtendimento) {
		this.classeTotalAtendimento = classeTotalAtendimento;
	}

	/**
	 * Determina a data final do per�odo do resumo.
	 * @return o valor da dataFinal.
	 */
	public String getDataFinal() {
		return dataFinal;
	}

	/**
	 * Altera a data final do per�odo do resumo.
	 * @param dataFinal nova dataFinal.
	 */
	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}

	/**
	 * Determina a data inicial do per�odo do resumo.
	 * @return o valor da dataInicial.
	 */
	public String getDataInicial() {
		return dataInicial;
	}

	/**
	 * Altera a data inicial do per�odo do resumo.
	 * @param dataInicial nova data inicial.
	 */
	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}

	/**
	 * Determina um mapeamento dos guich�s para o total de atendimentos.
	 * @return o valor de guicheTotalAtendimento.
	 */
	public Map<Integer, Integer> getGuicheTotalAtendimento() {
		return guicheTotalAtendimento;
	}

	/**
	 * Altera o mapeamento dos guich�s para o total de atendimentos.
	 * @param guicheTotalAtendimento novo mapa de guicheTotalAtendimento.
	 */
	public void setGuicheTotalAtendimento(
			Map<Integer, Integer> guicheTotalAtendimento) {
		this.guicheTotalAtendimento = guicheTotalAtendimento;
	}

	/**
	 * Determina a m�dia de atendimentos por atendente.
	 * @return o valor de mediaAtendente.
	 */
	public double getMediaAtendente() {
		return mediaAtendente;
	}

	/**
	 * Altera a m�dia de atendimentos por atendente.
	 * @param mediaAtendente novo valor de mediaAtendente.
	 */
	public void setMediaAtendente(double mediaAtendente) {
		this.mediaAtendente = mediaAtendente;
	}

	/**
	 * Determina a m�dia de atendimentos por classe.
	 * @return o valor de mediaClasse.
	 */
	public double getMediaClasse() {
		return mediaClasse;
	}

	/**
	 * Altera a m�dia de atendimentos por classe.
	 * @param mediaClasse novo valor de mediaClasse.
	 */
	public void setMediaClasse(double mediaClasse) {
		this.mediaClasse = mediaClasse;
	}

	/**
	 * Determina a m�dia de atendimentos por guich�.
	 * @return o valor de mediaGuiche.
	 */
	public double getMediaGuiche() {
		return mediaGuiche;
	}

	/**
	 * Altera a m�dia de atendimentos por guich�.
	 * @param mediaGuiche novo valor de mediaGuiche.
	 */
	public void setMediaGuiche(double mediaGuiche) {
		this.mediaGuiche = mediaGuiche;
	}

	/**
	 * Determina o total de atendimentos no resumo.
	 * @return o valor de totalAtendimentos.
	 */
	public int getTotalAtendimentos() {
		return totalAtendimentos;
	}

	/**
	 * Altera o valor do totalAtendimentos no resumo.
	 * @param totalAtendimentos novo valor do total de atendimentos.
	 */
	public void setTotalAtendimentos(int totalAtendimentos) {
		this.totalAtendimentos = totalAtendimentos;
	}
	
	/**
	 * Determina uma String que corresponde ao per�odo do resumo
	 * @return String representando as datas
	 */
	public String getPeriodoResumo(){
		return dataInicial + " � " + dataFinal;
	}
	
	/**
	 * Determina uma String.
	 * @return String que representa o resumo do atendimento.
	 */
	public String toString() {
		return "Resumo de " + getPeriodoResumo() + ", sendo realizados " + getTotalAtendimentos() + " atendimentos";
	}
	
	public static void main(String[] args) {
		try {
			List<DadosAtendimento> l = new DadosAtendimentoDAO().listaDeDadosAtendimento(DataUtil.gerarData("01", "10", "2007"), DataUtil.getDataAtual());
//			ResumoAtendimento ra = new ResumoAtendimento(DataUtil.gerarData("01", "10", "2007"), DataUtil.getDataAtual(), l);
//			System.out.println(ra);
//			System.out.println(ra.getAtendentePercentualAtendimento());
//			System.out.println(ra.getGuichePercentualAtendimento());
//			System.out.println(ra.getClassePercentualAtendimento());
		} catch (NotFoundInDBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @return the tempoMedioAtendimento
	 */
	public double getTempoMedioAtendimento() {
		return tempoMedioAtendimento;
	}

	/**
	 * @param tempoMedioAtendimento the tempoMedioAtendimento to set
	 */
	public void setTempoMedioAtendimento(double tempoMedioAtendimento) {
		this.tempoMedioAtendimento = tempoMedioAtendimento;
	}
	

}
