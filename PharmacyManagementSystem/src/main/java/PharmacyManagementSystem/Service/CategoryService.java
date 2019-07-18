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

	public List<Category> listAll() {
		return (List<Category>) categoryRepository.findAll();
	}

	public void save(Category category) {
		categoryRepository.save(category);
	}

	public Category get(int id) {
		return categoryRepository.findById(id).get();
	}

	public void delete(int id) {
		categoryRepository.deleteById(id);
	}

	public List<Category> search(String keyword) {
		return categoryRepository.search(keyword);
	}

	/*
	 * public Medicine medicineImage(MultipartFile image) {
	 * 
	 * String imageName = StringUtils.cleanPath(image.getOriginalFilename()); return
	 * null; }
	 */
}
