package actions;

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
 * CCT -  CENTRO DE CIÊNCIA E TECNOLOGIA
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
	 * carregando na mesma as configurações atuais ou se não tiverem
	 * sido modificadas as configurações default do sistema.
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
	 * Metodo que Salva as configurações setadas pelo usuário e encaminha
	 * para uma pagina inicial de configuração.
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Forward salvar a configuração.
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
		request.setAttribute("mensagem", "Alterações salvas com sucesso!");
		return map.findForward("salvar");
	}
	
	/**
	 * Metodo que encaminha para a pagina inicial de administração não
	 * salvando as configurações alteradas.
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
	 * Metodo que restaura as configurações defaults do Sistema
	 * @param map 
	 * @param form
	 * @param request
	 * @param response
	 * @return Forward para restaurar a avaliação.
	 * @throws Exception
	 */
	public ActionForward restaurarDefalt(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		Set<Cor> cores = Cor.getCoresDisponiveis();
		request.setAttribute("cores", cores);
		ConfiguradorPainel.setConfiguradorDefalt();
		request.setAttribute("mensagem", "Configurações Restauradas com sucesso");
		ConfiguracaoPainelForm formulario = ((ConfiguracaoPainelForm) form);
		ConfiguradorPainel confiPainel = ConfiguradorPainel.getConfigurador();
		formulario.setConfPainel(confiPainel);
		return map.findForward("restaurar");
	}
}
