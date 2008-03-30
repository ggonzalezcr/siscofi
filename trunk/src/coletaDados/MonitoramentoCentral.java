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

import java.text.DecimalFormat;

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
 * Classe que implementa o bean de Monitoramento de Centrais
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class MonitoramentoCentral implements Comparable<MonitoramentoCentral>{
	
	//Atributos de Classe
	private String classeAtendimento;
	private int atendimentos;
	private int senhasASeremAtendidas;
	private double tempoMedioAtendimento;
	private int guichesAtivos;
	
	
	/**
	 * Construtor simples da classe
	 */
	public MonitoramentoCentral(){
		
		atendimentos = 0;
		senhasASeremAtendidas = 0;
		tempoMedioAtendimento = 0.0;
		guichesAtivos = 0;
		classeAtendimento = "";
		
	}

	/**
	 * Metodo que retorna a classe de atendimento do Guichê
	 * @return a classe de atendimento do Guichê
	 */
	public String getClasseAtendimento() {
		return classeAtendimento;
	}

	/**
	 * Metodo que modifica a classe de atendimento do Guichê
	 * @param classeAtendimento a classe de atendimento
	 */
	public void setClasseAtendimento(String classeAtendimento) {
		this.classeAtendimento = classeAtendimento;
	}

	/**
	 * Metodo que retorna o número de atendimentos realizados
	 * por determinada classe de atendimentos
	 * @return o número de atendimentos realizados
	 * por determinada classe de atendimentos
	 */
	public int getAtendimentos() {
		return atendimentos;
	}

	/**
	 * Metodo que modifica o número de atendimentos realizados
	 * por determinada classe de atendimentos
	 * @param atendimentos o número de atendimentos
	 */
	public void setAtendimentos(int atendimentos) {
		this.atendimentos = atendimentos;
	}

	/**
	 * Metodo que retorna o número de senha a ser atendidas
	 * de uma determinada classe de atendimento
	 * @return o número de senha a serem atendidas
	 */
	public int getSenhasASeremAtendidas() {
		return senhasASeremAtendidas;
	}

	/**
	 * Metodo que modifica o número de senha a ser atendidas
	 * de uma determinada classe de atendimento
	 * @param senhasASeremAtendidas o número de senhas a serem
	 * atendidas
	 */
	public void setSenhasASeremAtendidas(int senhasASeremAtendidas) {
		this.senhasASeremAtendidas = senhasASeremAtendidas;
	}

	/**
	 * Metodo que retorna o tempo medio de atendimentos
	 * de uma determina da classe de atendimento
	 * @return o tempo médio de atendimento
	 */
	public double getTempoMedioAtendimento() {
		DecimalFormat aproximador = new DecimalFormat( " 0.00 " );
		return Double.parseDouble(aproximador.format(tempoMedioAtendimento));
	}

	/**
	 * Metodo que modifica o tempo médio de atendimento
	 * de uma determinada classe
	 * @param tempoMedioAtendimento o tempo médio de 
	 * atendimento de uma determinada classe
	 */
	public void setTempoMedioAtendimento(double tempoMedioAtendimento) {
		this.tempoMedioAtendimento = tempoMedioAtendimento;
	}

	/**
	 * Metodo que retorna o número de Guichês ativos
	 * @return o número de guichês ativos
	 */
	public int getGuichesAtivos() {
		return guichesAtivos;
	}

	/**
	 * Metodo que retorna o número de guichês ativos
	 * @param guichesAtivos o número de guichês ativos
	 */
	public void setGuichesAtivos(int guichesAtivos) {
		this.guichesAtivos = guichesAtivos;
	}

	/**
	 * Metodo quem compara dois objetos monitoramentoCentral
	 * @return 0 caso iguais
	 * -1 caso este seja menos
	 * 1 caso este seja maior 
	 */
	public int compareTo(MonitoramentoCentral other) {
		return this.classeAtendimento.compareTo(other.getClasseAtendimento());
	}
}