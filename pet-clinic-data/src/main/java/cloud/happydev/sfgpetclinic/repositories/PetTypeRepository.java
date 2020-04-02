package cloud.happydev.sfgpetclinic.repositories;

import cloud.happydev.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
