package br.com.jsousa.animal_service.Controller;

import br.com.jsousa.animal_service.Entity.Animal;
import br.com.jsousa.animal_service.Entity.Funcionario;
import br.com.jsousa.animal_service.Repository.IAnimalRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    private IAnimalRepository iAnimalRepository;

    public AnimalController(IAnimalRepository iAnimalRepository) {
        this.iAnimalRepository = iAnimalRepository;
    }

    @GetMapping
    private List<Animal> findAll() {
        return iAnimalRepository.findAll();
    };

    @GetMapping("/count-by-funcionario")
    private List<Funcionario> countByFuncionarioBetweenDates(
            @RequestParam("startDate") String startDateStr,
            @RequestParam("endDate") String endDateStr
    ) {
      LocalDate startDate = LocalDate.parse(startDateStr);
      LocalDate endDate = LocalDate.parse(endDateStr);

      if (ChronoUnit.DAYS.between(startDate, endDate) > 365) {
          throw new IllegalArgumentException("O intervalo máximo permitido é de um ano.");
      }

      return iAnimalRepository.countByFuncionarioBetweenDates(
              java.sql.Date.valueOf(startDate),
              java.sql.Date.valueOf(endDate)
      );
    };

    @PostMapping
    private Animal create(@RequestBody Animal animal) {
        return iAnimalRepository.save(animal);
    };

    @GetMapping("/not-adopted")
    private List<Animal> findNotAdopted() {
        return iAnimalRepository.findNotAdopted();
    }

    @GetMapping("/adopted")
    private List<Animal> findAdopted() {
        return iAnimalRepository.findAdopted();
    }

    @GetMapping("/cachorro")
    private List<Animal> findCachorro() {
        return iAnimalRepository.findCachorro();
    }

    @GetMapping("/gato")
    private List<Animal> findGato() {
        return iAnimalRepository.findGato();
    }
}
