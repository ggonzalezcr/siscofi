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
 * Classe que implementa a action que inicia e finaliza o Sistema.
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class StartFinishAction extends DispatchAction{
	
	/**
	 * Metodo que inicializa o sistema.
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Forward para inicializar o atendimento.
	 * @throws Exception
	 */
	public ActionForward inicializa(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		Siscofi siscofi = Siscofi.getInstance();
		boolean inicializou = false;
		try {
			inicializou = siscofi.inicializaSistema();
		} catch (ServletException e) {
			request.setAttribute("mensagem","H� um problema com a conex�o do banco de dados!");
			return map.findForward("inicializa");			
		}
			if(!inicializou){
				request.setAttribute("mensagem", "O sistema ainda n�o foi finalizado.");
			} else{
				request.setAttribute("mensagem", "O sistema foi inicializado com sucesso.");
			}
		
		return map.findForward("inicializa");
	}
	
	/**
	 * Metodo que finaliza o Sistema.
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Forward para finalizar o atendimento.
	 * @throws Exception
	 */
	public ActionForward finaliza(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		Siscofi siscofi = Siscofi.getInstance();
		try {
			if(!siscofi.finalizaSistema()){
				request.setAttribute("mensagem", "O sistema ainda n�o foi inicializado.");
			} else {
				request.setAttribute("mensagem", "O sistema foi finalizado com sucesso.");
			}
		} catch (ServletException e) {
			request.setAttribute("mensagem","H� um problema com a conex�o do banco de dados!");
			return map.findForward("finaliza");
		}
		return map.findForward("finaliza");
	}
	
	/**
	 * Volta para p�gina principal do sistema.
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Forward para retornar a p�gina anterior.
	 * @throws Exception
	 */
	public ActionForward voltar(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return map.findForward("voltar");
	}
}
