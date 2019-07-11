package com.example.Controller;

import com.example.DAO.StudentDAO;
import com.example.Model.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
public class StuudentEnrollmentController {

    @Autowired
    StudentDAO studentDAO;

   @RequestMapping(value="/enroll/", method= RequestMethod.GET)
   // @GetMapping(value ="/enroll")
    //@PostMapping(value ="/enroll")
    public String  newRegistration(ModelMap model) {
        StudentEntity student = new StudentEntity();
        model.addAttribute("student", student);
        return "Enrolled";
    } // newRegistration ends

    @RequestMapping(value="/save", method= RequestMethod.POST)
    public String saveRegistration(
            @Valid StudentEntity student ,
            BindingResult result,
            ModelMap model,
            RedirectAttributes redirectAttributes) {
        if(result.hasErrors()) {
            System.out.println("Has Errors");
            return "enroll";
        }
        studentDAO.save(student);
        return "redirect:/viewstudents";
    }  // saveRegistration ends
            @RequestMapping(value = "/viewstudents")
    public ModelAndView getAll() {
                List<StudentEntity> findAll = studentDAO.findAll();
                return  new ModelAndView("viewstudents","list", findAll);
    }
    @RequestMapping(value = "/editstudent/{id}")
    public String edit(@PathVariable int id , ModelMap model) {
        StudentEntity student = studentDAO.findOne(id);

        model.addAttribute("student", student);
        return("editstudent");
    }
    @RequestMapping(value="/editsave",method=RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute ( "student") StudentEntity p) {
        StudentEntity student = studentDAO.findOne(p.getId());

          student.setFirstName(p.getFirstName());
          student.setLastName((p.getLastName()));
          student.setEmail(p.getEmail());
          student.setCountry(p.getCountry());
          student.setSex(p.getSex());
          student.setSection(p.getSection());
          student.setCreatedAt(p.getCreatedAt());
          studentDAO.save(student);

          return new ModelAndView("redirect:/viewstudents");
    }
    @RequestMapping(value="/deletestudent/{id}",method=RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id) {
        StudentEntity student = studentDAO.findOne(id);
        studentDAO.delete(student);
        return new ModelAndView(("redirect:/viewstudents"));
    }

    @ModelAttribute("sections")
    public List<String>  initializeSections() {
        List<String> sections = new ArrayList<String >();
        sections.add("Graduate");
        sections.add("Post Graduate");
        sections.add("Reasearch");
        return sections;
    }

    @ModelAttribute("countries")
    public List<String> initializeCountries() {

        List<String> countries = new ArrayList<String>();
        countries.add("INDIA");
        countries.add("USA");
        countries.add("CANADA");
        countries.add("FRANCE");
        countries.add("GERMANY");
        countries.add("ITALY");
        countries.add("OTHER");
        return countries;
    }
}
