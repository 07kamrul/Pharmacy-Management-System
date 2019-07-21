package PharmacyManagementSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PharmacyManagementSystem.Entity.Type;
import PharmacyManagementSystem.Repository.TypeRepository;

@Service
public class TypeService {

	@Autowired
	private TypeRepository typeRepository;

	public List<Type> listAllType() {
		return (List<Type>) typeRepository.findAll();
	}

	public void saveType(Type type) {
		typeRepository.save(type);
	}

	public Type getType(int id) {
		return typeRepository.findById(id).get();
	}

	public void deleteType(int id) {
		typeRepository.deleteById(id);
	}

	public List<Type> searchType(String keyword) {
		return typeRepository.searchType(keyword);
	}

	/*
	 * public Medicine medicineImage(MultipartFile image) {
	 * 
	 * String imageName = StringUtils.cleanPath(image.getOriginalFilename()); return
	 * null; }
	 */
}
