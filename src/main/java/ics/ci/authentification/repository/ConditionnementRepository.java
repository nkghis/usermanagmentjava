package ics.ci.authentification.repository;

import ics.ci.authentification.entity.Conditionnement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConditionnementRepository extends JpaRepository<Conditionnement, Long> {
}
