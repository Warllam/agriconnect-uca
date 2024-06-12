package ag.uca.transientObj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
/**
 * Objet Utilisateur TRANSIENT (utilisé pour la communication uniquement)
 * embarquant les détails d'un utilisateur.
 */
public class Utilisateur implements Serializable {

    private Long id;
    private String nom;
    private String prenom;

    private List<Capteur> capteurs;
    private List<Actionneur> actionneurs;

}
