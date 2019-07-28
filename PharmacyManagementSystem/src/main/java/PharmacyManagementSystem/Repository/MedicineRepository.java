package PharmacyManagementSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import PharmacyManagementSystem.Entity.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Integer> {

	@Query(value = "SELECT m FROM Medicine m WHERE m.medicine_name LIKE '%' || :keyword || '%'"
			+ " OR m.generice_name LIKE '%' || :keyword || '%'" + " OR m.medicine_power LIKE '%' || :keyword || '%'"
			+ " OR m.type LIKE '%' || :keyword || '%'" + " OR m.category LIKE '%' || :keyword || '%'"
			+ " OR m.manufacturer LIKE '%' || :keyword || '%'" + " OR m.manufacturer_price LIKE '%' || :keyword || '%'"
			+ " OR m.sell_price LIKE '%' || :keyword || '%'")

	public List<Medicine> searchMedicine(@Param("keyword") String keyword);

}
