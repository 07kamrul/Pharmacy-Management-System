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

	@RequestMapping("/")
	public String viewHomepage(Model model) {
		List<Type> listTypes = typeService.listAll();
		model.addAttribute("listTypes", listTypes);
		return "indexType";
	}

	@RequestMapping("/searchType")
	public ModelAndView searchType(@RequestParam String keyword) {
		List<Type> resultType = typeService.search(keyword);
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

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveTypeInfo(@ModelAttribute("type") Type type) {
		typeService.save(type);
		return "redirect:/";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView editTypeInfo(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("editType");
		Type type = typeService.get(id);
		mav.addObject("type", type);

		return mav;
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateTypeInfo(@ModelAttribute("type") Type type) {
		typeService.save(type);
		return "redirect:/";
	}

	@RequestMapping("/delete/{id}")
	public String deleteTypeInfo(@PathVariable(name = "id") int id) {
		typeService.delete(id);
		return "redirect:/";
	}
}
