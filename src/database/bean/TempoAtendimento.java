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
 * 			RODRIGO LOPES DA SILVA
 */

/**
 * Bean que representa o tempo de atendimento.
 * 
 * @author Carlos Trajano
 * @author Hamon Barros
 * @author Rodrigo Lopes da Silva
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
	 * Verifica se o tempoMedio a ser contabilizado est� ou
	 * n�o dentro do desvio padrao
	 * @param contagem A quantidade de atendimentos
	 * @param variacao O fator que determinara o at� quanto
	 * o tempo m�dio deve variar
	 * @param tempoMaximo O menor tempo possivel
	 * @param tempoMinimo O maior tempo possivel
	 * @param tempoFinal O tempo do ultimo atendimento
	 * @return TRUE se o tempo estiver entre o tempoMaximo e o tempoMinimo e dentro da varia��o. Em caso contr�rio, retorna FALSE. 
	 */
	public boolean contabilizaTempos(int contagem, double variacao, double tempoMinimo, 
			double tempoMaximo, long tempoFinal){
		double diferenca = Math.abs((double)(tempoFinal - ultimoTempo)/60000);
		if(diferenca < tempoMinimo)
			return false;
		if(diferenca > tempoMaximo){
			ultimoTempo = tempoFinal;
			return false;
		}

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
	

}
