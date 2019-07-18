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

	public List<Type> listAll() {
		return (List<Type>) typeRepository.findAll();
	}

	public void save(Type type) {
		typeRepository.save(type);
	}

	public Type get(int id) {
		return typeRepository.findById(id).get();
	}

	public void delete(int id) {
		typeRepository.deleteById(id);
	}

	public List<Type> search(String keyword) {
		return typeRepository.search(keyword);
	}

	/*
	 * public Medicine medicineImage(MultipartFile image) {
	 * 
	 * String imageName = StringUtils.cleanPath(image.getOriginalFilename()); return
	 * null; }
	 */
}
