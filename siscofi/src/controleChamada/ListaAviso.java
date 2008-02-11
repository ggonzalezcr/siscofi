package controleChamada;

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
 *
 * Você deve ter recebido uma cópia da Licença Pública Geral GNU
 * junto com este programa, se não, escreva para a Fundação do Software
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
 * CCT -  CENTRO DE CIÊNCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO 1
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES
 */

/**
 * Implementação de uma pilha de tarefas de aviso. Os objetos desta classe são
 * responsável pelo controle de aviso.
 * 
 * @author Carlos Trajano
 * @author Hamon Barros
 * @author Rodrigo Lopes
 * 
 * @version 1.1
 * 
 */

public class ListaAviso {

	/**
	 * Lista com os próximos avisos
	 */
	private List<Aviso> avisos;
	private String ultimaSenha = "";

	/**
	 * Cria uma nova lista de avisos
	 * 
	 */
	public ListaAviso() {
		avisos = Collections.synchronizedList(new ArrayList<Aviso>());
	}

	/**
	 * Geração de um arquivo com o aviso do topo da pilha.
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
	 *            informação do guiche.
	 * @param senha
	 *            Senha a ser chamada.
	 * @param cor a cor que o aviso deve ter ao aparecer no painel
	 * @throws ServletException 
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
	 * Metodo que verifica se a PilhaAviso está vazio.
	 * 
	 * @return true caso verdadeiro e false caso contrario.
	 */
	public boolean isEmpty() {
		return avisos.isEmpty();
	}

	/**
	 * Determina o total de avisos que estão no momento.
	 * 
	 * @return O total de avisos no sistema.
	 */
	public int getTotalAvisos() {
		return avisos.size();
	}

	/**
	 * Encerra o aviso da chamada atual, porque este já foi iniciado.
	 * @param ultimaSenhaChamada a ultima senha chamada
	 * @throws ServletException 
	 * 
	 */
	public void chamadaIniciada(String ultimaSenhaChamada) throws ServletException {
		System.out.println("============================>" + avisos);
		removerSenha(ultimaSenhaChamada);
		if (avisos.size() > 0) {
			// Gera o proximo aviso
			Aviso aviso = avisos.get(0);
			ultimaSenha = ultimaSenhaChamada;
			aviso.setAvisar(Aviso.AVISAR);
			gerarXml(aviso);
		} else {
			pararChamadas();
		}

	}

	/**
	 * Método que remove um aviso da lista de avisos, se este aviso for o último
	 * aviso emitido. O último aviso emitido sempre será o de menor índice.
	 * 
	 * @param ultimaSenhaChamada
	 *            Valor da última senha chamada.
	 */
	private void removerSenha(String ultimaSenhaChamada) {
		if (avisos.size() > 0) {
			Aviso aviso = avisos.get(0);
			System.out.println("==========================>remover senha = " + ultimaSenhaChamada);
			if (aviso.getSenha().equals(ultimaSenhaChamada)) {
				avisos.remove(0);
			}
		}
	}

	/**
	 * Encerra o aviso da chamada atual
	 * @throws ServletException 
	 */
	public void pararChamadas() throws ServletException {
		Aviso aviso = new Aviso();
		aviso.setAvisar("");
		aviso.setCor("");
		aviso.setGuiche("");
		aviso.setSenha(ultimaSenha);
		aviso.setAvisar(Aviso.NAO_AVISAR);
//		System.out.println(aviso.getAvisar());
		gerarXml(aviso);
	}
}