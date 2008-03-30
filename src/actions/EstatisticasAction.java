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
 * CCT -  CENTRO DE CI�NCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO 1
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES DA SILVA
 */

/**
 * Classe que implementa a action exibi��o de estat�sticas
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class EstatisticasAction extends DispatchAction{
	

	/**
	 * M�todo que encaminha para a pagina de administracao
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
	 * Encaminha para a p�gina de estat�sticas do atendimento 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Forward para a p�gina de estat�sticas.
	 * @throws Exception
	 */
	public ActionForward encaminhaEstat(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		Siscofi siscofi = Siscofi.getInstance();
		try {
			request.setAttribute("atendimentos", siscofi.getAtendimentos());
		} catch (ServletException e) {
			request.setAttribute("mensagem", "H� um problema com a conex�o do banco de dados!");
			return map.findForward("erro");
		}
		return map.findForward("encaminhaEstat");
	}
	
	
	/**
	 * M�todo que encaminha para a pagina de administracao de estatisticas
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
	 * M�todo que encaminha para a pagina de ajuste de par�metros
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
	 * M�todo que encaminha para a pagina de ajuste de par�metros
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
	 * do pr�-atendimento
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um forward para a pagina de entrada de parametros do 
	 * pr�-atendimento
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
			request.setAttribute("mensagem", "O par�metro n�o foi salvo!");
			return map.findForward("encaminhaEstatPreAtendimento");
		}
		
		request.setAttribute("mensagem", "Par�metro salvo com sucesso!");
		ef.setFluxoChegada(fluxoChegada);
		return map.findForward("encaminhaEstatPreAtendimento");
		
	}
}
