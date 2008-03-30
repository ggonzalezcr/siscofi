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

import java.io.FileNotFoundException;

import controller.Configuracao;

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
 * CCT -  CENTRO DE CIÊNCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO II
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES DA SILVA
 */

/**
 * Classe responsável por gerenciar as mensagens exibidas no painel.
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

@Deprecated
public class GerenciadorMensagem {
	
	
	//Atributos de classe
	private Mensagem _mensagem = new  Mensagem();
	private String filename;

	
	/**
	 * Construtor simples da classe.
	 */
	public GerenciadorMensagem() {
		filename = Configuracao.getPath() + "/mensagens.xml";
	}

	/**
	 * Metodo que retorna a mensagem
	 * @return a mensagem
	 */
	public Mensagem getMensagem() {
		_mensagem = leMensagem();
		return _mensagem;
	}

	/**
	 * Meotodo que modifica a mensagem
	 * @param mensagem a nova mensagem
	 */
	public void addMensagem(Mensagem mensagem) {
		_mensagem = mensagem;
		gravaMensagem();
	} 

	private void gravaMensagem(){
		XMLUtil<Mensagem> xmlUtil = new XMLUtil<Mensagem>();
		try {
			xmlUtil.writeXML(_mensagem, filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private Mensagem leMensagem(){
		XMLUtil<Mensagem> xmlUtil = new XMLUtil<Mensagem>();
		try {
			_mensagem = (Mensagem) xmlUtil.readXML(filename);
		} catch (FileNotFoundException e) {
		}
		return _mensagem;
	}
	
}
