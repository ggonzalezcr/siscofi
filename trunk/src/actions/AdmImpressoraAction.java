
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import util.Impressao;
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
 * Classe que implementa a action Administrar Impressora.
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class AdmImpressoraAction extends DispatchAction{
	
	/**
	 * Lista todas as impressoras do sistema e coloca no request
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um forward para a pagina da seleção de impressoras
	 * @throws Exception
	 */
	public ActionForward listaImpressoras(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Impressao impressao = new Impressao();
		request.setAttribute("ListaDeImpressoras", impressao.listaImpressoras());
		return map.findForward("selecionaImpressora");
	}
	
	/**
	 * Pega a impressora selecionada e grava no arquivo de configuração
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um forward para a pagina de teste da impressao
	 * @throws Exception
	 */
	public ActionForward selecionaImpressora(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String nomeImpressora = (String) request.getParameter("impressora");
		Siscofi siscofi = Siscofi.getInstance();
		siscofi.setNomeImpressora(nomeImpressora);
		request.setAttribute("impressora", nomeImpressora);
		return map.findForward("testeDeImpressao");
	}
	
	/**
	 * Imprime uma senha de teste
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um forward para a página de teste novamente
	 * @throws Exception
	 */
	public ActionForward imprimeTeste(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Siscofi siscofi = Siscofi.getInstance();
		siscofi.imprimeTeste();
		request.setAttribute("mensagem", "Verifique se a senha-teste saiu legível!");
		return map.findForward("impressaoTestada");
	}
	
	/**
	 * Método responsável cancelar uma operação
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return Um ActionForward encaminhado para a página
	 *         "administracao.jsp"
	 * @throws Exception
	 */
	public ActionForward voltar(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return map.findForward("voltar");
	}
	
}
