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

import PharmacyManagementSystem.Entity.Medicine;
import PharmacyManagementSystem.Service.MedicineService;

@Controller
public class TypeController {

	@Autowired
	private MedicineService medicineService;

	/*
	 * @RequestMapping(value = { "/productImage" }, method = RequestMethod.GET)
	 * public void productImage(HttpServletRequest request, HttpServletResponse
	 * response, Model model,
	 * 
	 * @RequestParam("id") int id) throws IOException { Medicine medicine = null; if
	 * (id != 0) { medicine = this.medicineService.get(id); } if (medicine != null
	 * && medicine.getImage() != null) {
	 * response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
	 * response.getOutputStream().write(medicine.getImage()); }
	 * response.getOutputStream().close(); }
	 */

	@RequestMapping("/")
	public String viewHomepage(Model model) {
		List<Medicine> listMedicines = medicineService.listAll();
		model.addAttribute("listMedicines", listMedicines);
		return "index";
	}

	@RequestMapping("/search")
	public ModelAndView searchMedicine(@RequestParam String keyword) {
		List<Medicine> result = medicineService.search(keyword);
		ModelAndView mav = new ModelAndView("search");
		mav.addObject("result", result);
		return mav;
	}

	@RequestMapping("/new")
	public String showNewMedicineInfo(Model model) {
		Medicine medicine = new Medicine();
		model.addAttribute("medicine", medicine);
		return "newMedicine";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveMedicineInfo(@ModelAttribute("medicine") Medicine medicine) {
		medicineService.save(medicine);
		return "redirect:/";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView editMedicineInfo(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("editMedicine");
		Medicine medicine = medicineService.get(id);
		mav.addObject("medicine", medicine);

		return mav;
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateMedicineInfo(@ModelAttribute("medicine") Medicine medicine) {
		medicineService.save(medicine);
		return "redirect:/";
	}

	@RequestMapping("/delete/{id}")
	public String deleteMedicineInfo(@PathVariable(name = "id") int id) {
		medicineService.delete(id);
		return "redirect:/";
	}
}
