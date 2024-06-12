package ag.uca.metier;

import ag.uca.transientObj.Utilisateur;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UcaService {
    Utilisateur getUtilisateurWithCapteursAndActionneurs(Long idUtilisateur);
}
