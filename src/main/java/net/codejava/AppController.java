package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import semesterprojekt.dal.DbSql;
import semesterprojekt.model.Cat;
import semesterprojekt.model.Member;

@Controller
public class AppController {

	@Autowired
	private UserRepository userRepo;

	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}

	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());

		return "signup_form";
	}

	@GetMapping("/welcome")
	public String showWelcomePage() {
		return "loggedin";
	}

	@PostMapping("/welcome")
	public String processRegister(User User) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(User.getPassword());
		User.setPassword(encodedPassword);

		userRepo.save(User);

		return "loggedin";
	}

	/*@PostMapping("/loggedin")
	public String processLogin(User User) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(User.getPassword());
		User.setPassword(encodedPassword);


		return "loggedin";
	}*/
	@GetMapping ("/loggedin")
	public String frontPage() {
		return "loggedin";
	}

	@GetMapping("/users")
	public String listUsers(Model model) {
		List<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);
		return "users";
	}

		@GetMapping("/profile")
		public String showProfilePage() {
			return "profile";
		}
		@GetMapping("/editCats")
				public String showManageCats(){
		return "editCats";
		}
		@GetMapping("/meetings")
				public String viewMeetings(){
		return "meetings";
		}
		@GetMapping ("/about")
				public String aboutUs(){
		return "about";
		}
	@GetMapping ("/cats")
	public String catInventory(){
		return "cats";
	}
	@GetMapping ("/createCat")
	public String createNewCat(){
		return "createCat";
	}
	@GetMapping ("/memberList")
	public String showMemberList	(){

		return "memberList";
	}

	DbSql dbSql = new DbSql();
	@PostMapping("/update_profile")
	public String updateProfile(@ModelAttribute("member") Member member) {
		try {
			dbSql.updateMember(member);
		} catch (Exception e) {
			// Handle database operation errors
			e.printStackTrace();
			// Redirect to an error page or show an error message
			return "redirect:/error";
		}
		return "redirect:/profile";
	}

	@PostMapping("/add_cat")
	public String addCat(@ModelAttribute("cat") Cat cat) {
		try {
			dbSql.createCat(cat.getCatid(), cat.getName(), cat.getWeight(), cat.getBreed(), cat.getGender());
		} catch (Exception e) {
			// Handle database operation errors
			e.printStackTrace();
			// Redirect to an error page or show an error message
			return "redirect:/error";
		}
		return "redirect:/profile";
	}

	@PostMapping("/update_cat")
	public String updateCat(@ModelAttribute("cat") Cat cat) {
		try {
			dbSql.updateCat(cat);
		} catch (Exception e) {
			// Handle database operation errors
			e.printStackTrace();
			// Redirect to an error page or show an error message
			return "redirect:/error";
		}
		return "redirect:/profile";
	}

	@PostMapping("/delete_cat")
	public String deleteCat(@RequestParam("catId") int catId) {
		try {
			dbSql.deleteCat(catId);
		} catch (Exception e) {
			// Handle database operation errors
			e.printStackTrace();
			// Redirect to an error page or show an error message
			return "redirect:/error";
		}
		return "redirect:/profile";
	}
	@PostMapping("/cat/save")
	public String saveCat(@ModelAttribute Cat cat){
		DbSql db = new DbSql();
		db.save(cat);
		return "redirect:/profile";
	}
}