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

import PharmacyManagementSystem.Entity.Image;
import PharmacyManagementSystem.Service.ImageService;

@Controller
public class ImageController {

	@Autowired
	private ImageService imageService;

	@RequestMapping("/")
	public String viewHomepage(Model model) {
		List<Image> listImage = imageService.listAll();
		model.addAttribute("listImage", listImage);
		return "indexImage";
	}

	@RequestMapping("/searchImage")
	public ModelAndView searchImage(@RequestParam String keyword) {
		List<Image> resultImage = imageService.search(keyword);
		ModelAndView mav = new ModelAndView("searchImage");
		mav.addObject("resultImage", resultImage);
		return mav;
	}

	@RequestMapping("/newImage")
	public String showNewImageInfo(Model model) {
		Image image = new Image();
		model.addAttribute("image", image);
		return "newImage";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveImageInfo(@ModelAttribute("image") Image image) {
		imageService.save(image);
		return "redirect:/";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView editImageInfo(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("editImage");
		Image image = imageService.get(id);
		mav.addObject("image", image);

		return mav;
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateImageInfo(@ModelAttribute("image") Image image) {
		imageService.save(image);
		return "redirect:/";
	}

	@RequestMapping("/delete/{id}")
	public String deleteImageInfo(@PathVariable(name = "id") int id) {
		imageService.delete(id);
		return "redirect:/";
	}
}
