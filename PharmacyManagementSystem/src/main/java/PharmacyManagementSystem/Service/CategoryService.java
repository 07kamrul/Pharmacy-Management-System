package PharmacyManagementSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PharmacyManagementSystem.Entity.Medicine;
import PharmacyManagementSystem.Repository.MedicineRepository;

@Service
public class CategoryService {

	@Autowired
	private MedicineRepository medicineRepository;

	public List<Medicine> listAll() {
		return (List<Medicine>) medicineRepository.findAll();
	}

	public void save(Medicine medicine) {
		medicineRepository.save(medicine);
	}

	public Medicine get(int id) {
		return medicineRepository.findById(id).get();
	}

	public void delete(int id) {
		medicineRepository.deleteById(id);
	}

	public List<Medicine> search(String keyword) {
		return medicineRepository.search(keyword);
	}

	/*
	 * public Medicine medicineImage(MultipartFile image) {
	 * 
	 * String imageName = StringUtils.cleanPath(image.getOriginalFilename()); return
	 * null; }
	 */
}
