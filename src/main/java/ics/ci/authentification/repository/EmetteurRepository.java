package ics.ci.authentification.repository;


import ics.ci.authentification.entity.Emetteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmetteurRepository extends JpaRepository <Emetteur, Long> {
}
