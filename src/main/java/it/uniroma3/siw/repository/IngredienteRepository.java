package it.uniroma3.siw.repository;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.uniroma3.siw.model.Ingrediente;

public interface IngredienteRepository extends CrudRepository<Ingrediente, Long>{

	public boolean existsByNome(String nome);
	

	@Query(value= "select * "
			+ "from ingrediente i "
			+ "where i.id not in "
			+ "(select ingredienti_id "
			+ "from ricetta_ingredienti "
			+ "where ricetta_ingredienti.ricette_id= :id)", nativeQuery=true)
	public Iterable<Ingrediente> findIngredientiNotInRicetta(@Param("id") Long id);


	@Modifying
    @Query(value = "delete from ricetta_ingredienti where ricetta_ingredienti.ingredienti_id = :ingredienteId", nativeQuery=true)
    void deleteReferencesInRicettaIngredienti(@Param("ingredienteId") Long ingredienteId);
}

	 
