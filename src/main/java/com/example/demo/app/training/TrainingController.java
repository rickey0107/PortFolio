package com.example.demo.app.training;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Training;
import com.example.demo.service.TrainingService;

@Controller
@RequestMapping("/training")
public class TrainingController {

	private final TrainingService trainingService;

	@Autowired
	public TrainingController(TrainingService trainingService) {
		this.trainingService = trainingService;
	}

	@GetMapping
	public String index(Model model) {
		List<Training> list = trainingService.getAll();

		model.addAttribute("trainingList", list);
		model.addAttribute("title", "Training Index");

		return "training/index";
	}

	@GetMapping("/form") //URLでアクセス。
	public String form(TrainingForm trainigForm,
			Model model,
			@ModelAttribute("complete") String complete) { //フラッシュスコープの値をHTMLでレンダリング可能に。
		model.addAttribute("title", "LET'S REGISTER!"); //titleをHTMLに送る。
		return "training/form_boot"; //trainingフォルダのform.html。
	}

	@PostMapping("/form") //戻るボタンからデータが飛んできた場合。
	public String formGoBack(TrainingForm trainigForm, Model model) {
		model.addAttribute("title", "LET'S REGISTER!"); //titleをHTMLに送る。
		return "training/form_boot"; //trainingフォルダのform.html。
	}

	@PostMapping("/confirm") //登録ページからデータが飛んできた場合。
	public String confirm(@Validated TrainingForm trainingForm,
			BindingResult result,
			Model model) {
		//エラーがあった場合。
		if(result.hasErrors()) {
			model.addAttribute("title", "LET'S REGISTER!");
			return "training/form_boot";
		}
		//エラーが無かった場合。
		model.addAttribute("title", "Check it out!");
		return "training/confirm_boot";
	}

	@PostMapping("/complete") //確認ページからデータが飛んできた場合。
	public String complete(@Validated TrainingForm trainingForm,
			BindingResult result,
			Model model,
			RedirectAttributes redirectAttributes) { //フラッシュスコープを使う為のクラス。
		if(result.hasErrors()) {
			model.addAttribute("title", "Complete!");
			return "training/form_boot";
		}

		Training training = new Training();
		training.setPart     (trainingForm.getPart());
		training.setMenu     (trainingForm.getMenu());
		training.setDatetime (LocalDateTime.now());

		trainingService.save(training);
		redirectAttributes.addFlashAttribute("complete", "完了"); //「完了」が1回表示されるとセッションのデータが破棄される。
		return "redirect:/training/form"; //HTMLでは無く、URLを指している。
	}

}
