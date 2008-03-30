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
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.JobName;
import javax.print.attribute.standard.OrientationRequested;

import controller.Configuracao;
import database.bean.Controle;

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
 * Classe que imprime as senhas
 */
public class Impressao implements Printable {
	private String[] texto;
	private BufferedImage bi;
	
	//Define o tamanho máximo de caracteres que podem ser utilizados na área impressa da senha
	private final int MAX_LENGTH = 34;

	
	/**
	 * Construtor da classe Impressao
	 */
	public Impressao() {
		
	}

	/**
	 * Método que imprime um texto passado como parametro
	 * @param texto Texto a ser impresso
	 */
	public void imprime(String[] texto) {
		this.texto = texto;

		PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
		aset.add(OrientationRequested.PORTRAIT);
		aset.add(new Copies(1));
		aset.add(new JobName("Senha", null));
		
		// Cria um "Printer job"
		PrinterJob pj = PrinterJob.getPrinterJob();
		pj.setPrintable(this);

		String nomeDaImpressora = Configuracao.getNomeDaImpressora();
		PrintService impressora = getImpressora(nomeDaImpressora);
		
		try {
			pj.setPrintService(impressora);
			pj.print(aset);
		} catch (PrinterException pe) {
			System.err.println(pe);
		}
	} 


	/**
	 * Método necessário quando a interface de diálogo é implementada.
	 */
	public int print(Graphics g, PageFormat pf, int pageIndex) {
		if (pageIndex == 0) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.translate(pf.getImageableX(), pf.getImageableY());
			g2d.setColor(Color.black);
			
			// Imprime o texto passado, na coluna 200 e na linha 340
			// da página a ser impressa
			g2d.drawImage(desenhaSenha(), 0, 0, null);
			return Printable.PAGE_EXISTS;
		} else {
			return Printable.NO_SUCH_PAGE;
		}
	}
	
	/**
	 * Método que desenha a senha que será impressa
	 * @return Uma imagem representando a senha que será impressa
	 */
	private Image desenhaSenha() {
		BufferedImage i = new BufferedImage(260, 260, BufferedImage.TRANSLUCENT);
		Graphics graphics = i.getGraphics();
		graphics.setColor(Color.BLACK);
//		graphics.drawRect(0, 0, 259, 259);
		graphics.setFont(new Font("Times new Roman", Font.LAYOUT_LEFT_TO_RIGHT, 9));
		graphics.drawString(centraliza(texto[0]), 10, 25);
		graphics.drawString(centraliza(texto[1]), 10, 50);
		graphics.drawString(centraliza(texto[2]), 10, 75);
		graphics.setFont(new Font("Times new Roman", Font.BOLD, 22));
		graphics.drawString("  " + texto[3], 10, 115);
		graphics.setFont(new Font("Times new Roman", Font.LAYOUT_LEFT_TO_RIGHT, 9));
		graphics.drawString(centraliza(texto[4]), 10, 155);
		bi = i;
		return i;
	}


	private String centraliza(String texto) {
		int total = Math.round((MAX_LENGTH - texto.length()));
		String retorno = "";
		for(int c = 0; c< total; c++){
			retorno += " ";
		}
		return retorno + texto;
	}

	/**
	 * Método que imprime quantas senhas desejadar
	 * @param quantidade Quantidade de senhas a serem impressas
	 * @param tipoGuiche O tipo de guichê cujas senhas serão impressas
	 * @param controle o controle da impressao.
	 */
	public Controle setPrint(int quantidade, String tipoGuiche, Controle controle) {
		for(int i =1; i<= quantidade; i++){
			controle.setQuantidade(controle.getQuantidade() + 1);
			Senha senha = new Senha(tipoGuiche,controle.senhaASerImpressa());
			//Senha senha = new Senha(tipoGuiche,controle.getSenha());
			this.imprime(senha.getStrings());
		}
		return controle;
	} 

	/**
	 * Lista todas as impressoras disponíveis
	 * @return Um lista de todas as impressoras disponiveis
	 */
	public List<String> listaImpressoras(){
		
		List<String> impressoras = new ArrayList<String>();
        DocFlavor df = DocFlavor.SERVICE_FORMATTED.PRINTABLE;
        PrintService[] ps = PrintServiceLookup.lookupPrintServices(df, null);
        
        for (PrintService p: ps) {         
        	impressoras.add(p.getName());

        }		
        return impressoras;
	}
	
	/**
	 * Recupera uma impressora que foi selecionada dentre a lista
	 * de impressoras 
	 * @param nomeImpressora O nome da impressora a ser recuperado
	 * @return  Uma impressora
	 */
	private PrintService getImpressora(String nomeImpressora){
		PrintService impressora = null;
		DocFlavor df = DocFlavor.SERVICE_FORMATTED.PRINTABLE;
        PrintService[] ps = PrintServiceLookup.lookupPrintServices(df, null);
        
        for (PrintService p: ps) {         
        	if(p.getName().equals(nomeImpressora)){
        		impressora = p;
        		break;
        	}
        }		
		return impressora;
	}

}