package api.restful.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.restful.api.entity.Pessoa;
import api.restful.api.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository repository;

    @GetMapping
    public List<Pessoa> listar(){
        return repository.findAll();
    }

    @PostMapping
    public Pessoa criar(@RequestBody Pessoa pessoa){
        return repository.save(pessoa);
    }

    @GetMapping("/{id}")
    public Pessoa buscar(@PathVariable Long id){
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Pessoa atualizar (@PathVariable Long id, @RequestBody Pessoa novaPessoa){
        return repository.findById(id).map(p -> {
            p.setNome(novaPessoa.getNome());
            return repository.save(p);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleter(@PathVariable Long id){
        repository.deleteById(id);
    }    
}
