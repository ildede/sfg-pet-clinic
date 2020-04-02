package cloud.happydev.sfgpetclinic.repositories;

import cloud.happydev.sfgpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
