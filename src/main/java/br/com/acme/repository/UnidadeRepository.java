package br.com.acme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.acme.domain.Unidade;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Long> {

	@Query("select u.numeroUnidade, u.blocoUnidade from Unidade u left join Multa m on u.id = m.unidadeMulta where m.unidadeMulta is not null")
	public Object[] unidadeComMulta();
	
	@Query("select u.numeroUnidade, u.blocoUnidade from Unidade u left join Multa m on u.id = m.unidadeMulta where m.unidadeMulta is null")
	public Object[] unidadeSemMulta();
}
