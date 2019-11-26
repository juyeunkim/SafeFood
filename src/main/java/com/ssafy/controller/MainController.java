package com.ssafy.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.ssafy.service.ConsumeService;
import com.ssafy.service.FoodService;
import com.ssafy.service.MemberService;
import com.ssafy.service.PreferService;
import com.ssafy.service.SearchEngineService;
import com.ssafy.util.KMPFunction;
import com.ssafy.vo.Consume;
import com.ssafy.vo.Food;
import com.ssafy.vo.FoodPageBean;
import com.ssafy.vo.Member;
import com.ssafy.vo.Prefer;
import com.ssafy.vo.SearchEngine;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@Controller
public class MainController {
	@Autowired
	private ConsumeService cservice;
	@Autowired
	private FoodService fservice;
	@Autowired
	private MemberService mservice;
	@Autowired
	private PreferService pservice;
	@Autowired
	private SearchEngineService sservice;
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

	@GetMapping("getLoginInfo.do")
	@ResponseBody
	public Map getLoginInfo(HttpSession session) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		String id = (String) session.getAttribute("id");
		if (id != null) {
			map.put("status", true);
			map.put("id", id);
		} else {
			map.put("status", false);
		}

//		map.put("id", "ssafy");
//		map.put("status", true);
		System.out.println("Session가져오기 =======" + map);
		return map;
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
		System.out.println("foodList.do.......................");
		System.out.println(key + " " + word);
		List<Food> result = new ArrayList<>();
		List<Food> list = new ArrayList<>();
		
		list = fservice.searchAll(new FoodPageBean());
		if(!key.equals("all")) {
			sservice.insert(new SearchEngine(key,word));
		}
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
		System.out.println("itemInfor.do.......................");
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
		System.out.println("foodlist2.do.......................");
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
	@ResponseBody
	public String findPassword(String id, String phone) {
		System.out.println("=======findPassword=======");
		System.out.println(id + " " + phone);

		Member member = mservice.search(id);

		Gson gson = new Gson();
		return gson.toJson(member);
	}

	@GetMapping("insertfood.do")
	public String insertfood(@RequestParam String code, @RequestParam String count, HttpSession session, Model model) {
		System.out.println("insertfood.do.......................");
		Date date = new Date(System.currentTimeMillis());
		String id = (String) session.getAttribute("id");
		String id_alergy[] = mservice.searchAllergy(id).split(" ");
		String food_alergy[] = fservice.searchAllergy(Integer.parseInt(code)).split(",");
		List<String> danger_alergy = new ArrayList<String>();
		StringBuilder danger = new StringBuilder();
		if (food_alergy.length != 0) {
			for (int i = 0; i < id_alergy.length; i++) {
				for (int j = 0; j < food_alergy.length; j++) {
					if (id_alergy[i].equals(food_alergy[j])) {
						danger_alergy.add(food_alergy[j]);
					}
				}
			}
		}
		Consume eat = new Consume(id, Integer.parseInt(code), date.toString(), Integer.parseInt(count));
		if (danger_alergy.size() > 0) {
			for (int i = 0; i < danger_alergy.size(); i++) {
				danger.append(danger_alergy.get(i) + " ");
			}
			model.addAttribute("dangermsg", danger);
			return "itemList";
		} else {
			cservice.insert(eat);
			return "redirect:list.do";
		}
	}

	@GetMapping("preferfood.do")
	public String preferfood(@RequestParam String code, @RequestParam String count, HttpSession session, Model model) {
		System.out.println("preferfood.do.......................");
		Date date = new Date(System.currentTimeMillis());
		String id = (String) session.getAttribute("id");
		String id_alergy[] = mservice.searchAllergy(id).split(" ");
		String food_alergy[] = fservice.searchAllergy(Integer.parseInt(code)).split(",");
		List<String> danger_alergy = new ArrayList<String>();
		StringBuilder danger = new StringBuilder();
		if (food_alergy.length != 0) {
			for (int i = 0; i < id_alergy.length; i++) {
				for (int j = 0; j < food_alergy.length; j++) {
					if (id_alergy[i].equals(food_alergy[j])) {
						danger_alergy.add(food_alergy[j]);
					}
				}
			}
		}
		Prefer eat = new Prefer(id, Integer.parseInt(code), date.toString(), Integer.parseInt(count));
		if (danger_alergy.size() > 0) {
			for (int i = 0; i < danger_alergy.size(); i++) {
				danger.append(danger_alergy.get(i) + " ");
			}
			model.addAttribute("dangermsg", danger);
			return "itemList";
		} else {
			pservice.insert(eat);
			return "redirect:list.do";
		}
	}

	@GetMapping("consumeList.do")
	public String consumeList(Model model, HttpSession session) {
		System.out.println("consumeList.do.......................");
		String id = (String) session.getAttribute("id");
		List<Consume> list = cservice.searchAll(id);
		List<Consume> toplist = cservice.count(id);
		List<Consume> sevendaylist = cservice.searchAllseven(id);
		int calory, carbo,protein,fat,sugar, natrium,chole,fattyacid,transfat =0;
		for(int i=0; i<sevendaylist.size(); i++) {
			System.out.println((i+1)+":" + sevendaylist.get(i));
		}
		model.addAttribute("myList", list);
		model.addAttribute("topList", toplist);
		model.addAttribute("sevendayList", sevendaylist);

		return "consumeList";
	}
	@GetMapping("searchengine.do")
	public String searchengineList(Model model, HttpSession session) {
		System.out.println("searchengineList.do.......................");
		List<SearchEngine> list = sservice.searchAll();
		List<SearchEngine> topsearchlist = sservice.count();
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getSearch_key()+" " +list.get(i).getSearch_value()+" "+list.get(i).getCnt());
		}
		System.out.println("검색리스트 목록"+topsearchlist.size());
		model.addAttribute("searchList", list);
		model.addAttribute("topsearchList", topsearchlist);

		return "searchengineList";
	}
	@GetMapping("preferList.do")
	public String preferList(Model model, HttpSession session) {
		System.out.println("preferList.do.......................");
		String id = (String) session.getAttribute("id");
		List<Prefer> preferlist = pservice.searchAll(id);
		System.out.println(preferlist.toString());
		List<Prefer> toplist = pservice.count(id);

		model.addAttribute("myPreferList", preferlist);
		model.addAttribute("toppreferList", toplist);

		return "preferList";
	}
	
	@GetMapping("deletePrefer.do")
	public String deletePrefer(@RequestParam int num) {
		System.out.println("deletePrefer.do......................."+num);
		pservice.delete(num);

		return "redirect:preferList.do";
	}
	
	@GetMapping("deleteConsume.do")
	public String deleteConsume(@RequestParam int num) {
		System.out.println("deleteConsume.do......................."+num);
		cservice.delete(num);

		return "redirect:preferList.do";
	}
}
