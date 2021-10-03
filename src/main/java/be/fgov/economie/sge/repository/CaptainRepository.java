package be.fgov.economie.sge.repository;

import be.fgov.economie.sge.model.Captain;
import be.fgov.economie.sge.model.RegisterEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CaptainRepository extends CrudRepository<Captain,Integer> {
   // @Override
   // List<Captain> findAll();

    Captain findByName(String name);
}
