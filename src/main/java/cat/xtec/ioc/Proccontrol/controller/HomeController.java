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
 * @Version 1.0
 * @Since1.0
 */

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ModelAndView modelview = new ModelAndView("index");
        modelview.getModelMap().addAttribute("benvinguda", "Una app de Minipa");
        return modelview;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/edicio", method = RequestMethod.GET)
    public ModelAndView menuEdicio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ModelAndView modelview = new ModelAndView("menuEdicio");
        modelview.getModelMap().addAttribute("benvinguda", "Menú d'edició");
        return modelview;
    }

    @RequestMapping(value = "/usersmenu", method = RequestMethod.GET)
    public ModelAndView menuUsuaris(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ModelAndView modelview = new ModelAndView("menuUsuaris");
        modelview.getModelMap().addAttribute("benvinguda", "Menú usuaris");
        return modelview;
    }

    @RequestMapping(value = "/secciomenu", method = RequestMethod.GET)
    public ModelAndView menuSeccions(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ModelAndView modelview = new ModelAndView("menuSeccions");
        modelview.getModelMap().addAttribute("benvinguda", "Menú seccions");
        return modelview;
    }

    @RequestMapping(value = "/insalaciomenu", method = RequestMethod.GET)
    public ModelAndView menuInstalacions(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ModelAndView modelview = new ModelAndView("menuInstalacions");
        modelview.getModelMap().addAttribute("benvinguda", "Menú instal·lacions");
        return modelview;
    }

    @RequestMapping(value = "/referenciamenu", method = RequestMethod.GET)
    public ModelAndView menuReferencies(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ModelAndView modelview = new ModelAndView("menuReferencies");
        modelview.getModelMap().addAttribute("benvinguda", "Menú seccions");
        return modelview;
    }

    @RequestMapping(value = "/processmenu", method = RequestMethod.GET)
    public ModelAndView menuProcessos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ModelAndView modelview = new ModelAndView("menuProcessos");
        modelview.getModelMap().addAttribute("benvinguda", "Menú processos");
        return modelview;
    }
}
