package it.uniroma3.siw.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.uniroma3.siw.model.Cuoco;

import java.util.List;

public interface CuocoRepository extends CrudRepository<Cuoco, Long>{

	public boolean existsByNomeAndCognome(String nome, String cognome);

	@Modifying
    @Query(value = "UPDATE ricetta SET cuoco_id = NULL WHERE cuoco_id = :cuocoId", nativeQuery=true)
    void deleteReferencesInRicettaCuochi(@Param("cuocoId") Long cuocoId);

	@Query("SELECT c FROM Cuoco c WHERE LOWER(c.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
	List<Cuoco> findByNomeContainingIgnoreCase(@Param("nome") String nome);
}
