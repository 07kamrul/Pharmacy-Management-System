package PharmacyManagementSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import PharmacyManagementSystem.Entity.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Integer> {

	@Query(value = "SELECT m FROM Medicine m WHERE m.medicineName LIKE '%' || :keyword || '%'"
			+ " OR m.genericeName LIKE '%' || :keyword || '%'" + " OR m.power LIKE '%' || :keyword || '%'"
			+ " OR m.type LIKE '%' || :keyword || '%'" + " OR m.category LIKE '%' || :keyword || '%'"
			+ " OR m.manufacturerName LIKE '%' || :keyword || '%'"
			+ " OR m.manufacturerPrice LIKE '%' || :keyword || '%'" + " OR m.sellPrice LIKE '%' || :keyword || '%'")

	public List<Medicine> search(@Param("keyword") String keyword);

}
