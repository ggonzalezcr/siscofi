package util;

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

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.Rotation;

import controller.Configuracao;
import database.bean.DadosAvaliacao;

public class GeradorGraficosRelatorio {
	
	private String graficosPath = Configuracao.getPath() + "/admin/images/";
	
	public GeradorGraficosRelatorio() {
		
	}
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

	public static void main(String[] args) {
		GeradorGraficosRelatorio ger = new GeradorGraficosRelatorio();
//		Siscofi si = Siscofi.getInstance();
		DadosAvaliacao dados = new DadosAvaliacao();
		String[] alternativas = new String[5];
		alternativas[0]  = "20.00%";
		alternativas[1]  = "10.00%";
		alternativas[2]  = "30.00%";
		alternativas[3]  = "35.00%";
		alternativas[4]  = "50.00%";
		dados.setAlternativas1(alternativas);
		dados.setAlternativas2(alternativas);
		dados.setAlternativas3(alternativas);
		dados.setAlternativas4(alternativas);
		dados.setAlternativas5(alternativas);
		dados.setQuestao1("Questao1");
		dados.setQuestao2("Questao2");
		dados.setQuestao3("Questao3");
		dados.setQuestao4("Questao4");
		dados.setQuestao5("Questao5");
		ger.gerarGraficos(dados);
		System.out.println("<---- gerou com sucesso ---->");
	}
}



