package PharmacyManagementSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import PharmacyManagementSystem.Entity.Type;

public interface TypeRepository extends JpaRepository<Type, Integer> {
	@Query(value = "SELECT t FROM Category t WHERE t.typeName LIKE '%' || :keyword || '%'"
			+ " OR t.typeDescription LIKE '%' || :keyword || '%'")

	public List<Type> search(@Param("keyword") String keyword);
}
