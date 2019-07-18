package PharmacyManagementSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PharmacyManagementSystem.Entity.Image;
import PharmacyManagementSystem.Repository.ImageRepository;

@Service
public class ImageService {

	@Autowired
	private ImageRepository imageRepository;

	public List<Image> listAll() {
		return (List<Image>) imageRepository.findAll();
	}

	public void save(Image image) {
		imageRepository.save(image);
	}

	public Image get(int id) {
		return imageRepository.findById(id).get();
	}

	public void delete(int id) {
		imageRepository.deleteById(id);
	}

	public List<Image> search(String keyword) {
		return imageRepository.search(keyword);
	}

	/*
	 * public Medicine medicineImage(MultipartFile image) {
	 * 
	 * String imageName = StringUtils.cleanPath(image.getOriginalFilename()); return
	 * null; }
	 */
}
