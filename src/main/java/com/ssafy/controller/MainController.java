package com.ssafy.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.service.ConsumeService;
import com.ssafy.service.FoodService;
import com.ssafy.service.MemberService;
import com.ssafy.util.KMPFunction;
import com.ssafy.vo.Consume;
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
		if (result) {
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
	public String memberinsert(Member mem, HttpSession session) {
		session.setAttribute("id", mem.getId());
		mservice.add(mem);
		return "redirect:mainform.do";
	}

	@GetMapping("memberinfo.do")
	public String memberinfo(Model model, HttpSession session) {
		String id = (String) session.getAttribute("id");
		Member mem = mservice.search(id);
		model.addAttribute("member", mem);
		return "userInformation";
	}

	@GetMapping("userinfoForm.do")
	public String userinfoForm() {
		return "userInformation";
	}

	@GetMapping("userdelete.do")
	public String userdelete(HttpSession session) {
		String id = (String) session.getAttribute("id");
		session.invalidate();
		mservice.remove(id);
		return "redirect:mainform.do";
	}

	@PostMapping("userupdate.do")
	public String userupdate(Member member) {
		System.out.println("UPDATE BEFO-----" + member);
		mservice.update(member);

		System.out.println("UPDATE AFO-----" + member);
		return "userInformation";
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
		case "all":
			result = list;
			break;
		}
		model.addAttribute("foodList", result);
		return "mainform.do";
	}

	@GetMapping("itemInfor.do")
	public String itemInfor(@RequestParam String code, Model model) {
		Food food = fservice.search(Integer.parseInt(code));
		model.addAttribute("item", food);
		return "itemInformation";
	}

	@GetMapping("list.do")
	public String list(Model model) {
		List<Food> list = new ArrayList<>();
		list = fservice.searchAll(new FoodPageBean());
		model.addAttribute("foodList", list);
		return "itemList";
	}

// 검색어를 받아서 리스트에 보여주기
	@PostMapping("foodList2.do")
	public String foodList2(String key, String word, Model model) {
		FoodPageBean bean = new FoodPageBean(key, word, "", 0);
		model.addAttribute("bean", bean);
		model.addAttribute("key", key);
		model.addAttribute("word", word);
		List<Food> list = new ArrayList<>();
		list = fservice.searchAll(bean);
		model.addAttribute("foodList", list);
		return "itemList";
	}

	@PostMapping("findPassword.do")
	public String findPassword(String id, String phone, Model model) {
		Member member = mservice.search(id);
		String password = "";
		if (member.getPhone().equals(phone)) {
			password = member.getPassword();
			model.addAttribute("id", id);
			model.addAttribute("password", password);

			model.addAttribute("member", member);
			return "userinfoForm.do";
		}
		return "mainform.do";
	}

	@PostMapping("insertcart.do")
	public String insertcart(String code,int count, HttpSession session) {
		System.out.println("=======insert=======");
		// session에서 id 가져오기
		Date date = new Date(System.currentTimeMillis());
		String id = (String) session.getAttribute("id");
		Consume eat = new Consume(id, Integer.parseInt(code), date.toString(), count);

		System.out.println(count + " " + id + " " + code);
		cservice.insert(eat);

		return "redirect:list.do";
	}

	@GetMapping("consumeList.do")
	public String consumeList(Model model, HttpSession session) {
		
		String id = (String) session.getAttribute("id");
		// id가 먹은 foodlist 가져오기
		List<Consume> list = cservice.searchAll(id);
		Consume c = cservice.se
//		List<Food> flist = new ArrayList<>();
//		for(int i=0; i<list.size(); i++) {
//			Food f = fservice.search(list.get(i).getCode());
//			flist.add(f);
//		}
//		
//		model.addAttribute("consumeList", flist);
		model.addAttribute("myList", list);

		return "consumeList";
	}

}
