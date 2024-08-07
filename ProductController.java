package com.example.contoller;

	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.GetMapping;

	import com.example.servicee.ProductService;

	@Controller
	public class ProductController {
		private ProductService productService;
		
		public ProductController(ProductService productService) {
			super();
			this.productService= productService;
			
		}
		//handler method to handle list products and return list view mode
		@GetMapping("/product")
		public String listProduct(Model model) {
			model.addAttribute("Products", productService.getAllProduct());
			return "products";
			
		}

	}
