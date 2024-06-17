package ag.uca.entities;

import ag.uca.transientObj.Utilisateur;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "acutilisateurs")
public interface ClientUtilisateur {
    @RequestMapping(value = "/api/utilisateurs", method = RequestMethod.GET)
    List<Utilisateur> getAllUtilisateurs();

    @RequestMapping(value = "/api/utilisateurs/{id}", method = RequestMethod.GET)
    Utilisateur findById(@PathVariable("id") Long id);

}
