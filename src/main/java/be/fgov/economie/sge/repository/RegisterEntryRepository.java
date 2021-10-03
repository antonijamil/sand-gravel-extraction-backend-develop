package be.fgov.economie.sge.repository;

import be.fgov.economie.sge.model.*;
import net.minidev.json.JSONUtil;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Sort;

import javax.persistence.TypedQuery;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface RegisterEntryRepository extends JpaRepository<RegisterEntry, Integer> {

    @Query("SELECT DISTINCT re FROM RegisterEntry re join re.unloadings as unl WHERE " +
            "(re.id = :id or :id is null)" +
            "and (re.tripNumber = :tripNumber or :tripNumber is null)" +
            "and (re.ship.id = :shipId or :shipId is null)" +
            "and (re.captain.id = :captainId or :captainId is null)" +
            "and (re.concessionHolder.concessionHolderNumber = :concessionHolderNumber or :concessionHolderNumber is null)" +
            "and (re.loadingSite.id = :loadingSiteId or :loadingSiteId is null)" +
            "and (re.startDateTime >= :startDateTime or :startDateTime is null)" +
            "and (re.stopDateTime <= :stopDateTime or :stopDateTime is null)" +
            "and (re.loadedQuantity = :loadedQuantity or :loadedQuantity is null)" +
            "and (unl.destinationCountry = :destinationCountry or :destinationCountry is null)" +
            "and (unl.destination like %:destination% or :destination is null)"

    )
    Page<RegisterEntry> findRegisterEntryByParams(
            @Param("id") Integer id,
            @Param("tripNumber") Long tripNumber,
            @Param("shipId") Integer shipId,
            @Param("captainId") Integer captainId,
            @Param("concessionHolderNumber") Integer concessionHolderNumber,
            @Param("loadingSiteId") Integer loadingSiteId,
            @Param("startDateTime") LocalDateTime startDateTime,
            @Param("stopDateTime") LocalDateTime stopDateTime,
            @Param("loadedQuantity") Integer loadedQuantity,
            @Param("destination") String destination,
            @Param("destinationCountry") String destinationCountry,
            Pageable pageable);

    @Query("SELECT re FROM RegisterEntry re WHERE " +
            "(re.id = :id or :id is null)" +
            "and (re.tripNumber = :tripNumber or :tripNumber is null)" +
            "and (re.ship.id = :shipId or :shipId is null)" +
            "and (re.captain.id = :captainId or :captainId is null)" +
            "and (re.concessionHolder.concessionHolderNumber = :concessionHolderNumber or :concessionHolderNumber is null)" +
            "and (re.loadingSite.id = :loadingSiteId or :loadingSiteId is null)" +
            "and (re.startDateTime >= :startDateTime or :startDateTime is null)" +
            "and (re.stopDateTime <= :stopDateTime or :stopDateTime is null)" +
            "and (re.loadedQuantity = :loadedQuantity or :loadedQuantity is null)"
    )
    Page<RegisterEntry> findRegisterEntryByParams(
            @Param("id") Integer id,
            @Param("tripNumber") Long tripNumber,
            @Param("shipId") Integer shipId,
            @Param("captainId") Integer captainId,
            @Param("concessionHolderNumber") Integer concessionHolderNumber,
            @Param("loadingSiteId") Integer loadingSiteId,
            @Param("startDateTime") LocalDateTime startDateTime,
            @Param("stopDateTime") LocalDateTime stopDateTime,
            @Param("loadedQuantity") Integer loadedQuantity,
            Pageable pageable);
}
