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
import PharmacyManagementSystem.Entity.Medicine;
import PharmacyManagementSystem.Service.CategoryService;
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

	@RequestMapping("/")
	public String viewHomepage(Model model) {
		List<Medicine> listMedicines = medicineService.listAllMedicine();
		model.addAttribute("listMedicines", listMedicines);
		return "indexMedicine";
	}

	@RequestMapping("/searchMedicine")
	public ModelAndView searchMedicine(@RequestParam String keyword) {
		List<Medicine> result = medicineService.searchMedicine(keyword);
		ModelAndView mav = new ModelAndView("search");
		mav.addObject("result", result);
		return mav;
	}

	@RequestMapping("/newMedicine")
	public String showNewMedicineInfo(Model model) {
		List<Type> listTypeMedicine = typeService.listAllType();
		List<Category> listCategoryMedicine = categoryService.listAllCategory();
		Medicine medicine = new Medicine();
		model.addAttribute("medicine", medicine);
		model.addAttribute("listTypeMedicine",listTypeMedicine);
		model.addAttribute("listCategoryMedicine",listCategoryMedicine);
		return "newMedicine";
	}

	@RequestMapping(value = "/saveMedicine", method = RequestMethod.POST)
	public String saveMedicineInfo(@ModelAttribute("medicine") Medicine medicine) {
		medicineService.saveMedicine(medicine);
		return "redirect:/";
	}

	@RequestMapping("/editMedicine/{medicine_id}")
	public ModelAndView editMedicineInfo(@PathVariable(name = "medicine_id") int medicine_id) {
		ModelAndView mav = new ModelAndView("editMedicine");
		Medicine medicine = medicineService.getMedicine(medicine_id);
		mav.addObject("medicine", medicine);

		return mav;
	}

	@RequestMapping(value = "/updateMedicine", method = RequestMethod.GET)
	public String updateMedicineInfo(@ModelAttribute("medicine") Medicine medicine) {
		medicineService.saveMedicine(medicine);
		return "redirect:/";
	}

	@RequestMapping("/deleteMedicine/{medicine_id}")
	public String deleteMedicineInfo(@PathVariable(name = "medicine_id") int medicine_id) {
		medicineService.deleteMedicine(medicine_id);
		return "redirect:/";
	}
}
