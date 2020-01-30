package br.com.acme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.acme.domain.Aviso;

@Repository
public interface AvisoRepository extends JpaRepository<Aviso, Long> {

}
