package database.bean;

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

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
 * CCT -  CENTRO DE CI�NCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO 1
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES
 */

/**
 * Bean que representa um atendimento.
 * 
 * @author Carlos Trajano
 * @author Hamon Barros
 * @author Rodrigo Lopes
 * 
 * @version 1.0
 */

public class Atendimento implements Comparable<Atendimento>{
	
	private String classeAtendimento;
	private int totalAtendidos;
	private int atendimentosRestantes;
	
	/**
	 * M�todo que determina a classe de atendimento.
	 * @return classe de atendimento.
	 */
	public String getClasseAtendimento() {
		return classeAtendimento;
	}
	
	/**
	 * Altera a classe de atendimento.
	 * @param classeAtendimento O nome da classe de atendimento.
	 */
	public void setClasseAtendimento(String classeAtendimento) {
		this.classeAtendimento = classeAtendimento;
	}
	
	/**
	 * M�todo que determina o total de atendimentos realizados para a classe deste atendimento
	 * @return o total de atendimentos.
	 */
	public int getTotalAtendidos() {
		return totalAtendidos;
	}
	
	/**
	 * M�todo que altera o total de atendimentos para a classe deste atendimento.
	 * @param totalAtendidos o novo valor.
	 */
	public void setTotalAtendidos(int totalAtendidos) {
		this.totalAtendidos = totalAtendidos;
	}
	
	/**
	 * M�todo que determina o total de atendimentos restantes para a classe deste atendimento. 
	 * @return o total de atendimentos restantes.
	 */
	public int getAtendimentosRestantes() {
		return atendimentosRestantes;
	}
	
	/**
	 * M�todo que altera o total de atendimentos restantes.
	 * @param atendimentosRestantes O novo valor do atendimentosRestantes.
	 */
	public void setAtendimentosRestantes(int atendimentosRestantes) {
		this.atendimentosRestantes = atendimentosRestantes;
	}

	/**
	 * Compara o atendimento com outro antedimento.
	 * 
	 * @return inteiro menor que 0 se este atendimento for menor, 0 se forem iguais
	 *         e inteiro maior que 0 se este atendimento for maior
	 */
	public int compareTo(Atendimento o) {
		return classeAtendimento.compareTo(o.classeAtendimento);
	}
	
	@Override
	public String toString() {
		return "classe="+ classeAtendimento + ",atendidos=" + totalAtendidos + ",restantes=" + atendimentosRestantes;
	}

}
