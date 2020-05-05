package carpinteroseverino.repositories;


import carpinteroseverino.model.Herd;
import carpinteroseverino.model.HerdAlert;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HerdAlertRepository extends JpaRepository<HerdAlert, Integer> {

    HerdAlert findByHerd(Herd herd);
}
