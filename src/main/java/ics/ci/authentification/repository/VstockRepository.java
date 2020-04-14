package ics.ci.authentification.repository;

import ics.ci.authentification.entity.Vstock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VstockRepository extends JpaRepository<Vstock, Long> {
}
