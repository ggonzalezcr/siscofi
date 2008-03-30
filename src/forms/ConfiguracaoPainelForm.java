package forms;

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

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import database.bean.ConfiguradorPainel;

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
 * Classe que representa um Form para cria��o de novas classes de Configura��o
 * do painel
 * 
 * @author Carlos Trajano
 * @author Hamon Barros
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class ConfiguracaoPainelForm  extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private ConfiguradorPainel confPainel = new ConfiguradorPainel();


	/**
	 * Metodo que retonra um configurador de painel
	 * @return um configurador de painel
	 */
	public ConfiguradorPainel getConfPainel() {
		return confPainel;
	}


	/**
	 * Metodo que modifica o configurador de painel.
	 * @param confPainel o configurador de painel
	 */
	public void setConfPainel(ConfiguradorPainel confPainel) {
		this.confPainel = confPainel;
	}
	
	/**
	 * M�todo que define se uma String � vazia ou n�o
	 * 
	 * @param valor
	 *            String a ser analisada
	 * @return True se for vazia ou false, caso contr�rio
	 */
	private boolean stringVazia(String valor) {
		return valor == null || valor.trim().length() == 0;
	}

	public ActionErrors validate(ActionMapping map, HttpServletRequest req) {
		ActionErrors erros = new ActionErrors();
		// verifica a cor de fundo do painel
		if (stringVazia(confPainel.getBgColor())) {
			erros.add("nome da classe", new ActionMessage("erro.classe"));
		}
		// verifica o texto da mensagem
		if (stringVazia(confPainel.getMensagem().toString())) {
			erros.add("cor", new ActionMessage("erro.mensagem"));
		}
		// verifica a cor da mensagem
		if (stringVazia(confPainel.getCorMensagem().toString())) {
			erros.add("prefixo", new ActionMessage("erro.corMensagem"));
		}
		// verifica o numero de repeticoes da mensagem
		if (stringVazia(confPainel.getRepeat() + "")) {
			erros.add("QuantidadeInicial", new ActionMessage(
					"erro.QuantidadeInicial"));
		}
		return erros;
	}
	
}
