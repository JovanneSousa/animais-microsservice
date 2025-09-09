package br.com.jsousa.animal_service.Repository;

import br.com.jsousa.animal_service.Entity.Animal;
import br.com.jsousa.animal_service.Entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface IAnimalRepository extends JpaRepository<Animal,Integer> {

    @Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NULL ORDER BY a.dataEntrada")
    List<Animal> findNotAdopted();

    @Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NOT NULL")
    List<Animal> findAdopted();

    @Query("SELECT a FROM Animal a WHERE a.especie = br.com.jsousa.animal_service.Entity.Animal.Especie.CACHORRO")
    List<Animal> findCachorro();

    @Query("SELECT a FROM Animal a WHERE a.especie = br.com.jsousa.animal_service.Entity.Animal.Especie.GATO")
    List<Animal> findGato();

    @Query("SELECT new br.com.jsousa.animal_service.Entity.Funcionario(a.nomeRecebedor, COUNT(a)) " +
            "FROM Animal a " +
            "WHERE a.dataEntrada BETWEEN :startDate AND :endDate " +
            "GROUP BY a.nomeRecebedor")
    List<Funcionario> countByFuncionarioBetweenDates(
            @Param("startDate") Date startDate,
            @Param("endDate") Date endDate
    );
}
