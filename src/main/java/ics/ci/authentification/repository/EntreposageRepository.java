package ics.ci.authentification.repository;

import ics.ci.authentification.entity.Entreposage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntreposageRepository extends JpaRepository<Entreposage, Long> {

    public Entreposage findTopByOrderByEntreposageIdDesc();
}
