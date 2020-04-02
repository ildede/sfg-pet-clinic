package cloud.happydev.sfgpetclinic.repositories;

import cloud.happydev.sfgpetclinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
