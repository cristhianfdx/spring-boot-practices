package com.cdgz.crudspringmvc.app.controller;

import com.cdgz.crudspringmvc.app.controller.DTO.EmployeeDTO;
import com.cdgz.crudspringmvc.domain.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {

    public static final String INDEX_VIEW_NAME = "index";
    public static final String REDIRECT_TO_VIEW_NAME = "redirect:/";

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String getAll(Model model) {
        List<EmployeeDTO> employeeList = employeeService.getAll();
        setModel(model, "employees", employeeList);
        return INDEX_VIEW_NAME;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute(value = "employee") EmployeeDTO employeeDTO) {
        employeeService.create(employeeDTO);
        return REDIRECT_TO_VIEW_NAME;
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView update(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit");
        EmployeeDTO employeeDTO = employeeService.getById(id);
        mav.addObject("employee", employeeDTO);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        employeeService.delete(id);
        return REDIRECT_TO_VIEW_NAME;
    }

    private void setModel(Model model, String attributeName, Object attributeValue) {
        model.addAttribute(attributeName, attributeValue);
    }
}
