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
 * Classe com m�todos para manipula��o de datas.
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {

	/**
	 * Determina uma String que representa uma data no formato dd/mm/aaaa. Exemplo: 25/12/2007.
	 * 
	 * @param data
	 *            a data a ser representada como String.
	 * @return String que representa a data.
	 */
	public static String formatarData(Date data) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return simpleDateFormat.format(data);
	}

	/**
	 * Cria um objeto data
	 * 
	 * @param dia O dia da data a ser gerada (01, 02, ..., 31).
	 * @param mes O m�s da data a ser gerada (01, 02, ..., 12).
	 * @param ano O ano da data a ser gerada.
	 * @return Um objeto data correspondente a data da String.
	 */
	public static Date gerarData(String dia, String mes, String ano) {
		Date data = null;
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"dd/MM/yyyy");
			data = simpleDateFormat.parse(dia + "/" + mes + "/" + ano);
		} catch (ParseException e) {
		}
		return data;
	}
	
	/**
	 * Cria um objeto data.
	 * @param date String que representa a data a ser criada.
	 * @return Um objeto data correspondente a data da String.
	 */
	public static Date gerarData(String date) {
		Date data = null;
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"dd/MM/yyyy");
			data = simpleDateFormat.parse(date);
		} catch (ParseException e) {
		}
		return data;
	}

	/**
	 * Determina um data atual do sistema no formato dd/mm/aaaa
	 * 
	 * @return A data atual do sistema.
	 */
	public static Date getDataAtual() {
		Date data;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dataAtual = simpleDateFormat.format(new Date());
		try {
			data = simpleDateFormat.parse(dataAtual);
		} catch (ParseException e) {
			data = new Date();
		}
		return data;
	}

	/**
	 * Determina uma String que representa a data/hora, no formato dd/MM/aaaa
	 * hh:mm:ss, onde dd representa o dia com dois d�gitos, MM o m�s com 02
	 * d�gitos, o ano com 04 d�gitos, hh a hora com dois d�gitos, mm os minutos
	 * com 02 d�gitos, e ss os segundos com 02 d�gitos.
	 * 
	 * @return String representando a data e hora atuais.
	 */
	public static String getDataHoraAtual() {
		Date date = new Date();
		SimpleDateFormat sdate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return sdate.format(date);
	}
	
	/**
	 * Determina um objeto Date que representa a data/hora, no formato dd/MM/aaaa
	 * hh:mm:ss, onde dd representa o dia com dois d�gitos, MM o m�s com 02
	 * d�gitos, o ano com 04 d�gitos, hh a hora com dois d�gitos, mm os minutos
	 * com 02 d�gitos, e ss os segundos com 02 d�gitos.
	 * 
	 * @return String representando a data e hora atuais.
	 */
	public static Date getDataHora() { 
		try {
			Date date = new Date();
			SimpleDateFormat sdate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String dataAtual = sdate.format(date);
			return sdate.parse(dataAtual);
		} catch (ParseException e) {
		}
		return  new Date();
	}

	/**
	 * Determina uma String que representa uma data no formato dd/mm/aaaa hh:mm:ss. Exemplo: 25/12/2007 19:57:52.
	 * 
	 * @param data
	 *            a data a ser representada como String.
	 * @return String que representa a data.
	 */
	public static String formatarDataHora(Date data) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		return simpleDateFormat.format(data);
	}

}
