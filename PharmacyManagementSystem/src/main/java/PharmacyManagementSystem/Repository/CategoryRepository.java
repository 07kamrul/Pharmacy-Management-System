package PharmacyManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import PharmacyManagementSystem.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
