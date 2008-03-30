package controleChamada;

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
 *
 * Voc� deve ter recebido uma c�pia da Licen�a P�blica Geral GNU
 * junto com este programa, se n�o, escreva para a Funda��o do Software
 * Livre(FSF) Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA
 *
 * Copyright 2007, 2008 Carlos Trajano de Oliveira, Hamon Barros Henriques, Rodrigo Lopes da Silva
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;

import controller.Siscofi;

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
 * Implementa��o de uma pilha de tarefas de aviso. Os objetos desta classe s�o
 * respons�vel pelo controle de aviso.
 * 
 * @author Carlos Trajano
 * @author Hamon Barros
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.1
 * 
 */

public class ListaAviso {

	/**
	 * Lista com os pr�ximos avisos
	 */
	private List<Aviso> avisos;
	private String ultimaSenha = "";

	/**
	 * Determina a �ltima senha que teve um aviso emitido. 
	 * @return o valor da ultima senha.
	 */
	public String getUltimaSenha() {
		return ultimaSenha;
	}

	/**
	 * Cria uma nova lista de avisos
	 * 
	 */
	public ListaAviso() {
		avisos = Collections.synchronizedList(new ArrayList<Aviso>());
	}

	/**
	 * Gera��o de um arquivo com o aviso do topo da pilha.
	 * 
	 * @param aviso
	 *            Aviso a ser colocado na pilha.
	 * @throws ServletException 
	 */
	private void gerarXml(Aviso aviso) throws ServletException {
		Siscofi siscofi = Siscofi.getInstance();
		siscofi.gerarXMLFlash(aviso);
	}

	/**
	 * Adiciona um novo aviso para a pilha.
	 * 
	 * @param guiche
	 *            informa��o do guiche.
	 * @param senha
	 *            Senha a ser chamada.
	 * @param cor a cor que o aviso deve ter ao aparecer no painel.
	 * @throws ServletException Lan�ada se n�o for poss�vel realizar os avisos da lista.
	 */
	public void addAviso(String guiche, String senha, String cor) throws ServletException {
		Aviso aviso1 = new Aviso();
		aviso1.setGuiche(guiche);
		aviso1.setSenha(senha);
		aviso1.setAvisar(Aviso.AVISAR);
		aviso1.setCor(cor);
		avisos.add(aviso1);
		if (avisos.size() == 1) {
			gerarXml(aviso1);
		}
	}

	/**
	 * Metodo que verifica se a lista est� vazia.
	 * 
	 * @return true caso verdadeiro e false caso contrario.
	 */
	public boolean isEmpty() {
		return avisos.isEmpty();
	}

	/**
	 * Determina o total de avisos que a serem emitidos.
	 * 
	 * @return O total de avisos no sistema.
	 */
	public int getTotalAvisos() {
		return avisos.size();
	}

	/**
	 * Encerra o aviso da chamada atual, porque este j� foi iniciado.
	 * @param ultimaSenhaChamada a ultima senha chamada
	 * @throws ServletException 
	 * 
	 */
	public void chamadaIniciada(String ultimaSenhaChamada) throws ServletException {
		removerSenha(ultimaSenhaChamada);
		ultimaSenha = ultimaSenhaChamada;
		if (avisos.size() > 0) {
			// Gera o proximo aviso
			Aviso aviso = avisos.get(0);
			aviso.setAvisar(Aviso.AVISAR);
			gerarXml(aviso);
		} else {
			pararChamadas();
		}

	}

	/**
	 * M�todo que remove um aviso da lista de avisos, se este aviso for o �ltimo
	 * aviso emitido. O �ltimo aviso emitido sempre ser� o de menor �ndice.
	 * 
	 * @param ultimaSenhaChamada
	 *            Valor da �ltima senha chamada.
	 */
	private void removerSenha(String ultimaSenhaChamada) {
		if (avisos.size() > 0) {
			Aviso aviso = avisos.get(0);
			if (aviso.getSenha().equals(ultimaSenhaChamada)) {
				avisos.remove(0);
			}
		}
	}

	/**
	 * Encerra o aviso da chamada atual, removendo todos os avisos.
	 * @throws ServletException Lan�ada se n�o for poss�vel gravar no diret�rio raiz da aplica��o.
	 */
	public void pararChamadas() throws ServletException {
		Aviso aviso = new Aviso();
		aviso.setAvisar("");
		aviso.setCor("");
		aviso.setGuiche("");
		aviso.setSenha(ultimaSenha);
		aviso.setAvisar(Aviso.NAO_AVISAR);
		avisos.clear();
		gerarXml(aviso);
	}
}