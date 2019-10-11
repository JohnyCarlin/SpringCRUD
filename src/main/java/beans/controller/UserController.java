package beans.controller;

import beans.AppPages;
import beans.entity.User;
import beans.exception.SomethingWrongException;
import beans.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String home() {
        return "redirect:/";
    }

    @GetMapping("/")
    public ModelAndView getHome() throws SomethingWrongException {
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("users", userService.getAllUsers());
        return new ModelAndView(AppPages.LIST, modelMap);
    }

    @GetMapping("new")
    public ModelAndView getNew() {
        return new ModelAndView(AppPages.CREATE);
    }

    @GetMapping("edit")
    public ModelAndView getEdit(@ModelAttribute("id") Integer id) throws SomethingWrongException {
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("user", userService.getUserByID(id));
        return new ModelAndView(AppPages.CREATE, modelMap);
    }

    @GetMapping("delete")
    public String getDelete(@ModelAttribute("id") Integer id) throws SomethingWrongException {
        userService.removeUser(id);
        return AppPages.redirect(AppPages.LIST);
    }

    @PostMapping("update")
    public String updateUser(@ModelAttribute("user") User user) throws SomethingWrongException {
        System.out.println(user);
        userService.editExistingUser(user);
        return AppPages.redirect(AppPages.LIST);
    }

    @PostMapping("insert")
    public String insertUser(@ModelAttribute("user") User user) throws SomethingWrongException {
        System.out.println(user);
        userService.addNewUser(user);
        return AppPages.redirect(AppPages.LIST);
    }
}
