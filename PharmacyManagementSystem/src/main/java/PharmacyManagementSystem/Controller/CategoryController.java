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
import PharmacyManagementSystem.Service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping("/")
	public String viewHomepage(Model model) {
		List<Category> listCategorys = categoryService.listAll();
		model.addAttribute("listCategorys", listCategorys);
		return "indexCategory";
	}

	@RequestMapping("/searchCategory")
	public ModelAndView searchCategory(@RequestParam String keyword) {
		List<Category> resultCategory = categoryService.search(keyword);
		ModelAndView mav = new ModelAndView("searchCategory");
		mav.addObject("resultCategory", resultCategory);
		return mav;
	}

	@RequestMapping("/newCategory")
	public String showNewCategoryInfo(Model model) {
		Category category = new Category();
		model.addAttribute("category", category);
		return "newCategory";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCategoryInfo(@ModelAttribute("category") Category category) {
		categoryService.save(category);
		return "redirect:/";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView editCategoryInfo(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("editCategory");
		Category category = categoryService.get(id);
		mav.addObject("category", category);

		return mav;
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateCategoryInfo(@ModelAttribute("category") Category category) {
		categoryService.save(category);
		return "redirect:/";
	}

	@RequestMapping("/delete/{id}")
	public String deleteCategoryInfo(@PathVariable(name = "id") int id) {
		categoryService.delete(id);
		return "redirect:/";
	}
}
