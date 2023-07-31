package com.ecommerce.finalProject.controller;

import java.io.IOException;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.finalProject.Services.ECommerceService;
import com.ecommerce.finalProject.Services.ProductService;
import com.ecommerce.finalProject.Entities.ECommerce;
import com.ecommerce.finalProject.Entities.Product;

@RestController
public class ECommerceController {
	@Autowired
	private ECommerceService er;

	@PostMapping("register")
	public String registerUser(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
		ECommerce e = new ECommerce();
		e.setEmail(email);
		e.setName(name);
		e.setPassword(password);
		er.save(e);
		String message = "User inserted";
		return "<script>alert('" + message + "');</script>";
	}

	@GetMapping("register")
	public ModelAndView reg() {
		return new ModelAndView("Register");
	}

	@GetMapping("index")
	public ModelAndView index() {
		return new ModelAndView("index");
	}

	@GetMapping("about")
	public ModelAndView about() {
		return new ModelAndView("about");
	}

	@GetMapping("login")
	public ModelAndView login() {
		return new ModelAndView("Login");
	}

	@PostMapping("login")
	public ModelAndView login(@RequestParam("email") String email, @RequestParam("password") String password,
			Model model) {

		ECommerce user = er.findByemail(email);

		if (user != null && user.getPassword().equals(password)) {
			// User found and password matches
//	            model.addAttribute("message", "Login successful!");
			return new ModelAndView("redirect:index"); // Redirect to success page
		} else {
			// User not found or password does not match
//	            model.addAttribute("error", "Invalid credentials");
			return new ModelAndView("redirect:login"); // Redirect back to login page
		}
	}

	@Autowired
	private ProductService productService;

	@GetMapping("Add_Items")
	public ModelAndView item() {
		return new ModelAndView("Add_Items");
	}

	@GetMapping("/product")
	public ModelAndView getProductPage(Model model) {
		Iterable<Product> products = productService.findAll();
		model.addAttribute("products", products);

		return new ModelAndView("product");
	}

	@PostMapping("/producta")
	public ModelAndView addProduct(@RequestParam("imgurl") MultipartFile file, @RequestParam String pname, @RequestParam int prating,
			@RequestParam int preview, @RequestParam String pmaterial, @RequestParam String pweight,
			@RequestParam String pfinish, @RequestParam String pdesc, @RequestParam String pgender,
			@RequestParam String pstyle, @RequestParam String pinfo, @RequestParam double pprice,
			@RequestParam double ptotal) {
        try {
            FileUtils.writeByteArrayToFile(new File("src/main/resources/static/images/" + file.getOriginalFilename()), file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Product product = new Product();
        product.setImageUrl(file.getOriginalFilename());
        product.setProductName(pname);
        product.setProductRating(prating);
        product.setProductReviews(preview);
        product.setProductMaterial(pmaterial);
        product.setProductWeight(pweight);
        product.setProductFinish(pfinish);
        product.setProductDescription(pdesc);
        product.setProductGender(pgender);
        product.setProductStyle(pstyle);
        product.setProductInfo(pinfo);
        product.setProductPrice(pprice);
        product.setTotalPrice(ptotal);

        productService.save(product);

        return new ModelAndView("redirect:/product");
    }
}