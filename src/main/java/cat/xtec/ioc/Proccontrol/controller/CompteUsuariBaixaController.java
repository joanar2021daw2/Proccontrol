package cat.xtec.ioc.Proccontrol.controller;

import cat.xtec.ioc.Proccontrol.domain.CompteUsuariBaixa;
import cat.xtec.ioc.Proccontrol.domain.Usuari;
import cat.xtec.ioc.Proccontrol.service.impl.CompteUsuariBaixaServiceImpl;
import cat.xtec.ioc.Proccontrol.service.impl.UserServiceImpl;
import java.io.IOException;
import java.util.Calendar;
import javax.servlet.ServletException;
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
 * Classe controladora de les peticions relacionades amb la baixa dels comptes
 * dels usuaris que volen donar de baixa les seves dades
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
     * Mètode que retorna l'històric dels comptes donats de baixa
     *
     * @param model model de la plantilla
     * @return plantilla html de l'històric dels usuaris que han volgut donar de
     * baixa les seves dades (baixa del compte d'usuari + dades a Resultat)
     */
    @GetMapping("/all")
    public String getAllComptesUsuariBaixa(Model model) {
        model.addAttribute("comptesUsuariDeBaixa", compteUsuariBaixaService.getAllComptesDeBaixa());
        return "historicBaixaUsuaris";
    }

    /**
     * Mètode que dona de baixa les dades de l'usuari loguejat al sistema i
     * guarda el registre a la base de dades
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
     * Mètode que esborra del històric un registe de compte de baixa
     *
     * @param idCompteUsuariBaixa id del compte donat de baixa
     * @return plantilla html de l'istòric de comptes donats de baixa
     * @throws ServletException excepcions de servlet
     * @throws IOException excepcions d'entrada/sortida
     */
    @GetMapping("/delete")
    public String deleteCompteUsuariBaixa(@RequestParam("idCompteUsuariBaixa") long idCompteUsuariBaixa)
            throws ServletException, IOException {
        compteUsuariBaixaService.deleteCompteUsuariBaixa(idCompteUsuariBaixa);
        return "redirect:/comptesusuari/all";
    }

    /**
     * Mètode que retorna el nom de l'usuariactualment autenticat al sistema.
     *
     * @return nomUsuariAutenticat nom de l'usuari loguejat actualment
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
