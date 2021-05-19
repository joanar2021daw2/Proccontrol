package cat.xtec.ioc.Proccontrol.controller;

import cat.xtec.ioc.Proccontrol.domain.CompteUsuariBaixa;
import cat.xtec.ioc.Proccontrol.domain.Usuari;
import cat.xtec.ioc.Proccontrol.service.impl.CompteUsuariBaixaServiceImpl;
import cat.xtec.ioc.Proccontrol.service.impl.UserServiceImpl;
import java.io.IOException;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author JoseAndrade
 */
@Controller
@RequestMapping("/comptesusuari")
public class CompteUsuariBaixaController {

    @Autowired
    private CompteUsuariBaixaServiceImpl compteUsuariBaixaService;

    @Autowired
    private UserServiceImpl userService;

    /**
     * Retorna històric dels comptes donats de baixa
     *
     * @param model
     * @return pagina web de l'històric dels usuaris que han volgut donar de
     * baixa les seves dades (baixa del compte d'usuari + dades a Resultat)
     */
    @GetMapping("/all")
    public String getAllComptesUsuariBaixa(Model model) {
        model.addAttribute("comptesUsuariDeBaixa", compteUsuariBaixaService.getAllComptesDeBaixa());
        return "historicBaixaUsuaris";
    }

    /**
     * Dona de baixa les dades de l'usuari loguejat a tot al sistema i guarda el
     * registre a la base de dades
     *
     * @return retorna a la pàgina inicial
     */
    @GetMapping("/baixa")
    public String donarDeBaixaDadesUsuari() {
        String nomUsuariActual = nomUsuariAutenticat();
        Usuari usuari = userService.getUsuariByNom(nomUsuariActual);
        CompteUsuariBaixa registreCompte = new CompteUsuariBaixa();
        Calendar calendar = Calendar.getInstance();

        registreCompte.setNom(usuari.getNom());
        registreCompte.setCognom1(usuari.getCognom1());
        registreCompte.setCognom2(usuari.getCognom2());
        registreCompte.setNumOperari(usuari.getNumOperari());
        registreCompte.setDataBaixaCompte(calendar.getTime());

        compteUsuariBaixaService.saveCompteUsuariBaixa(registreCompte);
        userService.deleteUsuari(usuari.getUserId());

        //Fa logout de la sessió actual que s'ha donat de baixa
        SecurityContextHolder.getContext().setAuthentication(null);

        return "/confirmBaixaDadesUsuari";
    }

    /**
     * Esborrar usuari per id
     */
    @GetMapping("/delete")
    public String deleteCompteUsuariBaixa(@RequestParam("idCompteUsuariBaixa") long idCompteUsuariBaixa)
            throws ServletException, IOException {
        compteUsuariBaixaService.deleteCompteUsuariBaixa(idCompteUsuariBaixa);
        return "redirect:/comptesusuari/all";
    }

    /**
     * Mètode que retorna el nom de l'usuari autenticat al sistema.
     *
     * @return nomUsuariAutenticat
     */
    private String nomUsuariAutenticat() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String nomUsuariAutenticat = null;

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            nomUsuariAutenticat = authentication.getName();
            return nomUsuariAutenticat;
        }
        return nomUsuariAutenticat;
    }
}
