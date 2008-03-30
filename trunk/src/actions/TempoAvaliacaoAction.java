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
 *
 * Você deve ter recebido uma cópia da Licença Pública Geral GNU
 * junto com este programa, se não, escreva para a Fundação do Software
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
 * CCT -  CENTRO DE CIÊNCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO II
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES DA SILVA
 */

/**
 * Classe que implementa a action Tempo de Avaliação.
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class TempoAvaliacaoAction {
	
	/**
	 * Salva os dados atuais sobre tempo medio das avaliações
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um forward para a página de teste novamente
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
	 * Salva os dados atuais sobre o tempo medio de avaliação
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um forward para a página de teste novamente
	 * @throws Exception
	 */
	public ActionForward encaminharDadosTempoMedioAvaliacao(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return map.findForward("encaminhar");
	}
	
	/**
	 * Método responsável voltar para a página principal da coleta de dados
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um ActionForward encaminhado para a página
	 *         "coletaDados.jsp"
	 * @throws Exception
	 */
	public ActionForward coletaDados(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return map.findForward("coletaDados");
	}
	
	/**
	 * Método responsável voltar para a página principal
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um ActionForward encaminhado para a página
	 *         "index.jsp"
	 * @throws Exception
	 */
	public ActionForward voltar(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return map.findForward("voltar");
	}
}
