package be.fgov.economie.sge.repository;

import be.fgov.economie.sge.model.Captain;
import be.fgov.economie.sge.model.Unloading;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnloadingRepository extends CrudRepository<Unloading,Long> {
}
