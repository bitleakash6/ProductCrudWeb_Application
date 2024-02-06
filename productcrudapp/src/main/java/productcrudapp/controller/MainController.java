package productcrudapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import jakarta.servlet.http.HttpServletRequest;
import productcrudapp.Dao.ProductDao;
import productcrudapp.model.Product;

@Controller
public class MainController {

	@Autowired
	private ProductDao productDao;

	@RequestMapping("/")
	public String home(Model m) {

		List<Product> products = productDao.getProducts();
		m.addAttribute("products", products);

		return "index";
	}

	// show and add form
	@RequestMapping("/add-product")
	public String addProduct(Model model) {
		model.addAttribute("title", "Add Product");
		return "add_product_form";
	}

	// handle add product form
	@RequestMapping(value = "/handle-product", method = RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product, HttpServletRequest request) {
		System.out.println(product);

		productDao.createProduct(product);

		RedirectView redirectview = new RedirectView();
		redirectview.setUrl(request.getContextPath() + "/");
		return redirectview;
	}

	// delete handler
	@RequestMapping("/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int productId, HttpServletRequest request) {
		this.productDao.deleteProduct(productId);
		RedirectView redirectview = new RedirectView();
		redirectview.setUrl(request.getContextPath() + "/");

		return redirectview;
	}
	
	// update form
	@RequestMapping("/update/{productId}")
	public String updateForm(@PathVariable("productId") int pid, Model model) {
		
		Product product = this.productDao.getProduct(pid);
		model.addAttribute("product", product);
		return "update_form";
	}

}
