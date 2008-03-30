package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import database.bean.Guiche;

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
 * Objetos desta classe manipulam os guichês logados no sistema.
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class GerenciadorGuiches {
	
	//Mapeamento do guichês para os seus respectivos dados (atendente, classe e ip)
	private Map<String, Guiche> guiches;
	//Mapeamento da classe de atendimento para os guichês das classes	
	private Map<String, List<String>> classesGuiches; 
	
	public GerenciadorGuiches() {
		guiches = new HashMap<String, Guiche>();
		classesGuiches = new HashMap<String, List<String>>();
	}
	
	/**
	 * Adiciona um guichê ao gerenciador de guichês.
	 * 
	 * @param guiche
	 *            guichê a ser atualizado.
	 * @param ip O ip do guichê.
	 * @param classe O classe no qual o guichê foi logado.            
	 * @param atendente o atendente logado no guichê.
	 */
	public void addGuiche(String ip, String guiche, String classe, String atendente) {
		if(guiches.containsKey(guiche)){
			Guiche loginAnterior = guiches.get(guiche);
			List<String> classeAntiga = classesGuiches.get(loginAnterior.getClasse());
			classeAntiga.remove(guiche);
		}
		guiches.put(guiche, new Guiche(ip, atendente, classe, guiche));
		List<String> tmp;
		if(classesGuiches.containsKey(classe)){
			tmp = classesGuiches.get(classe);
		} else{
			tmp = new ArrayList<String>();
		}
		tmp.add(guiche);
		classesGuiches.put(classe, tmp);
	}
	
	/**
	 * Determina qual atendente está logado em um guichê.
	 * 
	 * @param guiche
	 *            Guichê a ser consultado.
	 * @return O login do atendente no guichê.
	 */
	public String getAtendente(String guiche) {
		String atendente = "";
		Guiche gui = guiches.get(guiche);
		if(gui != null){
			atendente = gui.getAtendente();
		}
		return atendente;
	}
	
	/**
	 * Verifica se já existe um numero de guiche cadastrado
	 * 
	 * @param guiche
	 *            O numero do guiche a ser verificado
	 * @return True se houver ou False, caso contrario
	 */
	public boolean contemGuiche(String guiche) {
		return guiches.containsKey(guiche);
	}
	
	/**
	 * Verifica se um IP está cadastrado.
	 * 
	 * @param ip
	 *            IP a ser atualizado.
	 * @return True se o ip existir no sistema e False em caso contrário.
	 */
	public boolean contemIP(String ip) {
		boolean contemIP = false;
		for(String g: guiches.keySet()){
			Guiche gui = guiches.get(g);
			if(gui.getIp().equals(ip))
				contemIP = true;
		}
		return contemIP;
	}
	
	/**
	 * Determina se um guichê está em atividade no sistema
	 * 
	 * @return retorna o guichê com o IP fornecido. Caso o guichê não exista no sistema, retorna uma string vazia.
	 */
	public String getGuiche(String ip) {
		String guiche = "";
		for(String g: guiches.keySet()){
			Guiche gui = guiches.get(g);
			if(gui.getIp().equals(ip))
				guiche = g;
		}
		return guiche;
	}
	
	/**
	 * Retorna o ip de um guiche
	 * 
	 * @param guiche
	 *            O guiche que se quer recuperar o ip
	 * @return O ip de um guiche
	 */
	public String getIp(String guiche) {
		String ip = "";
		if(guiches.containsKey(guiche)){
			Guiche tmp = guiches.get(guiche);
			ip = tmp.getIp();
		}
		return ip;
	}
	
	/**
	 * Remove um guichê do gerenciador de guichês.
	 * 
	 * @param ip O IP do guichê a ser removido.
	 */
	public void removeGuiche(String ip) {
		try {
			String guiche = getGuiche(ip);
			String classeAntiga = guiches.get(guiche).getClasse();
			guiches.remove(guiche);
			List<String> listaClasse = classesGuiches.get(classeAntiga);
			if(listaClasse != null){
				//remove da classe antiga
				listaClasse.remove(guiche);
				classesGuiches.put(classeAntiga, listaClasse);
			}
		} catch (Exception e) {
		}
	}
	
	/**
	 * Altera a classe a qual o guichê está atendendo. 
	 * @param ip O ip do guichê a ser alterado.
	 * @param classe A nova classe a qual o atendente irá atender.
	 */
	public void alterarClasse(String ip, String classe) {
		String guiche = getGuiche(ip);
		Guiche guich = guiches.get(guiche);
		if(guich != null){
			String classeAntiga = guich.getClasse();
			guich.setClasse(classe);
			List<String> listaClasseAntiga = classesGuiches.get(classeAntiga);
			if(listaClasseAntiga != null){
				//remove da classe antiga
				listaClasseAntiga.remove(guiche);
				classesGuiches.put(classeAntiga, listaClasseAntiga);
			}
			//atualiza na nova classe
			List<String> listaClasseNova;
			if(classesGuiches.containsKey(classe)){
				listaClasseNova = classesGuiches.get(classe);
			} else{
				listaClasseNova = new ArrayList<String>();
			}
			listaClasseNova.add(guiche);
			classesGuiches.put(classe, listaClasseNova);
		}
	}
	
	/**
	 * Determina a classe de atendimento de um guichê.
	 * @param ip O ip do guichê.
	 * @return Retorna a classe de atendimento.
	 */
	public String getClasse(String ip){
		String classe = "";
		for(String g: guiches.keySet()){
			Guiche gui = guiches.get(g);
			if(gui.getIp().equals(ip))
				classe = gui.getClasse();
		}
		return classe;
	}
	
	/**
	 * Retorna o total de guichês numa classe de atendimento.
	 * @return mapa de controle para total de guichês.
	 */
	public int getGuiches(String classe){
		if(classesGuiches.get(classe) == null)
			return 0;
		return classesGuiches.get(classe).size();
	}
	
	/**
	 * Determina os guichês em uma classe de atendimento.
	 * @param classe A classe dos guichês.
	 * @return Listagem de guiches da classe.
	 */
	public List<String> getGuichesClasse(String classe){ 
		List<String> listagem = classesGuiches.get(classe);
		return listagem != null? listagem : new ArrayList<String>();
	}
}

