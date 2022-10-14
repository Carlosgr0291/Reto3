package co.usa.ciclo3.ciclo3.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;
import co.usa.ciclo3.ciclo3.model.Papeleria;
import co.usa.ciclo3.ciclo3.service.PapeleriaService;

@RestController
@RequestMapping("/api/Papeleria")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class PapeleriaController {
    
    @Autowired
    private  PapeleriaService papeleriaService;
    
    @GetMapping("/all")
    public List<Papeleria> getPapelerias(){
        return papeleriaService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Papeleria> getPapeleria(@PathVariable("id") int id){
        return papeleriaService.getPapeleria(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Papeleria save(@RequestBody Papeleria p){
        return papeleriaService.save(p);
    }
}

