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

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

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
 * Classe que representa um cor.
 * 
 * @author Carlos Trajano
 * @author Hamon Barros
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 * 
 */

public class Cor implements Comparable<Cor>{
	
	//Mapa que relaciona o nome de uma cor ao valor hexadecimal no sistema RGB.
	private static Map<String, String> mapaCor;
	//Mapa que relaciona o valor hexadecimal no sistema RGB ao nome de uma cor.
	private static Map<String, String> mapaValor;
	//Valor da cor em hexadecimal no sistema RGB. 
	private String valorCor;
	//Nome da cor
	private String nomeCor;
	
	/**
	 * Cria uma nova cor
	 * @param nomeCor Nome da cor.
	 * @param valorCor valor da cor.
	 */
	public Cor(String nomeCor, String valorCor) {
		this.nomeCor = nomeCor;
		this.valorCor = valorCor;
	}
	
	/**
	 * Cria uma nova cor.
	 */
	public Cor(){
	}
	
	/**
	 * Armazena nos mapas todas as cores disponiveis
	 */
	static {
		mapaCor = new TreeMap<String, String>();
		mapaValor = new TreeMap<String, String>();
		mapaCor.put("VERMELHO1", "FF0000");
		mapaValor.put("FF0000", "VERMELHO1");
		mapaCor.put("OLIVA", "808000");
		mapaValor.put("808000", "OLIVA");
		mapaCor.put("VERMELHO2", "990000");
		mapaValor.put("990000", "VERMELHO2");
		mapaCor.put("VERMELHO3", "FA8072");
		mapaValor.put("FA8072", "VERMELHO3");
		mapaCor.put("VERMELHO4", "FF6347");
		mapaValor.put("FF6347", "VERMELHO4");
		mapaCor.put("VERMELHO5", "8B0000");
		mapaValor.put("8B0000", "VERMELHO5");
		mapaCor.put("VERDE1", "00FF00");
		mapaValor.put("00FF00", "VERDE1");
		mapaCor.put("VERDE2", "009900");
		mapaValor.put("009900", "VERDE2");
		mapaCor.put("VERDE3", "008080");
		mapaValor.put("008080", "VERDE3");
		mapaCor.put("VERDE4", "70DB93");
		mapaValor.put("70DB93", "VERDE4");
		mapaCor.put("VERDE5", "4A766E");
		mapaValor.put("4A766E", "VERDE5");
		mapaCor.put("AZUL1", "0000FF");
		mapaValor.put("0000FF", "AZUL1");
		mapaCor.put("AZUL2", "000099");
		mapaValor.put("000099", "AZUL2");
		mapaCor.put("AZUL3", "7093DB");
		mapaValor.put("7093DB", "AZUL3");
		mapaCor.put("AZUL4", "23238E");
		mapaValor.put("23238E", "AZUL4");
		mapaCor.put("AMARELO1", "FFFF00");
		mapaValor.put("FFFF00", "AMARELO1");
		mapaCor.put("AMARELO2", "999900");
		mapaValor.put("999900", "AMARELO2");
		mapaCor.put("AMARELO3", "B5A642");
		mapaValor.put("B5A642", "AMARELO3");
		mapaCor.put("AMARELO4", "EAEAAE");
		mapaValor.put("EAEAAE", "AMARELO4");
		mapaCor.put("BRANCO", "FFFFFF");
		mapaValor.put("000000", "BRANCO");
		mapaCor.put("PRETO", "000000");
		mapaValor.put("FFFFFF", "PRETO");
		mapaCor.put("CINZA1", "999999");
		mapaValor.put("999999", "CINZA1");
		mapaCor.put("CINZA2", "CCCCCC");
		mapaValor.put("CCCCCC", "CINZA2");
		mapaCor.put("CINZA3", "C0C0C0");
		mapaValor.put("C0C0C0", "CINZA3");
		mapaCor.put("CINZA4", "EEE9E9");
		mapaValor.put("EEE9E9", "CINZA4");
		mapaCor.put("CIANO", "00FFFF");
		mapaValor.put("00FFFF", "CIANO");
		mapaCor.put("MARROM1", "996633");
		mapaValor.put("996633", "MARROM1");
		mapaCor.put("MARROM2", "6B4723");
		mapaValor.put("6B4723", "MARROM2");
		mapaCor.put("MARROM3", "EBC79E");
		mapaValor.put("EBC79E", "MARROM3");
		mapaCor.put("LARANJA1", "FF9900");
		mapaValor.put("FF9900", "LARANJA1");
		mapaCor.put("LARANJA2", "B86E00");
		mapaValor.put("B86E00", "LARANJA2");
		mapaCor.put("MARGENTA", "FF00FF");
		mapaValor.put("FF00FF", "MARGENTA");
	}
	
	/**
	 * Determina o valor relacionado a um nome de cor. 
	 * @param nomeCor Nome da cor.
	 * @return O Valor da cor correspondente ao nome passado como parâmetro.
	 */
	public static String NomeValorCor(String nomeCor){
		return mapaCor.get(nomeCor.toUpperCase());
	}
	
	/**
	 * Determina o nome relacionado ao valor de uma cor.
	 * @param valorCor O valor da cor.
	 * @return Nome correspondente ao valor da cor passado como parâmetro.
	 */
	public static String ValorNomeCor(String valorCor){
		return mapaValor.get(valorCor.toUpperCase());
	}
	
	/**
	 * Determina um conjunto contendo os nomes de todas as cores disponníveis no sistema.
	 * @return Retorno um Set de cores disponníveis no sistema.
	 */
	public static Set<Cor> getCoresDisponiveis(){
		Set<Cor> cores = new TreeSet<Cor>();
		for(String cor: mapaCor.keySet()){
			String valor = mapaCor.get(cor); 
			cores.add(new Cor(cor, valor));
		}
		return cores;
	}

	/**
	 * Determina o nome da cor.
	 * @return o nome da cor
	 */
	public String getNomeCor() {
		return nomeCor;
	}

	/**
	 * Altera o nome da cor.
	 * @param nomeCor O novo nome da cor.
	 */
	public void setNomeCor(String nomeCor) {
		this.nomeCor = nomeCor;
	}

	/**
	 * Determina o valor em hexadecimal da cor no sistema RGB.
	 * @return O valor da cor.
	 */
	public String getValorCor() {
		return valorCor;
	}

	/**
	 * Altera o valor da cor.
	 * @param valorCor Novo valor da cor em hexadecimal no sistema RGB.
	 */
	public void setValorCor(String valorCor) {
		this.valorCor = valorCor;
	}
	
	/**
	 * Compara o valor da cor com outra cor.
	 * 
	 */
	public int compareTo(Cor outraCor) {
		return nomeCor.compareTo(outraCor.getNomeCor());
	}
		
}
