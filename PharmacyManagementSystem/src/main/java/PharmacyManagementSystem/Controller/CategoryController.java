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

	@RequestMapping("/indexCategory")
	public String viewHomepage(Model model) {
		List<Category> listCategories = categoryService.listAllCategory();
		model.addAttribute("listCategories", listCategories);
		return "indexCategory";
	}

	@RequestMapping("/searchCategory")
	public ModelAndView searchCategory(@RequestParam String keyword) {
		List<Category> resultCategory = categoryService.searchCategory(keyword);
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

	@RequestMapping(value = "/saveCategory", method = RequestMethod.POST)
	public String saveCategoryInfo(@ModelAttribute("category") Category category) {
		categoryService.saveCategory(category);
		return "redirect:/indexCategory";
	}

	@RequestMapping("/editCategory/{category_id}")
	public ModelAndView editCategoryInfo(@PathVariable(name = "category_id") int category_id) {
		ModelAndView mav = new ModelAndView("editCategory");
		Category category = categoryService.getCategory(category_id);
		mav.addObject("category", category);

		return mav;
	}

	@RequestMapping(value = "/updateCategory", method = RequestMethod.GET)
	public String updateCategoryInfo(@ModelAttribute("category") Category category) {
		categoryService.saveCategory(category);
		return "redirect:/indexCategory";
	}

	@RequestMapping("/deleteCategory/{category_id}")
	public String deleteCategoryInfo(@PathVariable(name = "category_id") int category_id) {
		categoryService.deleteCategory(category_id);
		return "redirect:/indexCategory";
	}
}
