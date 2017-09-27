package br.qxd.smartgrid.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.qxd.smartgrid.model.Registro;
import br.qxd.smartgrid.repository.RegistroRepository;

@Controller()
public class RegistroController {
	
	@Autowired
	private RegistroRepository regRepository;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = { "/consumo/get","/search" }, method = RequestMethod.GET)
	public String getConsumo() {
		return "tabs/search";
	}
	
	@RequestMapping(value = { "/consumo/get", }, method = RequestMethod.POST)
	public String buscarConsumo(HttpServletRequest request, Model model) {

		try {
			String inicio = request.getParameter("inicio");
			String fim = request.getParameter("fim");
			SimpleDateFormat formatOriginal = new SimpleDateFormat("yyyy-MM-dd");
			Date dataIni = formatOriginal.parse(inicio);
			Date dataFim = formatOriginal.parse(fim);
			//log.info(dataIni.toString() + " " + dataFim.toString());
			List<Registro> regs = regRepository.findByDataBetween(dataIni, dataFim);
			float total=0;
			for (Registro registro : regs) {
				total += registro.getTotalWatts();
			}
			model.addAttribute("total", total);
			model.addAttribute("listaConsumo", regs);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "tabs/search";
	}
}
