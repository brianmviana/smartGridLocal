package br.qxd.smartgrid.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.qxd.smartgrid.model.Usuario;
import br.qxd.smartgrid.service.UsuarioService;

@Controller
public class RoutingController {
	
	@Autowired
	private UsuarioService userSvc;
	
	@RequestMapping(value = "/login",  method = { RequestMethod.GET, RequestMethod.POST })
	public String login(){
		return "/login";
	}
//	sessão, ta com bug
//	@RequestMapping(value = "/login",  method = { RequestMethod.GET, RequestMethod.POST })
//	public String login(HttpServletRequest request, HttpSession session){
//		String login = request.getUserPrincipal().getName();
//		//Buscar usuario pelo login
//		Usuario usr = userSvc.findByLogin(login);
//		if (usr == null)
//			//Tratar se tiver nulo
//
//		session.setAttribute("user_logged", usr);
//		return "/login";
//	}
	
	@RequestMapping(value={"/create_address"})
	public String create_address(){
		return "login/create_address";
	}
	@RequestMapping(value={"/home"})
	public String home(){
		return "tabs/home";
	}
	@RequestMapping(value={"/notification"})
	public String notification(){
		return "tabs/notification";
	}
	@RequestMapping(value={"/account"})
	public String account(){
		return "tabs/account";
	}
}
