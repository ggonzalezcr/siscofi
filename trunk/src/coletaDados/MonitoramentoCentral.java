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

import java.text.DecimalFormat;

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
	 * Metodo que retorna a classe de atendimento do Guich�
	 * @return a classe de atendimento do Guich�
	 */
	public String getClasseAtendimento() {
		return classeAtendimento;
	}

	/**
	 * Metodo que modifica a classe de atendimento do Guich�
	 * @param classeAtendimento a classe de atendimento
	 */
	public void setClasseAtendimento(String classeAtendimento) {
		this.classeAtendimento = classeAtendimento;
	}

	/**
	 * Metodo que retorna o n�mero de atendimentos realizados
	 * por determinada classe de atendimentos
	 * @return o n�mero de atendimentos realizados
	 * por determinada classe de atendimentos
	 */
	public int getAtendimentos() {
		return atendimentos;
	}

	/**
	 * Metodo que modifica o n�mero de atendimentos realizados
	 * por determinada classe de atendimentos
	 * @param atendimentos o n�mero de atendimentos
	 */
	public void setAtendimentos(int atendimentos) {
		this.atendimentos = atendimentos;
	}

	/**
	 * Metodo que retorna o n�mero de senha a ser atendidas
	 * de uma determinada classe de atendimento
	 * @return o n�mero de senha a serem atendidas
	 */
	public int getSenhasASeremAtendidas() {
		return senhasASeremAtendidas;
	}

	/**
	 * Metodo que modifica o n�mero de senha a ser atendidas
	 * de uma determinada classe de atendimento
	 * @param senhasASeremAtendidas o n�mero de senhas a serem
	 * atendidas
	 */
	public void setSenhasASeremAtendidas(int senhasASeremAtendidas) {
		this.senhasASeremAtendidas = senhasASeremAtendidas;
	}

	/**
	 * Metodo que retorna o tempo medio de atendimentos
	 * de uma determina da classe de atendimento
	 * @return o tempo m�dio de atendimento
	 */
	public double getTempoMedioAtendimento() {
		DecimalFormat aproximador = new DecimalFormat( " 0.00 " );
		return Double.parseDouble(aproximador.format(tempoMedioAtendimento));
	}

	/**
	 * Metodo que modifica o tempo m�dio de atendimento
	 * de uma determinada classe
	 * @param tempoMedioAtendimento o tempo m�dio de 
	 * atendimento de uma determinada classe
	 */
	public void setTempoMedioAtendimento(double tempoMedioAtendimento) {
		this.tempoMedioAtendimento = tempoMedioAtendimento;
	}

	/**
	 * Metodo que retorna o n�mero de Guich�s ativos
	 * @return o n�mero de guich�s ativos
	 */
	public int getGuichesAtivos() {
		return guichesAtivos;
	}

	/**
	 * Metodo que retorna o n�mero de guich�s ativos
	 * @param guichesAtivos o n�mero de guich�s ativos
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