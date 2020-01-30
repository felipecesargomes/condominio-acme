package br.com.acme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.acme.domain.Multa;

@Repository
public interface MultaRepository extends JpaRepository<Multa, Long> {

}
