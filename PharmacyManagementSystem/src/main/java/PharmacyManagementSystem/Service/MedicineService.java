package PharmacyManagementSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PharmacyManagementSystem.Entity.Medicine;
import PharmacyManagementSystem.Repository.MedicineRepository;

@Service
public class MedicineService {

	@Autowired
	private MedicineRepository medicineRepository;

	public List<Medicine> listAllMedicine() {
		return (List<Medicine>) medicineRepository.findAll();
	}

	public void saveMedicine(Medicine medicine) {
		medicineRepository.save(medicine);
	}
	public void updateMedicine(Medicine medicine) {
		medicineRepository.save(medicine);
	}
	public Medicine getMedicine(int id) {
		return medicineRepository.findById(id).get();
	}

	public void deleteMedicine(int id) {
		medicineRepository.deleteById(id);
	}

	public List<Medicine> searchMedicine(String keyword) {
		return medicineRepository.searchMedicine(keyword);
	}

	/*
	 * public Medicine medicineImage(MultipartFile image) {
	 * 
	 * String imageName = StringUtils.cleanPath(image.getOriginalFilename()); return
	 * null; }
	 */
}
