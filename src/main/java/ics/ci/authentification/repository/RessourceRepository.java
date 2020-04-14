package ics.ci.authentification.repository;

import ics.ci.authentification.entity.Ressource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RessourceRepository extends JpaRepository<Ressource, Long> {
}
