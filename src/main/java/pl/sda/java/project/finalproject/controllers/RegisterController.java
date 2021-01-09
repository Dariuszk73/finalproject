package pl.sda.java.project.finalproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.java.project.finalproject.dtos.NewUserForm;
import pl.sda.java.project.finalproject.services.UserService;
import javax.validation.Valid;

@Controller
public class RegisterController {
    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        final NewUserForm newUserForm = new NewUserForm();
        model.addAttribute("newUserForm", newUserForm);
        return "registerForm";
    }

    @PostMapping("/register")
    public String submitRegisterForm(@ModelAttribute @Valid NewUserForm newUserForm,
                                     BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "registerForm";
        }
        userService.registerUser(newUserForm);
        return "registeredUserThankyouPage";
    }
}
