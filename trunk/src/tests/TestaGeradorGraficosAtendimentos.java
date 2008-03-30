package tests;

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

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.jfree.data.general.DefaultPieDataset;

import util.DataUtil;
import util.GeradorGraficosAtendimentos;
import estatisticas.atendimento.DadosAtendimento;
import estatisticas.atendimento.ResumoAtendimento;

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE CCT - CENTRO DE CIÊNCIA E
 * TECNOLOGIA DSC - DEPARTAMENTO DE SISTEMAS E COMPUTACAO DISCIPLINA - PROJETO 1
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS ALUNOS: CARLOS TRAJANO DE
 * OLIVEIRA HAMON BARROS HENRIQUES RODRIGO LOPES
 */

/**
 * Classe que testa a classe GeradorGraficosAtendimento
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */
public class TestaGeradorGraficosAtendimentos extends TestCase {

	private GeradorGraficosAtendimentos gerador;

	public TestaGeradorGraficosAtendimentos(String name) {
		super(name);
	}

	protected void setUp() {
		gerador = new GeradorGraficosAtendimentos();
	}

	/**
	 * Metodo que retorna uma suite de teste para a classe
	 * TestaGeradorGraficosAtendimentos
	 * 
	 * @return uma suite de teste.
	 */
	public static Test suite() {
		return new TestSuite(TestaGeradorGraficosAtendimentos.class);
	}

	public void testGerarGraficos() {
		try {
			DadosAtendimento dados = new DadosAtendimento();

			Map<String, Integer> atendenteXporcentagem = new HashMap<String, Integer>();
			atendenteXporcentagem.put("atendente1", 10);
			atendenteXporcentagem.put("atendente2", 10);
			dados.setTotalAtendimentos(20);
			dados.setAtendenteAtendimentos(atendenteXporcentagem);

			Map<String, Integer> classeXatendimentos = new HashMap<String, Integer>();
			classeXatendimentos.put("2via", 15);
			classeXatendimentos.put("especial", 5);
			dados.setClasseAtendimentos(classeXatendimentos);

			Map<Integer, Integer> guicheXatendimentos = new HashMap<Integer, Integer>();
			guicheXatendimentos.put(01, 5);
			guicheXatendimentos.put(02, 7);
			guicheXatendimentos.put(03, 4);
			guicheXatendimentos.put(04, 4);
			dados.setGuicheAtendimentos(guicheXatendimentos);

			DefaultPieDataset pieDataSet = new DefaultPieDataset();
			List<DadosAtendimento> lista = new ArrayList<DadosAtendimento>();
			lista.add(dados);
			ResumoAtendimento resumo = new ResumoAtendimento(DataUtil
					.formatarData(new Date("2007/25/01")), DataUtil
					.formatarData(new Date("2007/25/01")), lista);
			gerador.gerarGraficos(resumo);
		} catch (Exception e) {
			fail("Não foi possivel gerar os gráficos");
		}
	}
}
