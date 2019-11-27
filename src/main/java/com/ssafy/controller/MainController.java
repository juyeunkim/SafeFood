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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.ssafy.email.Email;
import com.ssafy.email.EmailSender;
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

	@Autowired
	private EmailSender emailSender;
	@Autowired
	private Email mail;

	@PostMapping("/sendpw.do")
	public String sendEmailAction(String id,String email ) throws Exception {
		
		Member member = mservice.search(id);
		String pw = member.getPassword();
		System.out.println(pw);
		Gson gson = new Gson();
		if (pw != null && email.equals(member.getEmail())) {
			mail.setContent("비밀번호는 " + pw + " 입니다.");
			mail.setReceiver(email);
			mail.setSubject(id + "님 비밀번호 찾기 메일입니다.");
			emailSender.SendEmail(mail);
			return gson.toJson(member);
		} else if(pw==null){
			return gson.toJson("id");
		} else
			return gson.toJson("email");
	}

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
	public String login(String loginid, String loginpsw, HttpSession session) {
		boolean result = mservice.login(loginid, loginpsw);
		if (result) {
			session.setAttribute("id", loginid);
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
		Date date = new Date(System.currentTimeMillis());
		System.out.println(key + " " + word);
		List<Food> result = new ArrayList<>();
		List<Food> list = new ArrayList<>();

		list = fservice.searchAll(new FoodPageBean());
		if (!key.equals("all")) {
			sservice.insert(new SearchEngine(key, word,date.toString()));
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
		Date date = new Date(System.currentTimeMillis());
		System.out.println("foodlist2.do.......................");
		FoodPageBean bean = new FoodPageBean(key, word, "", 0);
		model.addAttribute("bean", bean);
		model.addAttribute("key", key);
		model.addAttribute("word", word);
		List<Food> list = new ArrayList<>();
		list = fservice.searchAll(bean);
		if (!key.equals("all")) {
			sservice.insert(new SearchEngine(key, word,date.toString()));
		}
		model.addAttribute("foodList", list);
		return "itemList";
	}

	@PostMapping("findPassword.do")
	@ResponseBody
	public String findPassword(String id, String email) throws Exception {
		System.out.println("=======findPassword=======");
		System.out.println(id + " " + email);

		ModelAndView mav;
		// id로 비밀번호 찾아서 - mail로 비밀번호 전송
		Member member = mservice.search(id);

		Gson gson = new Gson();
		if(member==null){
			return gson.toJson("id");
		}else if (!email.equals(member.getEmail())) {
			return gson.toJson("email");
		} else {
			return gson.toJson(member);
		}
//		EmailServiceImpl es=new EmailServiceImpl();
//		es.setJavaMailSender(javaMailSender);
//		es.sendSimpleMessage(member.getEmail(),"비밀번호 찾기" , member.getPassword());

	}
	
	// prefer에서 consume으로 저장
	@GetMapping("insertconsume.do")
	public String insertconsume(@RequestParam int num) {
		System.out.println("insertconsume.do.......................");
		
		// num을 통해서 id와 code count를 가져오기
		Prefer p = pservice.search(num);
		cservice.insert(new Consume(p.getId(), p.getCode(), "", p.getCount()));
		
		// pservice에서 delete
		pservice.delete(num);
		
		return "redirect:preferList.do";
	}
	
	
	@GetMapping("insertfood.do")
	public String insertfood(@RequestParam String code, @RequestParam String count,@RequestParam String date, HttpSession session, Model model) {
		System.out.println("insertfood.do.......................");
		Food food = fservice.search(Integer.parseInt(code));
		String id = (String) session.getAttribute("id");
		String id_alergy[] = mservice.searchAllergy(id).split(" ");
		String food_alergy[] = fservice.searchAllergy(Integer.parseInt(code)).split(",");
		List<String> danger_alergy = new ArrayList<String>();
		List<String> dangerfood = new ArrayList<String>();
		StringBuilder danger = new StringBuilder();
		List<Food> foodlist = new ArrayList<>();
		foodlist = fservice.searchAll(new FoodPageBean());
		if (food_alergy.length != 0) {
			for (int i = 0; i < id_alergy.length; i++) {
				for (int j = 0; j < food_alergy.length; j++) {
					if (id_alergy[i].equals(food_alergy[j])) {
						danger_alergy.add(food_alergy[j]);
					}
				}
			}
		}
		System.out.println(date.toString());
		Consume eat = new Consume(id, Integer.parseInt(code), date.toString(), Integer.parseInt(count));
		if (danger_alergy.size() > 0) {
			for (int i = 0; i < danger_alergy.size(); i++) {
				danger.append(danger_alergy.get(i) + " ");
			}
			for (int i = 0; i < foodlist.size(); i++) {
				Food f = foodlist.get(i);
				for (int j = 0; j < danger_alergy.size(); j++) {
					if (f.getAllergy().contains(danger_alergy.get(j))) {
						dangerfood.add(f.getName());
					}
				}
			}
			if (dangerfood.size() > 0) {
				StringBuilder dangerfoodlist = new StringBuilder();
				for (int i = 0; i < dangerfood.size(); i++) {
					if (i != dangerfood.size() - 1) {
						dangerfoodlist.append(dangerfood.get(i) + ", ");
					} else {
						dangerfoodlist.append(dangerfood.get(i) + " ");
					}
				}
				System.out.println(dangerfoodlist.toString());
				model.addAttribute("dangerfoodlist", dangerfoodlist);
			}

			model.addAttribute("dangermsg", danger);
			model.addAttribute("foodname", food.getName());
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
		Food food = fservice.search(Integer.parseInt(code));
		String id = (String) session.getAttribute("id");
		String id_alergy[] = mservice.searchAllergy(id).split(" ");
		String food_alergy[] = fservice.searchAllergy(Integer.parseInt(code)).split(",");
		List<String> danger_alergy = new ArrayList<String>();
		List<String> dangerfood = new ArrayList<String>();
		StringBuilder danger = new StringBuilder();
		List<Food> foodlist = new ArrayList<>();
		foodlist = fservice.searchAll(new FoodPageBean());
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
			for (int i = 0; i < foodlist.size(); i++) {
				Food f = foodlist.get(i);
				for (int j = 0; j < danger_alergy.size(); j++) {
					if (f.getAllergy().contains(danger_alergy.get(j))) {
						dangerfood.add(f.getName());
					}
				}
			}
			if (dangerfood.size() > 0) {
				StringBuilder dangerfoodlist = new StringBuilder();
				for (int i = 0; i < dangerfood.size(); i++) {
					if (i != dangerfood.size() - 1) {
						dangerfoodlist.append(dangerfood.get(i) + ", ");
					} else {
						dangerfoodlist.append(dangerfood.get(i) + " ");
					}
				}
				System.out.println(dangerfoodlist.toString());
				model.addAttribute("dangerfoodlist", dangerfoodlist);
			}

			model.addAttribute("dangermsg", danger);
			model.addAttribute("foodname", food.getName());
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
		int calory = 0, carbo = 0, protein = 0, fat = 0, sugar = 0, natrium = 0, chole = 0, fattyacid = 0, transfat = 0;
		for (int i = 0; i < sevendaylist.size(); i++) {
			Consume c = sevendaylist.get(i);
			Food f = fservice.search(c.getCode());
			calory += f.getCalory() * c.getCount();
			carbo += f.getCarbo() * c.getCount();
			protein += f.getProtein() * c.getCount();
			fat += f.getFat() * c.getCount();
			sugar += f.getSugar() * c.getCount();
			natrium += f.getNatrium() * c.getCount();
			chole += f.getChole() * c.getCount();
			fattyacid += f.getFattyacid() * c.getCount();
			transfat += f.getTransfat() * c.getCount();
		}
		model.addAttribute("myList", list);
		model.addAttribute("topList", toplist);
		model.addAttribute("sevendayList", sevendaylist);
		model.addAttribute("calory", calory);
		model.addAttribute("carbo", carbo);
		model.addAttribute("protein", protein);
		model.addAttribute("fat", fat);
		model.addAttribute("sugar", sugar);
		model.addAttribute("natrium", natrium);
		model.addAttribute("chole", chole);
		model.addAttribute("fattyacid", fattyacid);
		model.addAttribute("transfat", transfat);

		return "consumeList";
	}

	@GetMapping("searchengine.do")
	public String searchengineList(Model model, HttpSession session) {
		System.out.println("searchengineList.do.......................");
		List<SearchEngine> list = sservice.searchAll();
		List<SearchEngine> topsearchlist = sservice.count();

		for (int i = 0; i < list.size(); i++) {
			System.out.println(
					list.get(i).getSearch_key() + " " + list.get(i).getSearch_value() + " " + list.get(i).getCnt());
		}
		System.out.println("검색리스트 목록" + topsearchlist.size());
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
		System.out.println("deletePrefer.do......................." + num);
		pservice.delete(num);

		return "redirect:preferList.do";
	}

	@GetMapping("deleteConsume.do")
	public String deleteConsume(@RequestParam int num) {
		System.out.println("deleteConsume.do......................." + num);
		cservice.delete(num);

		return "redirect:consumeList.do";
	}

}
