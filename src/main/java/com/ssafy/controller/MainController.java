package com.ssafy.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.service.ConsumeService;
import com.ssafy.service.FoodService;
import com.ssafy.service.MemberService;
import com.ssafy.util.KMPFunction;
import com.ssafy.vo.Food;
import com.ssafy.vo.FoodPageBean;
import com.ssafy.vo.Member;

@Controller
public class MainController {
	@Autowired
	private ConsumeService cservice;
	@Autowired
	private FoodService fservice;
	@Autowired
	private MemberService mservice;
	
	@ExceptionHandler
	public ModelAndView handler(Exception e) {
		ModelAndView mav = new ModelAndView("Error");
		mav.addObject("msg", e.getMessage());
		return mav;
	}
	
	@GetMapping("mainform.do")
	public String mainform() {
		return "index";
	}
	
	@PostMapping("login.do")
	public String login(String id, String pw, HttpSession session) {
		boolean result = mservice.login(id, pw);
		if(result) {
			session.setAttribute("id", id);
		}
		return "redirect:mainform.do";
	}
	@GetMapping("logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:mainform.do";
	}
	@PostMapping("memberinsert.do")
	public String memberinsert(Member mem) {
		System.out.println("meminsert---------"+mem.getAllergy());
		mservice.add(mem);
		return "redirect:mainform.do";
	}
	
	@GetMapping("memberinfo.do")
	public String memberinfo(String id, Model model) {
		model.addAttribute("member", mservice.search(id));
		return "main.do?action=userinfoForm.do";
	}
	
	@GetMapping("userinfoForm.do")
	public String userinfoForm() {
		return "userInformation";
	}
	
	@DeleteMapping("userDelete.do")
	public String userDelete(String id) {
		mservice.remove(id);
		return "redirect:mainform.do";
	}
	
	@PostMapping("userUpdate.do")
	public String userUpdate(Member member) {
		mservice.update(member);
		return "main.do?action=memberinfo.do";
	}
	
	@GetMapping("foodList.do")
	public String foodList(String key, String word, Model model) {
		System.out.println(key + " " + word);
		List<Food> result = new ArrayList<>();
		List<Food> list = new ArrayList<>();

		list = fservice.searchAll(new FoodPageBean());
		switch (key) {
		case "name":
			for (Food food : list) {
				if (KMPFunction.KMP(food.getName(), word))
					result.add(food);
			}
			break;
		case "maker":
			for (Food food : list) {
				if (KMPFunction.KMP(food.getMaker(), word))
					result.add(food);
			}
			break;
		case "material":
			for (Food food : list) {
				if (KMPFunction.KMP(food.getMaterial(), word))
					result.add(food);
			}
			break;
		default:
			result = list;
			break;
		}
		model.addAttribute("foodList", result);
		return "mainform.do";
	}
	@GetMapping("itemInfor.do")
	public String itemInfor(String code, Model model) {
		Food food = fservice.search(Integer.parseInt(code));
		model.addAttribute("item",food);
		return "itemInformation";
	}
	@GetMapping("list.do")
	public String list(Model model) {
		List<Food> list = new ArrayList<>();
		list = fservice.searchAll(new FoodPageBean());
		model.addAttribute("foodList", list);
		return "itemList";
	}
	@GetMapping("foodList2.do")
	public String foodList2(String key,String word, Model model) {
		FoodPageBean bean = new FoodPageBean(key, word, "", 0);
		model.addAttribute("bean", bean);
		List<Food> list = new ArrayList<>();
		list = fservice.searchAll(bean);
		model.addAttribute("foodList", list);
		return "itemList";
	}
	@GetMapping("findPassword.do")
	public String findPassword(String id,String phone, Model model) {
		Member member = mservice.search(id);
		String password="";
		if (member.getPhone().equals(phone)) {
			password = member.getPassword();
			model.addAttribute("id", id);
			model.addAttribute("password", password);

			model.addAttribute("member", member);
			return "main.do?action=userinfoForm.do";
		}
		return "mainform.do";
	}
	@GetMapping("insertcart.do")
	public String insertcart(String code,String phone, HttpSession session) {
		Food food = fservice.search(Integer.parseInt(code));
		
		ArrayList<Food> consumelist = (ArrayList<Food>) session.getAttribute("consumelist");
		if (consumelist == null) {
			consumelist = new ArrayList<Food>();
		}
		boolean flag = false;
		for (int i = 0; i < consumelist.size(); i++) {
			Food cur = consumelist.get(i);
			if (cur.getCode() == Integer.parseInt(code)) {
				flag = true;
				break;
			}
		}
		if (flag != true)
			consumelist.add(food);
		session.setAttribute("consumelist", consumelist);
		
		return "main.do?action=list.do";
	}
	@GetMapping("consumeList.do")
	public String consumeList(Model model, HttpSession session) {
		List<Food> list = new ArrayList<>();
		list = (List<Food>) session.getAttribute("consumelist");
		model.addAttribute("consumeList", list);
		
		return "consumeList";
	}
	
	
}