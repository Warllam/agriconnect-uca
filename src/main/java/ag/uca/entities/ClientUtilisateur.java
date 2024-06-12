package ag.uca.entities;

import ag.uca.transientObj.Utilisateur;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "acutilisateurs")
public interface ClientUtilisateur {
    @GetMapping("/api/utilisateurs")
    List<Utilisateur> getAllUtilisateurs();

    @GetMapping("/api/utilisateurs/{id}")
    Utilisateur findById(@PathVariable("id") Long id);

}
