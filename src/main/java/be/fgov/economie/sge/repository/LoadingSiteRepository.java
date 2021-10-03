package be.fgov.economie.sge.repository;

import be.fgov.economie.sge.model.LoadingSite;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoadingSiteRepository extends CrudRepository<LoadingSite,Integer> {
}
