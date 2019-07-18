package PharmacyManagementSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import PharmacyManagementSystem.Entity.Image;

public interface ImageRepository extends JpaRepository<Image, Integer> {

	@Query(value = "SELECT i FROM Category i WHERE i.imageName LIKE '%' || :keyword || '%'")

	public List<Image> search(@Param("keyword") String keyword);
}
