package cat.xtec.ioc.Proccontrol.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Classe que controla les sol·licituts del navegador web rel·lacionades amb
 * el menú general de l'aplicació
 * 
 * @author JoseAndrade
 * @version 1.0
 * @since 1.0
 */

@Controller
public class HomeController {

	/**
	 * 
	 * Vincula URL / amb vista index
	 */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ModelAndView modelview = new ModelAndView("index");
        modelview.getModelMap().addAttribute("benvinguda", "Una app de Minipa");
        return modelview;
    }

	/**
	 * 
	 * Vincula URL /edicio amb vista menuEdicio, i ha de tenir rol de ADMIN
	 */
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/edicio", method = RequestMethod.GET)
    public ModelAndView menuEdicio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ModelAndView modelview = new ModelAndView("menuEdicio");
        modelview.getModelMap().addAttribute("benvinguda", "Menú d'edició");
        return modelview;
    }

	/**
	 * 
	 * Vincula URL /usersmenu amb vista menuUsuaris, i ha de tenir rol de ADMIN
	 */
    @RequestMapping(value = "/usersmenu", method = RequestMethod.GET)
    public ModelAndView menuUsuaris(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ModelAndView modelview = new ModelAndView("menuUsuaris");
        modelview.getModelMap().addAttribute("benvinguda", "Menú usuaris");
        return modelview;
    }

	/**
	 * 
	 * Vincula URL /secciomenu amb vista menuSeccions, i ha de tenir rol de ADMIN
	 */
    @RequestMapping(value = "/secciomenu", method = RequestMethod.GET)
    public ModelAndView menuSeccions(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ModelAndView modelview = new ModelAndView("menuSeccions");
        modelview.getModelMap().addAttribute("benvinguda", "Menú seccions");
        return modelview;
    }

	/**
	 * 
	 * Vincula URL /instalaciomenu amb vista menuInstalacions, i ha de tenir rol de ADMIN
	 */
    @RequestMapping(value = "/insalaciomenu", method = RequestMethod.GET)
    public ModelAndView menuInstalacions(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ModelAndView modelview = new ModelAndView("menuInstalacions");
        modelview.getModelMap().addAttribute("benvinguda", "Menú instal·lacions");
        return modelview;
    }

	/**
	 * 
	 * Vincula URL /referenciamenu amb vista menuReferencies, i ha de tenir rol de ADMIN
	 */
    @RequestMapping(value = "/referenciamenu", method = RequestMethod.GET)
    public ModelAndView menuReferencies(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ModelAndView modelview = new ModelAndView("menuReferencies");
        modelview.getModelMap().addAttribute("benvinguda", "Menú seccions");
        return modelview;
    }

	/**
	 * 
	 * Vincula URL /processmenu amb vista menuEdicio, i ha de tenir rol de ADMIN
	 */
    @RequestMapping(value = "/processmenu", method = RequestMethod.GET)
    public ModelAndView menuProcessos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ModelAndView modelview = new ModelAndView("menuEdicio");
        modelview.getModelMap().addAttribute("benvinguda", "Menú processos");
        return modelview;
    }
}
