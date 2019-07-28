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

import PharmacyManagementSystem.Entity.Manufacturer;
import PharmacyManagementSystem.Service.ManufacturerService;

@Controller
public class ManufacturerController {

	@Autowired
	private ManufacturerService manufacturerService;

	@RequestMapping("/indexManufacturer")
	public String viewHomepage(Model model) {
		List<Manufacturer> listManufacturer = manufacturerService.listAllManufacturer();
		model.addAttribute("listManufacturer", listManufacturer);
		return "indexManufacturer";
	}

	@RequestMapping("/searchManufacturer")
	public ModelAndView searchManufacturer(@RequestParam String keyword) {
		List<Manufacturer> resultManufacturer = manufacturerService.searchManufacturer(keyword);
		ModelAndView mav = new ModelAndView("searchManufacturer");
		mav.addObject("resultManufacturer", resultManufacturer);
		return mav;
	}

	@RequestMapping("/newManufacturer")
	public String showNewManufacturerInfo(Model model) {
		Manufacturer manufacturer = new Manufacturer();
		model.addAttribute("manufacturer", manufacturer);
		return "newManufacturer";
	}

	@RequestMapping(value = "/saveManufacturer", method = RequestMethod.POST)
	public String saveManufacturerInfo(@ModelAttribute("manufacturer") Manufacturer manufacturer) {
		manufacturerService.saveManufacturer(manufacturer);
		return "redirect:/indexManufacturer";
	}

	@RequestMapping("/editManufacturer/{manufacturer_id}")
	public ModelAndView editManufacturerInfo(@PathVariable(name = "manufacturer_id") int manufacturer_id) {
		ModelAndView mav = new ModelAndView("editManufacturer");
		Manufacturer manufacturer = manufacturerService.getManufacturer(manufacturer_id);
		mav.addObject("manufacturer", manufacturer);

		return mav;
	}

	@RequestMapping(value = "/updateManufacturer", method = RequestMethod.GET)
	public String updateManufacturerInfo(@ModelAttribute("manufacturer") Manufacturer manufacturer) {
		manufacturerService.saveManufacturer(manufacturer);
		return "redirect:/indexManufacturer";
	}

	@RequestMapping("/deleteManufacturer/{manufacturer_id}")
	public String deleteManufacturerInfo(@PathVariable(name = "manufacturer_id") int manufacturer_id) {
		manufacturerService.deleteManufacturer(manufacturer_id);
		return "redirect:/indexManufacturer";
	}
}
