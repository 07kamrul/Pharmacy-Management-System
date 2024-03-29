package PharmacyManagementSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import PharmacyManagementSystem.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	
	  @Query(value =
	  "SELECT c FROM Category c WHERE c.category_name LIKE '%' || :keyword || '%'" +
	  " OR c.category_description LIKE '%' || :keyword || '%'")
	 
	public List<Category> searchCategory(@Param("keyword") String keyword);

}
