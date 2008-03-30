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

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import util.DataUtil;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;

import controller.Siscofi;
import database.bean.DadosAvaliacao;
import estatisticas.atendimento.ResumoAtendimento;

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
 * Classe que implementa a action de Geração dos relatórios.
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */
public class RelatorioAction extends DispatchAction{
	
	/**
	 * Encaminha para a pagina de geracao dos relatorios
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um forward para a pagina de geracao dos relatorios
	 * @throws Exception
	 */
	public ActionForward encaminhaRelatorios(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		return map.findForward("encaminha");
	}

	/**
	 * Encaminha para a pagina de geracao do relatorio de avaliacao
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return um forward para a pagina de geracao do relatorio de avaliacao
	 * @throws Exception
	 */
	public ActionForward encaminhaRelatorioAvaliacao(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		
		return map.findForward("encaminhaAvaliacao");
	}
	
	/**
	 * Gera um pdf contendo o relatorio das estatísticas da avaliação do
	 * atendimento ao eleitor
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um forward para um pdf que contem as estatísticas da avaliação do
	 * atendimento ao eleitor
	 * @throws Exception
	 */
	public ActionForward gerarRelatorioAvaliacao(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		Date dataInicial = DataUtil.gerarData(request.getParameter("diaInicial"), request.getParameter("mesInicial"), request.getParameter("anoInicial"));
		
		Date dataFinal = DataUtil.gerarData(request.getParameter("diaFinal"), request.getParameter("mesFinal"), request.getParameter("anoFinal"));

		Siscofi siscofi = Siscofi.getInstance();
		Document pdf = null;
		try{
			pdf = siscofi.gerarRelatorioAvaliacao(dataInicial, dataFinal);
			if(pdf == null){
				request.setAttribute("mensagem", "Não há nenhuma avaliação entre essas datas!");
				return map.findForward("encaminhaAvaliacao");							
			}
		}catch(Exception e){
			request.setAttribute("mensagem", e.getMessage());
			return map.findForward("encaminhaAvaliacao");			
		}
		PdfWriter.getInstance(pdf, response.getOutputStream());
		return map.findForward("avaliacao");
	}
	
	/**
	 * Encaminha para uma página contendo o relátorio de atendimentos realizados
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return um Forward para a página de relatório de atendimentos.
	 * @throws Exception
	 */
	public ActionForward encaminhaRelatorioAtendimento(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		
		return map.findForward("encaminhaAtendimento");
	}
	
	/**
	 * Metodo que gera um relatório dos atendimentos realizados
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return um Forward para o relatório de atendimento.
	 * @throws Exception
	 */
	public ActionForward gerarRelatorioAtendimento(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		
		Date dataInicial = DataUtil.gerarData(request.getParameter("diaInicial"), request.getParameter("mesInicial"), request.getParameter("anoInicial"));
		
		Date dataFinal = DataUtil.gerarData(request.getParameter("diaFinal"), request.getParameter("mesFinal"), request.getParameter("anoFinal"));

		Siscofi siscofi = Siscofi.getInstance();
		Document pdf = null;
		try{
			pdf = siscofi.gerarRelatorioAtendimento(dataInicial, dataFinal);
			if(pdf == null){
				request.setAttribute("mensagem", "Não há nenhuma avaliação entre essas datas!");
				return map.findForward("encaminhaAtendimento");							
			}
		}catch(Exception e){
			request.setAttribute("mensagem", e.getMessage());
			return map.findForward("encaminhaAvaliacao");			
		}
		PdfWriter.getInstance(pdf, response.getOutputStream());
		return map.findForward("atendimento");
		
	}

	/**
	 * Método responsável por voltar para a pagina anterior
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um ActionForward encaminhado para a página
	 *         "formularios.jsp"
	 * @throws Exception
	 */
	public ActionForward voltar(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return map.findForward("voltar");
	}

	/**
	 * Método responsável por voltar para a pagina anterior
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um ActionForward encaminhado para a página
	 *         "administracao.jsp"
	 * @throws Exception
	 */
	public ActionForward voltarAdmin(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return map.findForward("voltarAdmin");
	}
	
	/**
	 * Método por encaminhar para a página de relatórios.
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um ActionForward encaminhado para a página
	 *         "administracao.jsp"
	 * @throws Exception
	 */
	public ActionForward resultadosAvaliacao(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Date dataInicial = DataUtil.gerarData(request.getParameter("diaInicial"), request.getParameter("mesInicial"), request.getParameter("anoInicial"));
		Date dataFinal = DataUtil.gerarData(request.getParameter("diaFinal"), request.getParameter("mesFinal"), request.getParameter("anoFinal"));
		Siscofi siscofi = Siscofi.getInstance();
		DadosAvaliacao est = siscofi.gerarResultadoAvaliacao(dataInicial, dataFinal);
		if(est == null){
			request.setAttribute("mensagem", "Não há nenhuma avaliação entre " + DataUtil.formatarData(dataInicial) + " e " + DataUtil.formatarData(dataFinal) + ".");
			return map.findForward("encaminhaAvaliacao");							
		}
		siscofi.GerarGraficosRelatorio(est);
		request.setAttribute("dados", est);
		return map.findForward("resultadosAvaliacao");
	}
		
	/**
	 * Metodo responsável por gerar um relatório contendo informações sobre os atendimentos realizados
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return um Forward para a página de resultados de atendimento.
	 * @throws Exception
	 */
	public ActionForward resultadosAtendimento(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Date dataInicial = DataUtil.gerarData(request.getParameter("diaInicial"), request.getParameter("mesInicial"), request.getParameter("anoInicial"));
		Date dataFinal = DataUtil.gerarData(request.getParameter("diaFinal"), request.getParameter("mesFinal"), request.getParameter("anoFinal"));
		Siscofi siscofi = Siscofi.getInstance();
		//Não está gerando relatório ainda.
		ResumoAtendimento est = siscofi.gerarResultadoAtendimento(dataInicial, dataFinal);
		if(est == null){
			request.setAttribute("mensagem", "Não há nenhuma avaliação entre " + DataUtil.formatarData(dataInicial) + " e " + DataUtil.formatarData(dataFinal) + ".");
			return map.findForward("encaminhaAtendimento");							
		}
		siscofi.GerarGraficosRelatorioAtendimentos(est);
		request.setAttribute("dados", est);
		return map.findForward("resultadosAtendimentos");
	}
	
}
