package util;

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
 * CCT -  CENTRO DE CIï¿½NCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO 1
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES
 */

/**
 * Classe que implementa a data a ser gravada no 
 * banco de dados na geração das estatísticas.
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes
 * 
 * @version 1.0
 */
public class MinhaData implements Comparable<MinhaData>{
	
	// Atributos
	private int dia;
	private int mes;
	private int ano;
	
	/**
	 * Construtos
	 * @param dia O dia
	 * @param mes O mes
	 * @param ano O ano
	 */
	public MinhaData(int dia, int mes, int ano){
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int compareTo(MinhaData outraData) {
		if(this.ano < outraData.ano)
			return -1;
		else if(this.ano > outraData.ano)
			return 1;
		else{
			if(this.mes < outraData.mes)
				return -1;
			else if(this.mes > outraData.mes)
				return 1;
			else{
				if(this.dia <outraData.dia)
					return -1;
				else if(this.dia > outraData.dia)
					return 1;
			}
		}
		return 0;
	}
	
}
