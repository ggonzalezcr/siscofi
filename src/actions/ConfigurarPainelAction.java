package actions;

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

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import util.Cor;
import database.bean.ConfiguradorPainel;
import forms.ConfiguracaoPainelForm;

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
 * Classe que implementa a action Cofigurar Painel.
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class ConfigurarPainelAction extends DispatchAction{
	
	/**
	 * Metodo que encaminha para a pagina de configuracao do painel,
	 * carregando na mesma as configura��es atuais ou se n�o tiverem
	 * sido modificadas as configura��es default do sistema.
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return a pagina para qual sera redirecionado.
	 * @throws Exception
	 */	
	public ActionForward encaminhaConfi(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		ConfiguracaoPainelForm formulario = ((ConfiguracaoPainelForm) form);
		Set<Cor> cores = Cor.getCoresDisponiveis();
		request.setAttribute("cores", cores);
		ConfiguradorPainel confiPainel = ConfiguradorPainel.getConfigurador();
		formulario.setConfPainel(confiPainel);
		return map.findForward("encaminha");
	}
	
	/**
	 * Metodo que Salva as configura��es setadas pelo usu�rio e encaminha
	 * para uma pagina inicial de configura��o.
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Forward salvar a configura��o.
	 * @throws Exception
	 */
	public ActionForward salvar(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Set<Cor> cores = Cor.getCoresDisponiveis();
		request.setAttribute("cores", cores);
		ConfiguracaoPainelForm formulario = ((ConfiguracaoPainelForm) form);
		ConfiguradorPainel  confPainel = formulario.getConfPainel();
		ConfiguradorPainel.setConfigurador(confPainel);
		request.setAttribute("mensagem", "Altera��es salvas com sucesso!");
		return map.findForward("salvar");
	}
	
	/**
	 * Metodo que encaminha para a pagina inicial de administra��o n�o
	 * salvando as configura��es alteradas.
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Forward para o index.
	 * @throws Exception
	 */
	public ActionForward cancelar(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return map.findForward("cancelar");
	}	

	/**
	 * Metodo que restaura as configura��es defaults do Sistema
	 * @param map 
	 * @param form
	 * @param request
	 * @param response
	 * @return Forward para restaurar a avalia��o.
	 * @throws Exception
	 */
	public ActionForward restaurarDefalt(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		Set<Cor> cores = Cor.getCoresDisponiveis();
		request.setAttribute("cores", cores);
		ConfiguradorPainel.setConfiguradorDefalt();
		request.setAttribute("mensagem", "Configura��es Restauradas com sucesso");
		ConfiguracaoPainelForm formulario = ((ConfiguracaoPainelForm) form);
		ConfiguradorPainel confiPainel = ConfiguradorPainel.getConfigurador();
		formulario.setConfPainel(confiPainel);
		return map.findForward("restaurar");
	}
}
