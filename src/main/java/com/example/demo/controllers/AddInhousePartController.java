package com.example.demo.controllers;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.Part;
import com.example.demo.service.InhousePartService;
import com.example.demo.service.InhousePartServiceImpl;
import com.example.demo.service.PartService;
import com.example.demo.service.PartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

/**
 *
 *
 *
 *
 */
@Controller
public class AddInhousePartController{
    private Set<Part> listParts = new HashSet<>();
    private boolean verify = false;

    @Autowired
    private ApplicationContext context;

    //send user to Inhouse Part form and add part to model
    @GetMapping("/showFormAddInPart")
    public String showFormAddInhousePart(Model theModel){
        InhousePart inhousepart=new InhousePart();
        theModel.addAttribute("inhousepart",inhousepart);
        return "InhousePartForm";
    }

    //submit part added by user and display confirmation
    @PostMapping("/showFormAddInPart")
    public String submitForm(@Valid @ModelAttribute("inhousepart") InhousePart part, BindingResult theBindingResult, Model theModel){
        theModel.addAttribute("inhousepart",part);
        if(theBindingResult.hasErrors()){
            return "InhousePartForm";
        }
        else{
        InhousePartService repo=context.getBean(InhousePartServiceImpl.class);
        InhousePart ip=repo.findById((int)part.getId());
        if(ip!=null)part.setProducts(ip.getProducts());

            //if there is already a part with the same name, create a multi-pack version
            for (Part thing : listParts) {
                if (thing.getName().equals(part.getName())) {
                    verify = true;
                } else {
                    verify = false;
                }
            }

            if (verify == true) {
                part.multiPart();
                listParts.add(part);
            } else {
                listParts.add(part);
            }

            repo.save(part);

        return "confirmationaddpart";}
    }

}
