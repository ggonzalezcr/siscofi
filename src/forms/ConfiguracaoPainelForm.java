package forms;

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

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import database.bean.ConfiguradorPainel;

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
 * Classe que representa um Form para criação de novas classes de Configuração
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
	 * Método que define se uma String é vazia ou não
	 * 
	 * @param valor
	 *            String a ser analisada
	 * @return True se for vazia ou false, caso contrário
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
