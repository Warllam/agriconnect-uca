package ag.uca.metier;

import ag.uca.entities.ClientUtilisateur;
import ag.uca.transientObj.Actionneur;
import ag.uca.transientObj.Capteur;
import ag.uca.entities.ClientActionneur;
import ag.uca.entities.ClientCapteur;
import ag.uca.transientObj.Utilisateur;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UcaServiceImpl implements UcaService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ClientCapteur clientCapteur;
    private final ClientActionneur clientActionneur;
    private final ClientUtilisateur clientUtilisateur;

    public UcaServiceImpl(ClientCapteur clientCapteur, ClientActionneur clientActionneur, ClientUtilisateur clientUtilisateur) {
        this.clientCapteur = clientCapteur;
        this.clientActionneur = clientActionneur;
        this.clientUtilisateur = clientUtilisateur;
    }

    @Override
    public Utilisateur getUtilisateurWithCapteursAndActionneurs(Long idUtilisateur) {
        try {
            Utilisateur utilisateur = clientUtilisateur.findById(idUtilisateur);
            List<Capteur> capteurs = clientCapteur.findByUserId(idUtilisateur);
            logger.info("Récupéré {} capteurs pour l'utilisateur ID {}", capteurs.size(), idUtilisateur);
            List<Actionneur> actionneurs = clientActionneur.findByUserId(idUtilisateur);
            logger.info("Récupéré {} actionneurs pour l'utilisateur ID {}", actionneurs.size(), idUtilisateur);
            utilisateur.setCapteurs(capteurs);
            utilisateur.setActionneurs(actionneurs);
            return utilisateur;
        } catch (Exception e) {
            logger.error("Erreur lors de la récupération des capteurs ou des actionneurs pour l'utilisateur ID {}: {}", idUtilisateur, e.getMessage());
            throw new RuntimeException("Erreur lors de la récupération des capteurs ou des actionneurs", e);
        }
    }
}
