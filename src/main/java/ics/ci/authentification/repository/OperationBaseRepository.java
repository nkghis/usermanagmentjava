package ics.ci.authentification.repository;

import ics.ci.authentification.entity.Operation;
import ics.ci.authentification.entity.Reception;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface OperationBaseRepository<T extends Operation> extends JpaRepository<T, Long> {


    public T findByOperationReference(String ref);
    public T findTopByOrderByOperationIdDesc();
    public List<Reception> findByEstDisponibleTrue();
    //public T find
    //T findAllByDispo_operation(int i);
}
