package ag.uca.entities;

import ag.uca.transientObj.Actionneur;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "acactionneurs")
public interface ClientActionneur {

    @GetMapping("/api/actionneurs/{id}")
    List<Actionneur> findByUserId(@PathVariable("id") Long id);
}
