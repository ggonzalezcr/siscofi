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
 *
 * Voc� deve ter recebido uma c�pia da Licen�a P�blica Geral GNU
 * junto com este programa, se n�o, escreva para a Funda��o do Software
 * Livre(FSF) Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA
 *
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import controller.Siscofi;
import forms.TempoAvaliacaoForm;

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
 * CCT -  CENTRO DE CI�NCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO II
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES DA SILVA
 */

/**
 * Classe que implementa a action Tempo de Avalia��o.
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class TempoAvaliacaoAction {
	
	/**
	 * Salva os dados atuais sobre tempo medio das avalia��es
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um forward para a p�gina de teste novamente
	 * @throws Exception
	 */
	public ActionForward salvarDadosTempoMedioAvaliacao(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Siscofi siscofi = Siscofi.getInstance();
		TempoAvaliacaoForm tma = ((TempoAvaliacaoForm)form);
		siscofi.salvarDadosTempoAvaliacao(tma.getTempoAvaliacao());
		request.setAttribute("mensagem", "Dados salvos com sucesso");
		return map.findForward("salvo");
	}
	
	/**
	 * Salva os dados atuais sobre o tempo medio de avalia��o
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um forward para a p�gina de teste novamente
	 * @throws Exception
	 */
	public ActionForward encaminharDadosTempoMedioAvaliacao(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return map.findForward("encaminhar");
	}
	
	/**
	 * M�todo respons�vel voltar para a p�gina principal da coleta de dados
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um ActionForward encaminhado para a p�gina
	 *         "coletaDados.jsp"
	 * @throws Exception
	 */
	public ActionForward coletaDados(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return map.findForward("coletaDados");
	}
	
	/**
	 * M�todo respons�vel voltar para a p�gina principal
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um ActionForward encaminhado para a p�gina
	 *         "index.jsp"
	 * @throws Exception
	 */
	public ActionForward voltar(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return map.findForward("voltar");
	}
}
