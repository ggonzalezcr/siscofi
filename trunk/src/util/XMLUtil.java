package util;

import java.awt.Color;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

import controleChamada.Aviso;
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
 * Classe utilitária que manipula XML.
 * 
 * @author Carlos
 * @author Hamon Barros
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 * 
 */

public class XMLUtil<E> {
	
//	Define o número máximo de tentativas para gravar o arquivo xml
	private static final int TOTAL_TENTATIVAS = 10000;


	/**
	 * Grava um objeto em XML.
	 * 
	 * @param obj
	 *            Objeto a se gravado.
	 * @param filename
	 *            nome do arquivo XML.
	 * @throws FileNotFoundException
	 *             Lançada se o arquivo não puder ser criado ou escrito.
	 */
	public void writeXML(E obj, String filename) throws FileNotFoundException {
		XMLEncoder xmle = new XMLEncoder(new FileOutputStream(
				new File(filename)));
		xmle.writeObject(obj);
		xmle.flush();
		xmle.close();
	}

	/**
	 * Lê um Objeto gravado em XML.
	 * 
	 * @param filename
	 *            nome do arquivo XML.
	 * @return O objeto gravado no XML.
	 * @throws FileNotFoundException
	 *             Lançada se o arquivo não puder ser lido.
	 */
	public E readXML(String filename) throws FileNotFoundException {
		XMLDecoder xmld = new XMLDecoder(
				new FileInputStream(new File(filename)));
		return (E) xmld.readObject();
	}

	
	/**
	 * Metodo que gera um arquivo XML para ler lido pelo painel
	 * 
	 * @param controles os controles
	 * @param aviso o aviso
	 * @param filename o arquivo
	 * @return true caso gere com sucesso e false caso contrário
	 */
	public static boolean geradorXMLPainel(ConcurrentLinkedQueue<Controle> controles, Aviso aviso, String filename){
		Element painel = new Element("painel"); 
		Element config = new Element("config");
		Element classes = new Element("classes");
		Element chamada = new Element("chamada");
		Element mensage = new Element("mensagens");
		config.setAttribute("refreshTime", Integer.toString(Configuracao.getRefreshTime()));
		config.setAttribute("intervalMensagem", Integer.toString(Configuracao.getInterval()*1000));
		config.setAttribute("clock", Integer.toString(Configuracao.getShowClock()));
		config.setAttribute("repeat", Integer.toString(Configuracao.getRepeat()));
		config.setAttribute("bgColor", Configuracao.getbgColor());
		config.setAttribute("posicao", Configuracao.getClockPosition());
		config.setAttribute("nomeAplicacao", Configuracao.getNomeAplicacao());
		config.setAttribute("speed", Integer.toString(Configuracao.getSpeed()));
		config.setAttribute("tempoExibicao", Integer.toString(Configuracao.getWarningTime()*1000));
		config.setAttribute("destacarUltimaSenha", Integer.toString(Configuracao.getDestacarUltimaSenha()));
		config.setAttribute("exibirFundo", Integer.toString(Configuracao.getExibirFundo()));
		painel.addContent(config);
		for(Controle control: controles){
			Element classe = new Element("classe");
			classe.setAttribute("guiche", control.getUltimoGuiche());
			classe.setAttribute("senha", control.getSenha());
			classe.setAttribute("cor", control.getCor());
			classes.addContent(classe);
		}
		painel.addContent(classes);
	
		chamada.setAttribute("guiche", aviso.getGuiche());
		chamada.setAttribute("avisar", aviso.getAvisar());
		chamada.setAttribute("cor", aviso.getCor());
		chamada.setAttribute("senha", aviso.getSenha());	
		painel.addContent(chamada);
		Element mensagem = new Element("mensagem");
		mensagem.setAttribute("texto", Configuracao.getMensagem());
		mensagem.setAttribute("cor", Configuracao.getCorMensagem());
		mensage.addContent(mensagem);
		painel.addContent(mensage);

		Document doc = new Document();
		XMLOutputter xmlo = new XMLOutputter();
		doc.setRootElement(painel);
		
		int contador = 0;
		boolean gravou = false;
		while((contador < TOTAL_TENTATIVAS) && (gravou == false) ){
			try {
				xmlo.output(doc, new FileOutputStream(new File(filename)));
				gravou = true;
			} catch (Exception e) {
				contador++;
				gravou = false;
			}
		}
		return true;
	}

}
