package com.shoes.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shoes.entity.Category;
import com.shoes.entity.Commodity;
import com.shoes.entity.Customer;
import com.shoes.entity.OrderList;
import com.shoes.entity.Reply;
import com.shoes.entity.ShoppingCar;
import com.shoes.entity.Suggestion;
import com.shoes.entity.TmpCustomer;
import com.shoes.service.CategoryService;
import com.shoes.service.CommodityService;
import com.shoes.service.CustomerService;
import com.shoes.service.OrderListService;
import com.shoes.service.ReplyService;
import com.shoes.service.ShoppingCarService;
import com.shoes.service.SuggestionService;
import com.shoes.service.TmpCustomerService;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@Transactional 
@RequestMapping("/customer")
@SessionAttributes({"user","Customer"}) 
public class CustomerController {
	
	@Autowired
	private OrderListService orderListService;
	
	@Autowired
	private CommodityService commodityService;
	
	@Autowired
	private ShoppingCarService shoppingCarService;
	
	@Autowired
	private ReplyService replyService;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private CategoryService categoryService;
	
	// need to inject customer service
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private TmpCustomerService tmpCustomerService;
	
	@Autowired
	private SuggestionService suggestionService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get customers from the dao
		List<Customer> theCustomers = customerService.getCustomers();
				
		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		System.out.println(theCustomers);
		
		return "list-customers";
	}
	
	// show user's fundamental info
	@GetMapping("/showInfo")
	public String showInfo(Model model,HttpSession session) {
		
		int theId = Integer.parseInt(session.getAttribute("id").toString());
		
		// get the customer form our service
		Customer theCustomer = customerService.getCustomer(theId );
		
		System.out.println(theCustomer);
		
		// set customer as a model attribute to pre-populate the form
		model.addAttribute("customer",theCustomer);
		
		return "user/user-infoPage";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer",theCustomer);
		
		return "customer-form";
		
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,Model theModel) {
		
		// get the customer form our service
		Customer theCustomer = customerService.getCustomer(theId );
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer",theCustomer);
		
		// send over to our form
		return "customer-form";
	}
	
	@GetMapping("/showFormForDelete")
	public String showFormForDelete(@RequestParam("customerId") int theId) {
		
		// delete the customer
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}
	
	@RequestMapping(value="/loginIndex")
	public String showLogin(Model model,HttpSession session) {
		
		// get a current hibernate sesssion
 		Session currentSession = sessionFactory.getCurrentSession();
 		
 		if(session.getAttribute("uname")!=null) {
 			
			// get commodity resource
 			List<Commodity> theCommodity = commodityService.getCommodity();
 			
 			List<Category> theCategory = categoryService.getAllCategory();
 	 		
 			// add commodity to the page
 	 		model.addAttribute("commodities", theCommodity);
 	 		
 	 		model.addAttribute("categories",theCategory);
 	 		
 	 		// add customer info to page 
 	 		model.addAttribute("Customer",session.getAttribute("uname"));
 	 		
 			return "vip_index";
		}
		
		return "user_login";
	}
	
	// user login in
	@RequestMapping("/userLogin")
	public String customerLogin(@RequestParam("username") String username, @RequestParam("password") String password,
            Model model,HttpSession session) {
				
	    // get a current hibernate sesssion
 		Session currentSession = sessionFactory.getCurrentSession();
 		 		
 		// create a query 
 		Query<Customer> theQuery = 
 				currentSession.createQuery("from Customer c where c.userNickname = " + "\'" + username + "\'" + " and " + " c.userPassword = "  + "\'" + password + "\'" , Customer.class);
 		
 		// execute the query and get result list
 		List<Customer> customer = theQuery.getResultList();
 		
 		if(customer.size()!=0) {
 			 			
 			session.setAttribute("uname", username);  
 			
 			session.setAttribute("id", customer.get(0).getUserId());
 			
 			session.setAttribute("truename", customer.get(0).getUserTrueName());
 			
 			// get commodity resource
 			List<Commodity> theCommodity = commodityService.getCommodity();
 	 		
 			// add commodity to the page
 	 		model.addAttribute("commodities", theCommodity);
 	 		
 	 		List<Category> theCategory = categoryService.getAllCategory();
 	 		
 	 		model.addAttribute("categories",theCategory);
 	 		
 	 		// add customer info to page 
 	 		model.addAttribute("Customer",customer.get(0).getUserNickname());
 	 		
 			return "vip_index";
 		}else {
 			return "error_404";
 		}
		
	}
	
	// customer register
	@RequestMapping(value="/customerRegisterAction")
	public String customerRegisterAction(Model theModel) {
		
       TmpCustomer theCustomer = new TmpCustomer();
		
		theModel.addAttribute("tmpCustomer",theCustomer);
		
		return "customer-register-form";
		
	}
	
	// save tmp customer
	@PostMapping("/saveTmpCustomer")
	public String saveTmpCustomer(@ModelAttribute("tmpCustomer") TmpCustomer theCustomer) {
		
		// save the customer using our service
		System.out.println(theCustomer);
		
		tmpCustomerService.saveCustomer(theCustomer);
		
		return "success-page";
	}
	
	// user center
	@RequestMapping(value="/InfoCenter")
	public String customerCenter() {
		
		return "user/centerIndex";
		
	}
	
	@RequestMapping("*")
    public String errorHandle(){
		
         return "404";
    }
	
	// show modify the user page
	@GetMapping("/modifyInfo")
	public String customerUpgrade(Model theModel,HttpSession session) {
		
		
		int theId = Integer.parseInt(session.getAttribute("id").toString());
		
		// get the customer form our service
		Customer theCustomer = customerService.getCustomer(theId );
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer",theCustomer);
		
		// send over to our form
		return "user/customer-modify-form";
	}
	
	// upgrade user's information after modify action
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		// save the customer using our service
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/InfoCenter";
	}
	
	// login out
	@RequestMapping("/loginOut")
	public String loginOut(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/";
	}
	
	// show finish list order
	@RequestMapping("/showFinishList")
	public String showFinishList(HttpSession session, Model theModel) {
		
		String name = session.getAttribute("truename").toString();
		
		System.out.println(name);
		
		List<OrderList> orderLists = orderListService.getCustomerFinishedList(name);
		
		System.out.println(orderLists.get(0));
		
		theModel.addAttribute("OrderList",orderLists);
		
		return "user/showList";
	}
	
	// show unfinished list order
	@RequestMapping("/showUnfinshedList")
	public String showUnfinishedList(HttpSession session, Model theModel) {
		
		String name = session.getAttribute("truename").toString();
		
		System.out.println(name);
		
		List<OrderList> orderLists = orderListService.getCustomerUnfinishedList(name);
		
		System.out.println(orderLists.get(0));
		
		theModel.addAttribute("OrderList",orderLists);
		
		return "user/showList";
	}
	
	// show customer all list order
	@RequestMapping("/showAllList")
	public String showAllList(HttpSession session, Model theModel) {
		
		String name = session.getAttribute("truename").toString();
		
		System.out.println(name);
		
		List<OrderList> orderLists = orderListService.getCustomerAllList(name);
		
		System.out.println(orderLists.get(0));
		
		theModel.addAttribute("OrderList",orderLists);
		
		return "user/showList";
	}
	
	// send suggestion
	@RequestMapping("/sendRecommendation")
	public String sendRecommendation(@RequestParam("comments") String comments,
			@RequestParam("theme") String theme,
			@RequestParam("phone") String phone	,
			@RequestParam("truename") String trueName
			)  throws ParseException{
		
		Date day=new Date();    

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		
		System.out.println(df.parse(df.format(day)));
		
		Suggestion suggestion = new Suggestion(trueName,theme,comments,df.parse(df.format(day)),0,phone);
		
		suggestionService.saveSuggestion(suggestion);
		
		return "redirect:/customer/InfoCenter";
	}
	
	
	// show send suggestion page
	@RequestMapping("/showRecommendation")
	public String showRecommendation() {
		
		return "user/suggestion";
	}
	
	// show shopping car
	@RequestMapping("/showShoppingCar")
	public String showShoppingCar(Model model , HttpSession session) {
		
		String username = String.valueOf(session.getAttribute("uname"));
		
		System.out.println(username);
		
		List<ShoppingCar> shoppingcarList =  shoppingCarService.getShoppingCarList(username);
		
		Double totalSum = 0.0;
		
		int i = 0;
		
		while(i<shoppingcarList.size()) {
			
			totalSum = totalSum + Double.parseDouble(shoppingcarList.get(i).getSum());
			
			System.out.println(totalSum);
			
			i=i+1;
		}
		
		System.out.println(totalSum);
		
		model.addAttribute("totalSum", totalSum);
		
		model.addAttribute("shoppingcarLists", shoppingcarList);
		
		System.out.println(shoppingcarList);
		
		return "user/showShoppingCar";
	}
	
	// show customer reply
	@RequestMapping("/showReply")
	public String showReply(Model model,HttpSession session) {
		
		String username = String.valueOf(session.getAttribute("uname"));
		
		System.out.println(username);
		
		List<Reply> reply = replyService.getCustomerReply(username);
		
		System.out.println(reply);
		
		model.addAttribute("Reply",reply);	
		
		return "user/showReply";
	}
	
	//按照人群分类展示商品
	@RequestMapping("/showCommodityByPeople")
	public String showCommodityByPeople(@RequestParam("People") String people,
			@RequestParam("Sex") String sex,Model model) {
		
		System.out.println(sex+"/"+people);
		
		List<Commodity> theCommodity = commodityService.getCommodityByPeople(people, sex);
		
		System.out.println(theCommodity.size());
		
		List<Category> theCategory = categoryService.getAllCategory();
		
		model.addAttribute("commodities", theCommodity);
		
		model.addAttribute("categories",theCategory);
		
		return "vip_index";
	}
	
	//按照季节展示商品
	@RequestMapping("/showCommodityBySeason")
	public String showCommodityBySeason(@RequestParam("Season") String season,Model model) {
		
		List<Commodity> theCommodity = commodityService.getCommodityBySeason(season);
		
		List<Category> theCategory = categoryService.getAllCategory();
		
		model.addAttribute("commodities", theCommodity);
		
		model.addAttribute("categories",theCategory);
		
		return "vip_index";
	}
	
	//按照商品种类展示商品
	@RequestMapping("/showCommodityByKind")
	public String showCommodityByKind(@RequestParam("Type") String type,
			@RequestParam("Sex") String sex,Model model) {
		
		List<Commodity> theCommodity = commodityService.getCommodityByKinds(sex, type);
		
		List<Category> theCategory = categoryService.getAllCategory();
		
		model.addAttribute("commodities", theCommodity);
		
		model.addAttribute("categories",theCategory);
		
		return "vip_index";
	}
	
	@RequestMapping("/contact")
	public String contact() {
		
		return "user/contact";
	}
	
}

