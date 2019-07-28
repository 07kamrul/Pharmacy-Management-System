package PharmacyManagementSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import PharmacyManagementSystem.Entity.Manufacturer;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer> {

	@Query(value = "SELECT mf FROM Manufacturer mf WHERE mf.manufacturer_name LIKE '%' || :keyword || '%'"
			+ " OR mf.manufacturer_phone LIKE '%' || :keyword || '%'"
			+ " OR mf.manufacturer_location LIKE '%' || :keyword || '%'")

	public List<Manufacturer> searchManufacturer(@Param("keyword") String keyword);

}
