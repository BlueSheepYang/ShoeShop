package com.shoes.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.shoes.entity.Category;
import com.shoes.entity.Commodity;
import com.shoes.entity.Customer;
import com.shoes.entity.OrderList;
import com.shoes.entity.Reply;
import com.shoes.entity.Suggestion;
import com.shoes.entity.SuperAdmin;
import com.shoes.entity.TmpCustomer;
import com.shoes.func.Statistical;
import com.shoes.service.CategoryService;
import com.shoes.service.CommodityService;
import com.shoes.service.CustomerService;
import com.shoes.service.OrderListService;
import com.shoes.service.ReplyService;
import com.shoes.service.SuggestionService;
import com.shoes.service.SuperAdminService;
import com.shoes.service.TmpCustomerService;

@Controller
@Transactional 
@RequestMapping(value="/admin")
public class AdminController {
	
	@Autowired
	private CommodityService commodityService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private TmpCustomerService tmpCustomerService;
	
	@Autowired
	private SuperAdminService superadminService;
	
	@Autowired
	private OrderListService orderListService;
	
	@Autowired
	private SuggestionService suggestionService;
	
	@Autowired
	private ReplyService replyService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@GetMapping(value="/index")
	public String AdminIndex() {
		return "redirect:/admin/loginIndex";
	}
	
	@RequestMapping(value="/loginIndex")
	public String showLogin() {
		
		return "admin/admin-login";
	}
	
	// show register customers
	@RequestMapping(value="/showRegisterCustomer")
	public String showRegisterCustomer(Model model) {
		
		List<TmpCustomer> customers = tmpCustomerService.getCustomers();
		
		model.addAttribute("Customers", customers);
		
		return "admin/addSuperCustomer";
	}
	
	// show all Vip customer
	@RequestMapping(value="/showSuperCustomer")
	public String showSuperCustomer(Model model) {
		
		List<Customer> Customers = customerService.getCustomers();
		
		model.addAttribute("Customers", Customers);
		
		return "admin/showSuperCustomer";
		
		
	}
	
	// admin login in
	@RequestMapping("/adminLogin")
	public String customerLogin(
			@RequestParam("adminname") String adminname,
			@RequestParam("password") String password,
            Model model,HttpSession session) {
				
	    // get a current hibernate sesssion
 		Session currentSession = sessionFactory.getCurrentSession();
 		 		
 		// create a query 
 		Query<SuperAdmin> theQuery = 
 				currentSession.createQuery("from SuperAdmin c where c.superAdminName = " + "\'" + adminname + "\'" + " and " + " c.superAdminPassword = "  + "\'" + password + "\'" , SuperAdmin.class);
 		
 		// execute the query and get result list
 		List<SuperAdmin> Admin = theQuery.getResultList();
 		
 		System.out.println(Admin);
 		
 		if(Admin.size()!=0) {
 			 			
 			session.setAttribute("adminName", adminname);  
 	 		
 			return "admin/admin-index";
 		}else {
 			return "error_404";
 		}
		
	}
	
	
	// delete register user
	@GetMapping("/customerDelete")
	public String deleteTmpCustomer(@RequestParam("customerId") int customerId) {
		
		// delete the customer using our service
		tmpCustomerService.deleteCustomer(customerId);
		
		return "redirect:/admin/showRegisterCustomer";
	}
	
	// upgrade register user to vip user
	@GetMapping("/customerUpgrade")
	public String gradeTmpCustomer(@RequestParam("customerId") int customerId) {
		
		TmpCustomer customer = tmpCustomerService.getCustomer(customerId);
		
		Customer vipCustomer = new Customer(customer.getUserTrueName(),customer.getUserNickname(),customer.getUserPassword(),customer.getUserSex(),customer.getUserPhone(),customer.getUserAddress(),customer.getUserIdentification(),customer.getUserEmail());
		
		customerService.saveCustomer(vipCustomer);
		
		tmpCustomerService.deleteCustomer(customerId);
		
		return "redirect:/admin/showRegisterCustomer";
	}
	
	// delete the vip users
	@GetMapping("/vipCustomerDelete")
	public String customerDelete(@RequestParam("customerId") int theId) {
		
		// delete the customer
		customerService.deleteCustomer(theId);
		
		return "redirect:/admin/showSuperCustomer";
	}
	
	// show modify the vip user page
	@GetMapping("/vipCustomerUpgrade")
	public String customerUpgrade(@RequestParam("customerId") int theId,Model theModel) {
		
		// get the customer form our service
		Customer theCustomer = customerService.getCustomer(theId );
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer",theCustomer);
		
		// send over to our form
		return "customer-form";
	}
	
	// upgrade user's information after modify action
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		// save the customer using our service
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/admin/showSuperCustomer";
	}
	
	// show the commodity list
	@RequestMapping(value="/showCommodityList")
	public String showCommodityList(Model model) {
		
		List<Commodity> commodity = commodityService.getCommodity();
		
		model.addAttribute("Commodity", commodity);
		
		System.out.println(commodity);
		
		return "admin/showAllCommodity";
		
		
	}
	
	// show unsure the order list
	@RequestMapping(value="/showUnfinshiedList")
	public String showUnfinshiedList(Model model) {
		
		List<OrderList> order = orderListService.getOrderList();
		
		model.addAttribute("OrderList",order);
		
		return "admin/showListWaittingToHandle";
	}
	
	// handle order
	@RequestMapping(value="/handleOrder")
	public String handleOrder(@RequestParam("orderId") int theId,Model theModel) {
		
		orderListService.updateOrderList(theId);
		
		return "redirect:/admin/showUnfinshiedList";
	}
	
	// show finished order list
	@RequestMapping(value="/showFinishList")
	public String showFinishList(Model model) {
		
		List<OrderList> order = orderListService.getFinishedLists();
		
		System.out.println(order);
		
		model.addAttribute("OrderList",order);
		
		return "admin/showList";
	}
	
	// show all order list
	@RequestMapping(value="/showAllList")
	public String showAllList(Model model) {
		
		List<OrderList> order = orderListService.getAllLists();
		
		model.addAttribute("OrderList",order);
		
		return "admin/showList";
	}
	
	@RequestMapping(value="/addProduct")
	public String addProduct() {
		return "admin/admin-addProduct";
	}
	
	@RequestMapping(value="/productModelHandle")
	public String productModelHandle(
			MultipartFile pic,
			@RequestParam("commodityId") String commodityId,
			@RequestParam("commodityName") String commodityName,
			@RequestParam("commodityType") String commodityType,
			@RequestParam("commodityFitPeople") String commodityFitPeople,
			@RequestParam("commodityColor") String commodityColor,
			@RequestParam("commoditySeason") String commoditySeason,
			@RequestParam("inStock") String inStock,
			@RequestParam("commodityPrice") String commodityPrice,
			@RequestParam("commoditySex") String commoditySex,
			@RequestParam("commodityDescription") String commodityDescription,
			@RequestParam("commodityNumber") String commodityNumber
			)throws IllegalStateException, IOException {
		
		double CommodityPrice = Double.parseDouble(commodityPrice);
		
		int CommodityNumber = Integer.parseInt(commodityNumber);
		
		String filePath;
		
		if (!pic.isEmpty()) {
			
            String path = "D:\\JavaEEwork\\ShoeShop\\WebContent\\Resources\\images\\";
            String originalFileName = pic.getOriginalFilename();
            // 新的图片名称
            String newFileName = UUID.randomUUID() + originalFileName.substring(originalFileName.lastIndexOf("."));
            // 新的图片
            File newFile = new File(path + newFileName);
            // 将内存中的数据写入磁盘
            pic.transferTo(newFile);
            
            filePath = newFileName;
            
            Commodity newCommodity = new Commodity(commodityId,commodityName,  commodityFitPeople,
   				 commodityColor,  commoditySeason,  inStock,  CommodityPrice,
   				 commoditySex,  commodityDescription,  CommodityNumber,  filePath,commodityType);
            
            commodityService.saveCommodity(newCommodity);
            
            System.out.println(filePath);
        }
		
		
		return "redirect:/admin/showCommodityList";
	}
	
	// Show all suggestion
	@RequestMapping(value="/showAllSuggestion")
	public String showAllSuggestion(Model model) {
		
		List<Suggestion> suggestions = suggestionService.getAllSuggestions();
		
		model.addAttribute("Suggestions",suggestions);
		
		return "admin/admin-showAllSuggestion";
	}
	
	// show unfinished suggestion
	@RequestMapping(value="/showUnfinshedSuggestion")
	public String showUnfinshedSuggestion(Model model) {
		
		List<Suggestion> suggestions = suggestionService.getUnfinshedSuggestions();
		
		model.addAttribute("Suggestions",suggestions);
		
		return "admin/admin-showAllSuggestion";
		
	}
	
	// Delete suggestion
	@RequestMapping(value="/suggestionDelete")
	public String suggestionDelete(@RequestParam("suggestionId") int theId) {
		
		suggestionService.deleteSuggestion(theId);
		
		return "redirect:/admin/showAllSuggestion";
	}
	
	// reply suggestion
	@RequestMapping(value="/suggestionReply")
	public String suggestionReply(@RequestParam("suggestionId") int theId,Model theModel) {
		
		Suggestion suggestion = suggestionService.getSuggestion(theId);
		
		theModel.addAttribute("suggestion",suggestion);
		
		return "admin/admin-suggestionReply";
		
	}
	
	// handle suggestion
	@RequestMapping(value="/handleSuggestion")
	public String handleSuggestion(@RequestParam("comments") String comment,
			@RequestParam("suggestionId") String suggestionid,
			@RequestParam("toUser") String  toUser) {
		
		int id = Integer.parseInt(suggestionid);
		
		System.out.println(id);
		
		Reply reply = new Reply(comment,id,toUser);
		
		System.out.println(reply);
		
		replyService.saveReply(reply);
		
		suggestionService.handleSuggestion(id);
		
		return "redirect:/admin/showUnfinshedSuggestion";
	}
	
	// edit category(add , delete)
	@RequestMapping(value="/editCategory")
	public String editCategory(Model model) {
		
		List<Category> allCategory = categoryService.getAllCategory();
		
		model.addAttribute("allCategory",allCategory);
		
		return "admin/admin-Category";
	}
	
	@RequestMapping(value="/categoryDelete")
	public String categoryDelete(@RequestParam("categoryId") int categoryId) {
		
		System.out.println(categoryId);
		
		categoryService.deleteCategory(categoryId);
		
		return "redirect:/admin/editCategory";
		
	}
	
	@RequestMapping(value="/categoryAdd")
	public String categoryAdd(@RequestParam("CategoryName") String CategoryName) {
		
		System.out.println(CategoryName);
		
		Category category = new Category(CategoryName);
		
		categoryService.saveCategory(category);
		
		return "redirect:/admin/editCategory";
	}
	
	//statistical part
	@RequestMapping(value="/monthAmount")
	public String monthAmount(Model model){
		
		Statistical statistic = new Statistical();
				
		int momentMonth = statistic.getMonth();
		
		List<Double> sumList = new ArrayList();
		
		List<OrderList> order = orderListService.getAllLists();
		
		List<String> months = new ArrayList();
		
		for(int i=0;i<12;i++) {
			
			sumList.add(statistic.GetSameDate_Month(1+i, order));
					
		}
		
		for(int i=0;i<12;i++) {
			
			int month = 1 + i;
			
			months.add(month + "月");
		}
		
		model.addAttribute("amountLists",sumList);
		
		model.addAttribute("month",months);
		
		return "statistical/Month";
	}
	
	// recent seven days 
	@RequestMapping(value="/daysAmount")
	public String daysAmount(Model model){
		
		Statistical statistic = new Statistical();
		
		int momentDay = statistic.getMomentDay();
		
		int momentMonth = statistic.getMonth();
		
		List<Double> sumList = new ArrayList();
		
		List<String> days = new ArrayList();
		
		List<OrderList> order = orderListService.getAllLists();
		
		for(int i=0;i<7;i++) {
			
			sumList.add(statistic.GetSameDate_Day(momentMonth, momentDay-6+i, order));
					
		}
		
		for(int i=0;i<7;i++) {
			
			int d = momentDay-6+i ;
			
			days.add(momentMonth + "月" + d + "日");
		}
		
		model.addAttribute("amountLists",sumList);
		
		model.addAttribute("day",days);
		
		
		return "statistical/SevenDay";
	}
	
	// different kinds statistics
	@RequestMapping(value="/kindsAmount")
	public String kindAmount(Model model) {
		
		Statistical sta = new Statistical();
		
		List info = sta.statisticalAllKinds(orderListService.getAllLists());
		
		List<String> kinds = (List<String>) info.get(0);
		
		List<Double> Sums = (List<Double>) info.get(1);
		
		System.out.println(info);
		
		System.out.println(kinds);
		
		System.out.println(Sums);
		
		model.addAttribute("amountLists",Sums);
		
		model.addAttribute("kindList",kinds);
		
		return "statistical/kinds";
	}
	
	// customers statistics
	@RequestMapping(value="/customerAmount")
	public String customerAmount(Model model) {

		Statistical sta = new Statistical();
		
		List info = sta.statisticalAllCustomers(orderListService.getAllLists());
		
		List<String> kinds = (List<String>) info.get(0);
		
		List<Double> Sums = (List<Double>) info.get(1);
		
		System.out.println(info);
		
		System.out.println(kinds);
		
		System.out.println(Sums);
		
		model.addAttribute("amountLists",Sums);
		
		model.addAttribute("kindList",kinds);
		
		return "statistical/customer";
	}
	
	//inventory part
	@RequestMapping(value="/ShowAllCommodityNumber")
	public String ShowAllCommodityNumber(Model model) {
		
		List<Commodity> commodities = commodityService.getCommodity();
		
		model.addAttribute("Commodity", commodities);
		
		return "inventory/AllCommodityNumber";
	}

	@RequestMapping(value="/ShowInadequateNumber")
	public String ShowInadequateNumber(Model model) {
		
		List<Commodity> commodities = commodityService.getCommodity();
		
		List<Commodity> Commodity = new ArrayList();
		
		for(int i=0;i<commodities.size();i++) {
			if(commodities.get(i).getCommodityNumber()<=100) {
				Commodity.add(commodities.get(i));
			}
		}
		
		model.addAttribute("Commodity", Commodity);
		
		return "inventory/AllCommodityNumber";
	}
	
	@RequestMapping(value="/AddCommodityNumber")
	public String AddCommodityNumber(Model model) {
		
		return "inventory/AddCommodityNumber";
	}
	
	@RequestMapping(value="/HandleCommodityNumber")
	public String HandleCommodityNumber(@RequestParam("id") String commodityId,
			@RequestParam("number") String commodityNumber) {
		
		Commodity commodity = commodityService.getCommodity(commodityId);
		
		int num = commodity.getCommodityNumber() + Integer.parseInt(commodityNumber);
		
		commodity.setCommodityNumber(num);
		
		commodityService.saveCommodity(commodity);
		
		return "redirect:/admin/ShowAllCommodityNumber";
	}

}
