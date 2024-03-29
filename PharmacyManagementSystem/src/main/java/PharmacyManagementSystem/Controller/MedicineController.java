package PharmacyManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import PharmacyManagementSystem.Entity.Category;
import PharmacyManagementSystem.Entity.Manufacturer;
import PharmacyManagementSystem.Entity.Medicine;
import PharmacyManagementSystem.Service.CategoryService;
import PharmacyManagementSystem.Service.ManufacturerService;
import PharmacyManagementSystem.Service.MedicineService;
import PharmacyManagementSystem.Entity.Type;
import PharmacyManagementSystem.Service.TypeService;

@Controller
public class MedicineController {

	@Autowired
	private MedicineService medicineService;

	@Autowired
	private TypeService typeService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ManufacturerService manufacturerService;

	@RequestMapping("/")
	public String viewHomepage(Model model) {
		List<Medicine> listMedicines = medicineService.listAllMedicine();
		model.addAttribute("listMedicines", listMedicines);
		return "indexMedicine";
	}

	@RequestMapping("/searchMedicine")
	public ModelAndView searchMedicine(@RequestParam String keyword) {
		List<Medicine> resultMedicine = medicineService.searchMedicine(keyword);
		ModelAndView mav = new ModelAndView("searchMedicine");
		mav.addObject("resultMedicine", resultMedicine);
		return mav;
	}

	@RequestMapping("/newMedicine")
	public String showNewMedicineInfo(Model model) {
		List<Manufacturer> listManufacturerMedicine = manufacturerService.listAllManufacturer();
		List<Type> listTypeMedicine = typeService.listAllType();
		List<Category> listCategoryMedicine = categoryService.listAllCategory();

		model.addAttribute("listManufacturerMedicine", listManufacturerMedicine);
		model.addAttribute("listTypeMedicine", listTypeMedicine);
		model.addAttribute("listCategoryMedicine", listCategoryMedicine);

		Medicine medicine = new Medicine();
		model.addAttribute("medicine", medicine);
		return "newMedicine";
	}

	@RequestMapping(value = "/saveMedicine", method = RequestMethod.POST)
	public String saveMedicineInfo(@ModelAttribute("medicine") Medicine medicine) {
		medicineService.saveMedicine(medicine);
//		
//		System.out.println("Medicine name :"+medicine.getMedicine_name() + "Medicine price : "+medicine.getManufacturer_price());
		return "redirect:/";
	}

	@RequestMapping("/editMedicine/{medicine_id}")
	public ModelAndView editMedicineInfo(@PathVariable(name = "medicine_id") int medicine_id, Model model) {
		List<Type> listTypeMedicine = typeService.listAllType();
		List<Category> listCategoryMedicine = categoryService.listAllCategory();

		model.addAttribute("listTypeMedicine", listTypeMedicine);
		model.addAttribute("listCategoryMedicine", listCategoryMedicine);

		ModelAndView mav = new ModelAndView("editMedicine");
		Medicine medicine = medicineService.getMedicine(medicine_id);
		mav.addObject("medicine", medicine);

		return mav;
	}

	@RequestMapping(value = "/updateMedicine", method = RequestMethod.GET)
	public String updateMedicineInfo(@ModelAttribute("medicine") Medicine medicine) {
		medicineService.updateMedicine(medicine);
		return "redirect:/";
	}

	@RequestMapping("/deleteMedicine/{medicine_id}")
	public String deleteMedicineInfo(@PathVariable(name = "medicine_id") int medicine_id) {
		medicineService.deleteMedicine(medicine_id);
		return "redirect:/";
	}
}
