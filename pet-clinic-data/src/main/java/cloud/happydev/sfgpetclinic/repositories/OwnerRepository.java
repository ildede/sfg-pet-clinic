package cloud.happydev.sfgpetclinic.repositories;

import cloud.happydev.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
