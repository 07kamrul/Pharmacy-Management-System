package PharmacyManagementSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PharmacyManagementSystem.Entity.Manufacturer;
import PharmacyManagementSystem.Repository.ManufacturerRepository;

@Service
public class ManufacturerService {

	@Autowired
	private ManufacturerRepository manufacturerRepository;

	public List<Manufacturer> listAllManufacturer() {
		return (List<Manufacturer>) manufacturerRepository.findAll();
	}

	public void saveManufacturer(Manufacturer manufacturer) {
		manufacturerRepository.save(manufacturer);
	}

	public Manufacturer getManufacturer(int id) {
		return manufacturerRepository.findById(id).get();
	}

	public void deleteManufacturer(int id) {
		manufacturerRepository.deleteById(id);
	}

	public List<Manufacturer> searchManufacturer(String keyword) {
		return manufacturerRepository.searchManufacturer(keyword);
	}

}
