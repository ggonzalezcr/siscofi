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

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import coletaDados.DadosMonitoramento;
import coletaDados.MonitoramentoCentral;
import forms.MonitoramentoCentralForm;

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
 * Classe que implementa a action Monitoramento de Centrais Action
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class MonitoramentoCentralAction extends DispatchAction{

	/**
	 * Metodo responsável por retornar uma lista contendo os 
	 * dados de cada central monitorada.
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return um Forward para página que lista dados de monitoramento.
	 * @throws Exception
	 */
	public ActionForward listaDadosMonitoramento(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int atendimentos = Integer.parseInt( request.getParameter("atendimentos"));
		int senhas = Integer.parseInt(request.getParameter("senhas"));
		int tempoMedio = Integer.parseInt(request.getParameter("tempoMedio"));
		int guichesAtivos = Integer.parseInt(request.getParameter("guichesAtivos"));
		
		MonitoramentoCentralForm formulario = ((MonitoramentoCentralForm) form);
		DadosMonitoramento dadosMonitoramento = formulario.getMonitoramento();
		
		List<MonitoramentoCentral> dados = dadosMonitoramento.getDadosMonitoramento();
		Collections.sort(dados);
		//representa 0 ou 1
		request.getSession().setAttribute("monit", dados);
		request.getSession().setAttribute("totais", dadosMonitoramento);
		request.setAttribute("atendimentos", atendimentos);
		request.setAttribute("senhas", senhas);
		request.setAttribute("tempoMedio", tempoMedio);
		request.setAttribute("guichesAtivos", guichesAtivos);
		return map.findForward("monitoramento");
	}
		
}
