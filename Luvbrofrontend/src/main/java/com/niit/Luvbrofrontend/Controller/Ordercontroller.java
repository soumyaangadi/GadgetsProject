package com.niit.Luvbrofrontend.Controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.Luvbro.dao.BillingDao;
import com.niit.Luvbro.dao.CardDao;
import com.niit.Luvbro.dao.CartDao;
import com.niit.Luvbro.dao.CartItemsDao;
import com.niit.Luvbro.dao.OrderDao;
import com.niit.Luvbro.dao.OrderItemsDao;
import com.niit.Luvbro.dao.PayDao;
import com.niit.Luvbro.dao.ProductDao;
import com.niit.Luvbro.dao.ShippingDao;
import com.niit.Luvbro.dao.UserDao;
import com.niit.Luvbro.model.Billing;
import com.niit.Luvbro.model.Card;
import com.niit.Luvbro.model.Cart;
import com.niit.Luvbro.model.CartItems;
import com.niit.Luvbro.model.Order;
import com.niit.Luvbro.model.OrderItems;
import com.niit.Luvbro.model.Pay;
import com.niit.Luvbro.model.Product;
import com.niit.Luvbro.model.Shipping;
import com.niit.Luvbro.model.User;



@Controller
public class Ordercontroller {


	@Autowired
	Cart cart;
	@Autowired
	CartDao cartDao;
	@Autowired
	CartItems cartItem;
	@Autowired
	CartItemsDao cartItemDao;
	@Autowired
	Card card;
	@Autowired
	CardDao cardDao;
	@Autowired
	Billing billing;
	@Autowired
	BillingDao billingDao;
	@Autowired
	Shipping shipping;
	@Autowired
	ShippingDao shippingDao;
	@Autowired
	Pay pay;
	@Autowired
	PayDao payDao;
	@Autowired
	Order order;
	@Autowired
	OrderDao orderDao;
	@Autowired
	OrderItems orderItems;
	@Autowired
	OrderItemsDao orderItemsDao;
	@Autowired
	Product product;
	@Autowired
	ProductDao productDao;
	@Autowired
	User user;
	@Autowired
	UserDao userDao;
	@Autowired
	List<CartItems> cartItems;
	
	
	String o;
	

	@RequestMapping("/Buyall")
	public String orderall(Model model,HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			user = userDao.getUseremail(currusername);
			cart = user.getCart();
			product=null;
			cartItems = cartItemDao.getlist(cart.getCart_Id());
			if(cartItems==null || cartItems.isEmpty())
			{
				return "redirect:/viewcart";
			}
			else
			{
				billing = billingDao.get(user.getU_id());
				List<Shipping> shippings = shippingDao.getaddbyuser(user.getU_id());
				
				model.addAttribute("billing", billing);
				model.addAttribute("user", user);
				model.addAttribute("shippings", shippings);
				model.addAttribute("shipping", new Shipping());
				session.setAttribute("p", product);
			}
			return "addressorder";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping("/Buy/{p_id}/{ci_id}")
	public String order(@PathVariable("p_id") String id, Model model,HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			user = userDao.getUseremail(currusername);
			cart = user.getCart();
			cartItems=null;
			product = productDao.getProduct(id);
			billing = billingDao.get(user.getU_id());
			List<Shipping> shippings = shippingDao.getaddbyuser(user.getU_id());
			
			model.addAttribute("billing", billing);
			model.addAttribute("user", user);
			model.addAttribute("shippings", shippings);
			model.addAttribute("shipping", new Shipping());
			session.setAttribute("p", product);
			return "addressorder";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping("/orderConfirm")
	public String payment(@ModelAttribute("shippingAddress") Shipping sh, Model model) {
//		if(cartItems==null || cartItems.isEmpty())
//		{
//			System.out.println("sorry");
//		}
		sh.setUser(user);
		shipping = sh;
		model.addAttribute("billing", billing);
		model.addAttribute("shipping", shipping);
		model.addAttribute("prot", product);
		model.addAttribute("cartItems",cartItems);
		model.addAttribute("cart",cart);
		return "orderconfirm";
	}

	@RequestMapping("/previous")
	public String previous(Model model) {
		List<Shipping> shippings = shippingDao.getaddbyuser(user.getU_id());
		model.addAttribute("shippings", shippings);
		model.addAttribute("billing", billing);
		model.addAttribute("shipping", shipping);
		model.addAttribute("product", product);
		
		return "addressorder";
	}

	@RequestMapping("/pay")
	public String pay(Model model) {
		List<Card> cards = cardDao.getcardbyuser(user.getU_id());
		model.addAttribute("cards", cards);
		model.addAttribute("card", new Card());
		return "Payment";
	}

		@RequestMapping("/orderconfirmation")
	public String orderconformation(HttpSession session) {
		System.out.println(32);
		order.setBilling(billing);
		order.setShipping(shipping);
		order.setPay(pay);
		order.setUser(user);
		System.out.println(524);
		if (cartItems == null || cartItems.isEmpty()) 
		{
			order.setO_grandtotal(product.getP_c());
			orderDao.saveOrUpdate(order);
			orderItems.setOrder(order);
			orderItems.setP_id(product.getP_id());
			orderItemsDao.saveOrUpdate(orderItems);
			cart.setGrandtotal(cart.getGrandtotal() - cartItem.getPrice());
			cart.setTotalitems(cart.getTotalitems() - 1);
			session.setAttribute("items", cart.getTotalitems());
			cartDao.saveOrUpdate(cart);
		
//			cartItemDao.delete(cartItemDao.getlistall(cart.getCart_Id(),product.getP_id()).getC_id());
			System.out.println(324);
		}
		else
		{ 
			System.out.println(656);
			order.setO_grandtotal(cart.getGrandtotal());
			orderDao.saveOrUpdate(order);
			for(CartItems c:cartItems)
			{
				System.out.println(3444);
				orderItems.setOrder(order);
				orderItems.setP_id(c.getProduct().getP_id());
				System.out.println(3443);
				orderItemsDao.saveOrUpdate(orderItems);
				CartItems cartiitems=cartItemDao.getCartItems(c.getC_id());
				  cartItemDao.delete(cartiitems);
			}
			cart.setGrandtotal(0.0);
			cart.setTotalitems(0);
			System.out.println(346);
			session.setAttribute("items", cart.getTotalitems());
			cartDao.saveOrUpdate(cart);
		}
		cartItems=null;
		cartItem=null;
		product=null;
		order=new Order();
		orderItems=new OrderItems();
		System.out.println(565);
		return "thankyou";
	}

}
