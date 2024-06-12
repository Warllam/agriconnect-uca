package ag.uca.expo;

import ag.uca.metier.UcaService;
import ag.uca.transientObj.Utilisateur;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/uca")
public class CapteurReleveController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final UcaService ucaService;

    /**
     * Constructeur
     * @param ucaService
     */
    public CapteurReleveController(UcaService ucaService) {
        this.ucaService = ucaService;
    }

    /**
     * GET 1 utilisateur AVEC la liste de ses actionneurs et capteurs
     * @return Utilisateur
     */
    @GetMapping("/{id}")
    public Utilisateur getUtilisateurWithCapteursAndActionneurs(@PathVariable("id") Long id) {
        logger.info("Composite UCA : Demande de récupération d'un utilisateur avec la liste de ses actionneurs et capteurs:{}", id);
        Utilisateur u = ucaService.getUtilisateurWithCapteursAndActionneurs(id);
        logger.info("Composite UCA : Utilisateur récupéré:{}", u);
        return u;
    }
}