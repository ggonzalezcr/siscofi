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
 * Classe com métodos para manipulação de datas.
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
	 * @param mes O mês da data a ser gerada (01, 02, ..., 12).
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
	 * hh:mm:ss, onde dd representa o dia com dois dígitos, MM o mês com 02
	 * dígitos, o ano com 04 dígitos, hh a hora com dois dígitos, mm os minutos
	 * com 02 dígitos, e ss os segundos com 02 dígitos.
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
	 * hh:mm:ss, onde dd representa o dia com dois dígitos, MM o mês com 02
	 * dígitos, o ano com 04 dígitos, hh a hora com dois dígitos, mm os minutos
	 * com 02 dígitos, e ss os segundos com 02 dígitos.
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
