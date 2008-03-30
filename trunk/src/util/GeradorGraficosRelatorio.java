package util;

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

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import controller.Configuracao;
import database.bean.DadosAvaliacao;

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
 * Classe que implementa o gerador de gráficos para os relatórios
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class GeradorGraficosRelatorio {
	
	private String graficosPath = Configuracao.getPath() + "/admin/images/";
	
	/**
	 * Construtor simples da classe
	 */
	public GeradorGraficosRelatorio() {
		
	}
	
	/**
	 * Metodo responsável por gerar os gráficos
	 * @param dadosAvaliacao
	 */
	public void gerarGraficos(DadosAvaliacao dadosAvaliacao) {
		DefaultPieDataset pieDataset = new DefaultPieDataset();
		//For varrendo as alternativas das questoes
		for(int i =1; i <=5 ; i++){
			pieDataset = createDataSet(dadosAvaliacao.getAlternativas(i));
			geraImagemGrafico(pieDataset, graficosPath + "grafico0" + i + ".jpg", dadosAvaliacao.getQuestao(i));
		}
	}
	
	private void geraImagemGrafico(DefaultPieDataset pieDataset, String graficoPath, String questao) {
		JFreeChart chart = ChartFactory.createPieChart3D(
	            questao,  // chart title
	            pieDataset,             // data
	            true,               // include legend
	            true,
	            false
	        );
        chart.setBorderPaint(Color.black);
		PiePlot plot = (PiePlot) chart.getPlot();
        plot.setSectionOutlinesVisible(false);
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 10));
        plot.setNoDataMessage("No data available");
        plot.setSimpleLabels(true);
        chart.setBackgroundPaint(Color.white);
        
        try {
			ChartUtilities.saveChartAsJPEG(new File(graficoPath), chart, 500, 375);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private DefaultPieDataset createDataSet(String[] alternativas){
		DefaultPieDataset pieDataSet = new DefaultPieDataset();
		int cont =0;
		while(cont < alternativas.length){
			Double porcentagem = new Double(alternativas[cont].substring(0,alternativas[0].length() -1));
			pieDataSet.setValue("alternativa " + (cont + 1)  + " - " + alternativas[cont], porcentagem);
			cont++;
		}
		return pieDataSet;
	}
}



