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

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
 * CCT -  CENTRO DE CIÊNCIA E TECNOLOGIA
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
	 * Método que determina a classe de atendimento.
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
	 * Método que determina o total de atendimentos realizados para a classe deste atendimento
	 * @return o total de atendimentos.
	 */
	public int getTotalAtendidos() {
		return totalAtendidos;
	}
	
	/**
	 * Método que altera o total de atendimentos para a classe deste atendimento.
	 * @param totalAtendidos o novo valor.
	 */
	public void setTotalAtendidos(int totalAtendidos) {
		this.totalAtendidos = totalAtendidos;
	}
	
	/**
	 * Método que determina o total de atendimentos restantes para a classe deste atendimento. 
	 * @return o total de atendimentos restantes.
	 */
	public int getAtendimentosRestantes() {
		return atendimentosRestantes;
	}
	
	/**
	 * Método que altera o total de atendimentos restantes.
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
