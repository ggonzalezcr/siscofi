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
			request.setAttribute("mensagem","Há um problema com a conexão do banco de dados!");
			return map.findForward("inicializa");			
		}
			if(!inicializou){
				request.setAttribute("mensagem", "O sistema ainda não foi finalizado.");
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
				request.setAttribute("mensagem", "O sistema ainda não foi inicializado.");
			} else {
				request.setAttribute("mensagem", "O sistema foi finalizado com sucesso.");
			}
		} catch (ServletException e) {
			request.setAttribute("mensagem","Há um problema com a conexão do banco de dados!");
			return map.findForward("finaliza");
		}
		return map.findForward("finaliza");
	}
	
	/**
	 * Volta para página principal do sistema.
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Forward para retornar a página anterior.
	 * @throws Exception
	 */
	public ActionForward voltar(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return map.findForward("voltar");
	}
}
