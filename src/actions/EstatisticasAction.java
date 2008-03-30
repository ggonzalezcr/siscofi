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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import controller.Siscofi;
import forms.EstatisticasForm;


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
 * Classe que implementa a action exibição de estatísticas
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class EstatisticasAction extends DispatchAction{
	

	/**
	 * Método que encaminha para a pagina de administracao
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um forward para a pagina de administracao
	 * @throws Exception
	 */
	public ActionForward voltar(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return map.findForward("voltar");
	}
	
	/**
	 * Encaminha para a página de estatísticas do atendimento 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Forward para a página de estatísticas.
	 * @throws Exception
	 */
	public ActionForward encaminhaEstat(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		Siscofi siscofi = Siscofi.getInstance();
		try {
			request.setAttribute("atendimentos", siscofi.getAtendimentos());
		} catch (ServletException e) {
			request.setAttribute("mensagem", "Há um problema com a conexão do banco de dados!");
			return map.findForward("erro");
		}
		return map.findForward("encaminhaEstat");
	}
	
	
	/**
	 * Método que encaminha para a pagina de administracao de estatisticas
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um forward para a pagina de administracao
	 * @throws Exception
	 */
	public ActionForward adminEstatisticas(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return map.findForward("encaminhaAdminEstat");
	}

	/**
	 * Método que encaminha para a pagina de ajuste de parâmetros
	 * das estatisticas de atendimento
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um forward para a pagina de administracao
	 * @throws Exception
	 */
	public ActionForward configEstatAtendimento(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		EstatisticasForm ef = ((EstatisticasForm) form);
		Siscofi siscofi = Siscofi.getInstance();
		int variacao = (int)(siscofi.getVariacao() * 100);
		ef.setVariacao(variacao);
		ef.setTempoMaximoAtendimento(siscofi.getTempoMaximo());
		ef.setTempoMinimoAtendimento(siscofi.getTempoMinimo());
		
		return map.findForward("encaminhaEstatAtendimento");
	}
	
	/**
	 * Método que encaminha para a pagina de ajuste de parâmetros
	 * das estatisticas de atendimento
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um forward para a pagina de administracao
	 * @throws Exception
	 */
	public ActionForward salvarAlteracoes(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		EstatisticasForm ef = ((EstatisticasForm) form);
		int variacao = (int)ef.getVariacao();
		double tempoMinimo = ef.getTempoMinimoAtendimento();
		double tempoMaximo = ef.getTempoMaximoAtendimento();
		double variacaoAux = (double)variacao/100;
		Siscofi siscofi = Siscofi.getInstance();
		siscofi.setVariacao(variacaoAux);
		siscofi.setTempoMaximo(tempoMaximo);
		siscofi.setTempoMinimo(tempoMinimo);
		ef.setVariacao(variacao);
		ef.setTempoMaximoAtendimento(tempoMaximo);
		ef.setTempoMinimoAtendimento(tempoMinimo);
		
		return map.findForward("encaminhaEstatAtendimento");
	}

	/**
	 * Metodo que encaminha para a pagina de entrada de parametros 
	 * do pré-atendimento
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um forward para a pagina de entrada de parametros do 
	 * pré-atendimento
	 * @throws Exception
	 */
	public ActionForward configEstatPreAtendimento(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Siscofi siscofi = Siscofi.getInstance();
		double fluxoChegada = siscofi.getFluxoChegada();
		EstatisticasForm ef = ((EstatisticasForm) form);
		ef.setFluxoChegada(fluxoChegada);
		return map.findForward("encaminhaEstatPreAtendimento");
	}
	
	/**
	 * Metodo que salva os parametros de pre-atendimento
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um forward para a pagina de entrada de parametros de 
	 * pre-atendimento exibindo a mensagem de sucesso ou fracasso ao
	 * salvar
	 * @throws Exception
	 */
	public ActionForward salvaParamPreAtendimento(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		EstatisticasForm ef = ((EstatisticasForm) form);
		double fluxoChegada = ef.getFluxoChegada();
		Siscofi siscofi = Siscofi.getInstance();
		
		try{
			siscofi.setFluxoChegada(fluxoChegada);
		}catch (Exception e) {
			request.setAttribute("mensagem", "O parâmetro não foi salvo!");
			return map.findForward("encaminhaEstatPreAtendimento");
		}
		
		request.setAttribute("mensagem", "Parâmetro salvo com sucesso!");
		ef.setFluxoChegada(fluxoChegada);
		return map.findForward("encaminhaEstatPreAtendimento");
		
	}
}
