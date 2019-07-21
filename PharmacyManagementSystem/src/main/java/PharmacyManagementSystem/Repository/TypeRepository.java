package PharmacyManagementSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import PharmacyManagementSystem.Entity.Type;

public interface TypeRepository extends JpaRepository<Type, Integer> {
	
	  @Query(value =
	  "SELECT t FROM Type t WHERE t.type_name LIKE '%' || :keyword || '%'" +
	  " OR t.type_description LIKE '%' || :keyword || '%'")
	 
	public List<Type> searchType(@Param("keyword") String keyword);
}
