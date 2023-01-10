package com.example.workflow.web;

import com.example.workflow.model.DTO.TaskDTO;
import com.example.workflow.model.service.TaskServiceModel;
import com.example.workflow.service.TaskUserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/users")
public class TaskController {

    private final TaskUserService taskService;
    private final ModelMapper modelMapper;

    public TaskController(TaskUserService taskService, ModelMapper modelMapper) {
        this.taskService = taskService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/tasks")
    public String tasks() {
        return "my_task";
    }

    @ModelAttribute("taskDTO")
    public TaskDTO taskDTO() {
        return new TaskDTO();
    }


    @PostMapping("/tasks")
    public String addTask(@Valid TaskDTO taskDTO,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes,
                          Principal principal) {


        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("taskDTO", taskDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.taskDTO", bindingResult);

            return "redirect:/users/tasks";
        }

        taskService.addTask(taskDTO, principal.getName());

        return "redirect:/users/tasks";

    }
}
