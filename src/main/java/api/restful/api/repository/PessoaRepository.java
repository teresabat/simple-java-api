package api.restful.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.restful.api.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    
}
