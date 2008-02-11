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
 * Bean que representa o tempo de atendimento.
 * 
 * @author Carlos Trajano
 * @author Hamon Barros
 * @author Rodrigo Lopes
 * 
 * @version 1.0
 */
public class TempoAtendimento {
	//Atributos
	private long ultimoTempo = 0;
	private double tempoMedio = 0;
	
	/**
	 * Retorna o tempo medio de atendimento
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
	 * Recupera o ultimo tempo gravado
	 * @return O ultimo tempo gravado
	 */
	public long getUltimoTempo() {
		return ultimoTempo;
	}
	/**
	 * Altera o ultimo tempo gravado
	 * @param ultimoTempo O novo tempo a ser gravado
	 */
	public void setUltimoTempo(long ultimoTempo) {
		this.ultimoTempo = ultimoTempo;
	}
	
	/**
	 * Verifica se o tempoMedio a ser contabilizado está ou
	 * não dentro do desvio padrao
	 * @param contagem A quantidade de atendimentos
	 * @param variacao O fator que determinara o até quanto
	 * o tempo médio deve variar
	 * @param tempoMaximo O menor tempo possivel
	 * @param tempoMinimo O maior tempo possivel
	 * @param tempoFinal O tempo do ultimo atendimento
	 * @param quantidadeAtendimentos A quantidade de atendimentos
	 */
	public boolean contabilizaTempos(int contagem, double variacao, double tempoMinimo, 
			double tempoMaximo, long tempoFinal){
		double diferenca = Math.abs((double)(tempoFinal - ultimoTempo)/60000);
		if(diferenca < tempoMinimo || diferenca > tempoMaximo)
			return false;

		if(tempoMedio == 0){
			tempoMedio = diferenca;
			setUltimoTempo(tempoFinal);
		}
		else if(diferenca >= tempoMedio * variacao && 
					diferenca <= tempoMedio/variacao){
			tempoMedio = (tempoMedio * contagem + diferenca)/(contagem + 1);
			setUltimoTempo(tempoFinal);
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		long a = System.currentTimeMillis();
		System.out.println(a);
		int k;
		for(int i=0; i <=10000000; i++)
			for(int j=0; j <=10000; j++)
			k = 0;
		long b = System.currentTimeMillis();
		System.out.println(b);
		System.out.println((double)((b - a)/60000));
	}
}
