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
 * CCT -  CENTRO DE CIÊNCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO 1
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES
 */
/**
 * Classe que representa uma mensagem.
 * 
 * @author Carlos Trajano
 * @author Hamon Barros
 * @author Rodrigo Lopes
 * 
 * @version 1.0
 * 
 */

public class Mensagem {

	//texto da mensagem
	private String _texto;
	//valor da cor em hexadecimal no sistema RGB. 
	private String _cor;
	
	/**
	 * Cria uma nova Mensagem.
	 * @param texto Texto da mensagem.
	 * @param cor valor da cor em hexadecimal no sistema RGB.
	 */
	public Mensagem(String texto, String cor){
		_texto = texto;
		_cor = cor;
		
	}
	
	/**
	 * Cria uma nova Mensagem.
	 */
	public Mensagem(){		
	}
	
	/**
	 * Determina o texto da mensagem.
	 * @return Texto da mensagem.
	 */
	public String getTexto() {
		return _texto;
	}
	
	/**
	 * Altera o texto da mensagem.
	 * @param texto Novo texto da mensagem. 
	 */
	public void setTexto(String texto) {
		this._texto = texto;
	}
	
	/**
	 * Determina a cor da mensagem.
	 * @return valor da cor em hexadecimal, no sistema RGB. 
	 */
	public String getCor() {
		return _cor;
	}
	
	/**
	 * Altera o valor da cor. 
	 * @param cor Novo valor da cor. O valor deve estar em RGB no sistema hexadecimal.
	 */
	public void setCor(String cor) {
		this._cor = cor;
	}
	
	/**
	 * Determina um string que representa a cor.
	 * @return o texto da mensagem
	 */
	public String toString(){
		return _texto + " " + _cor;
	}
	
	
}
