package PharmacyManagementSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PharmacyManagementSystem.Entity.Category;
import PharmacyManagementSystem.Repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> listAllCategory() {
		return (List<Category>) categoryRepository.findAll();
	}

	public void saveCategory(Category category) {
		categoryRepository.save(category);
	}

	public Category getCategory(int id) {
		return categoryRepository.findById(id).get();
	}

	public void deleteCategory(int id) {
		categoryRepository.deleteById(id);
	}

	public List<Category> searchCategory(String keyword) {
		return categoryRepository.searchCategory(keyword);
	}

	/*
	 * public Medicine medicineImage(MultipartFile image) {
	 * 
	 * String imageName = StringUtils.cleanPath(image.getOriginalFilename()); return
	 * null; }
	 */
}
