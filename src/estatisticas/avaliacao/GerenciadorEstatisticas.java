package estatisticas.avaliacao;

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
 * Copyright 2007, 2008 Carlos Trajano de Oliveira, Hamon Barros Henriques, Rodrigo Lopes da Silva
 */

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
 * CCT -  CENTRO DE CIÊNCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO 2
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES DA SILVA
 */

/**
 * Classe responsável por geração de estatísticas.
 * 
 * @author Carlos Trajano
 * @author Hamon Barros
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.1
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import database.AvaliacaoDAO;
import database.EstatisticasDAO;
import database.bean.Avaliacao;
import exceptions.NotFoundInDBException;

public class GerenciadorEstatisticas {

	/**
	 * Gera estatísticas de todas as avaliações constantes no banco de dados e
	 * armazena as estatísticas no banco de dados. As <b>avaliações analisadas serão removidas do banco de dados</b>.
	 * 
	 */
	public void gerarEstatisticasAvaliacao() {
		AvaliacaoDAO avDAO = new AvaliacaoDAO();
		EstatisticasDAO esDAO = new EstatisticasDAO();
		Estatisticas est = new Estatisticas();

		List<Avaliacao> listaAvaliacao = new ArrayList<Avaliacao>();
		try {
			listaAvaliacao = avDAO.listaDeAvaliacoes(new Date());
			est.geraEstatistica(listaAvaliacao);
			avDAO.removeAvaliacoes(listaAvaliacao);
			esDAO.writeEstatistica(est);
		} catch (NotFoundInDBException e) {
			e.printStackTrace();
		}
	}
}
