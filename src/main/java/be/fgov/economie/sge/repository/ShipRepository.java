package be.fgov.economie.sge.repository;

import be.fgov.economie.sge.model.Captain;
import be.fgov.economie.sge.model.Ship;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipRepository extends CrudRepository<Ship,Integer> {
}
