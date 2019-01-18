package com.niit.Luvbrofrontend.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.niit.Luvbro.dao.CartDao;
import com.niit.Luvbro.dao.CartItemsDao;
import com.niit.Luvbro.dao.ProductDao;
import com.niit.Luvbro.dao.UserDao;
import com.niit.Luvbro.model.Cart;
import com.niit.Luvbro.model.CartItems;
import com.niit.Luvbro.model.Product;
import com.niit.Luvbro.model.User;

@Controller
public class CartController 
{
	@Autowired
	Product product;
	@Autowired 
	ProductDao productDao;
	
	@Autowired 
	User user;
	@Autowired 
	UserDao userDao;
	
	@Autowired
	Cart cart;
	@Autowired
	CartDao cartDao;
	
	@Autowired
	CartItems cartItems;
	@Autowired
	CartItemsDao cartItemDao;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/addtocart/{id}")
	public ModelAndView cart(@PathVariable("id") String id) 
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
	User u = userDao.getUseremail(currusername);
	if (user == null)
	{
		return new ModelAndView("redirect:/");
	} 
	else
	{
		cart = u.getCart();
		Product product1 = productDao.getProduct(id);
		CartItems cartItem = new CartItems();
		cartItem.setCart(cart);
		cartItem.setProduct(product1);
		cartItem.setPrice(product1.getP_c());
		cartItemDao.saveOrUpdate(cartItem);
		cart.setGrandtotal(cart.getGrandtotal() + product1.getP_c());
		cart.setTotalitems(cart.getTotalitems() + 1);
		cartDao.saveOrUpdate(cart);
		session.setAttribute("items", cart.getTotalitems());
		session.setAttribute("gd", cart.getGrandtotal());
		return new ModelAndView("redirect:/allproducts");
		}
		}
		else {
			return new ModelAndView("redirect:/");
		}
	}
	
	@RequestMapping(value = "/viewcart")
	public String viewcart(Model model, HttpSession session) 
	{
		System.out.println(1223);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken))
		{
			String currusername = authentication.getName();
			User u = userDao.getUseremail(currusername);
		        Cart c=u.getCart();
				List<CartItems> cartItem = cartItemDao.getlist(u.getCart().getCart_Id());
//				if(cartItem==null ||cartItem.isEmpty())
//				{
//					session.setAttribute("items",0);
//					model.addAttribute("gtotal",0.0);
//					model.addAttribute("msg", "no Items is added to cart");
//					return "viewcart";		
//				}
				
				model.addAttribute("cartItems", cartItem);
				model.addAttribute("gtotal",c.getGrandtotal());
				session.setAttribute("items",c.getTotalitems());
			    session.setAttribute("cartId", c.getCart_Id());
				return "viewcart";		
	}
//		else
//		{
			return "redirect:/viewcart";
//		}
	}
	
	@RequestMapping(value="/Remove/{p_id}")
	public String RemoveFromCart(@PathVariable("p_id") String id)
	{
		cartItems=cartItemDao.getCartItems(id);
		Cart c=cartItems.getCart();
		c.setGrandtotal(c.getGrandtotal()-cartItems.getPrice());
		c.setTotalitems(c.getTotalitems()-1);
		cartDao.saveOrUpdate(c);
		CartItems cartiitemss = cartItemDao.getCartItems(cartItems.getC_id()) ;
		cartItemDao.delete(cartiitemss);
		return "redirect:/viewcart";
	}
	
	@RequestMapping(value="/Removeall")
	public String RemoveallFromCart(Model model,HttpSession session)
	{
		Cart c=cartDao.getCart((String)session.getAttribute("cartId"));
		List<CartItems> cartItems=cartItemDao.getlist((String)session.getAttribute("cartId"));
		for(CartItems g:cartItems)
		{
			CartItems cartiitems=cartItemDao.getCartItems(g.getC_id());
		  cartItemDao.delete(cartiitems);
		}
		c.setGrandtotal(0.0);;
		c.setTotalitems(0);
		cartDao.saveOrUpdate(c);
		session.setAttribute("items",c.getTotalitems());
		return "redirect:/viewcart";
	}
	
//	@RequestMapping("/addtocartR/{p_id}")
//	public ModelAndView cartr(@PathVariable("p_id") String id) {
//
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		if (!(authentication instanceof AnonymousAuthenticationToken)) {
//			String currusername = authentication.getName();
//			User u = userDao.getUseremail(currusername);
//			if (user == null) {
//				return new ModelAndView("redirect:/");
//			} else {
//
//				cart = u.getCart();
//				product = productDao.getProduct(id);
//				CartItems cartItem = new CartItems();
//				cartItem.setCart(cart);
//				cartItem.setProduct(product);
//				cartItem.setPrice(product.getP_c());
//				cartItemDao.saveOrUpdate(cartItem);
//				cart.setGrandtotal(cart.getGrandtotal() + product.getP_c());
//				cart.setTotalitems(cart.getTotalitems() + 1);
//				cartDao.saveOrUpdate(cart);
//				session.setAttribute("items", cart.getTotalitems());
//				session.setAttribute("gd", cart.getGrandtotal());
//				return new ModelAndView("redirect:/viewcart");
//			}
//		} else {
//			return new ModelAndView("redirect:/");
//		}
//
//	}
//	@RequestMapping("/addtocartC/{p_id}")
//	public ModelAndView cartc(@PathVariable("p_id") String id) {
//
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		if (!(authentication instanceof AnonymousAuthenticationToken)) {
//			String currusername = authentication.getName();
//			User u = userDao.getUseremail(currusername);
//			if (user == null) {
//				return new ModelAndView("redirect:/");
//			} else {
//
//				cart = u.getCart();
//				product = productDao.getProduct(id);
//				CartItems cartItem = new CartItems();
//				cartItem.setCart(cart);
//				cartItem.setProduct(product);
//				cartItem.setPrice(product.getP_c());
//				cartItemDao.saveOrUpdate(cartItem);
//				cart.setGrandtotal(cart.getGrandtotal() + product.getP_c());
//				cart.setTotalitems(cart.getTotalitems() + 1);
//				cartDao.saveOrUpdate(cart);
//				session.setAttribute("items", cart.getTotalitems());
//				session.setAttribute("gd", cart.getGrandtotal());
//				return new ModelAndView("redirect:/viewcart");
//			}
//		} else {
//			return new ModelAndView("redirect:/");
//		}
//
//	}


}
