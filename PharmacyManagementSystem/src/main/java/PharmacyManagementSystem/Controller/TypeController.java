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

import PharmacyManagementSystem.Entity.Type;
import PharmacyManagementSystem.Service.TypeService;

@Controller
public class TypeController {

	@Autowired
	private TypeService typeService;

	@RequestMapping("/indexType")
	public String viewHomepage(Model model) {
		List<Type> listTypes = typeService.listAllType();
		model.addAttribute("listTypes", listTypes);
		return "indexType";
	}

	@RequestMapping("/searchType")
	public ModelAndView searchType(@RequestParam String keyword) {
		List<Type> resultType = typeService.searchType(keyword);
		ModelAndView mav = new ModelAndView("searchType");
		mav.addObject("resultType", resultType);
		return mav;
	}

	@RequestMapping("/newType")
	public String showNewTypeInfo(Model model) {
		Type type = new Type();
		model.addAttribute("type", type);
		return "newType";
	}

	@RequestMapping(value = "/saveType", method = RequestMethod.POST)
	public String saveTypeInfo(@ModelAttribute("type") Type type) {
		typeService.saveType(type);
		return "redirect:/indexType";
	}

	@RequestMapping("/editType/{type_id}")
	public ModelAndView editTypeInfo(@PathVariable(name = "type_id") int type_id) {
		ModelAndView mav = new ModelAndView("editType");
		Type type = typeService.getType(type_id);
		mav.addObject("type", type);

		return mav;
	}

	@RequestMapping(value = "/updateType", method = RequestMethod.GET)
	public String updateTypeInfo(@ModelAttribute("type") Type type) {
		typeService.saveType(type);
		return "redirect:/indexType";
	}

	@RequestMapping("/deleteType/{type_id}")
	public String deleteTypeInfo(@PathVariable(name = "type_id") int type_id) {
		typeService.deleteType(type_id);
		return "redirect:/indexType";
	}
}
