package be.fgov.economie.sge.repository;

import be.fgov.economie.sge.model.ConcessionHolder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcessionHolderRepository extends CrudRepository<ConcessionHolder,Integer> {
}
