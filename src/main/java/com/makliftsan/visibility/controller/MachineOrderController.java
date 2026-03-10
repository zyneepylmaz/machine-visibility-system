package com.makliftsan.visibility.controller;

import com.makliftsan.visibility.entity.MachineOrder;
import com.makliftsan.visibility.entity.VisibilityType;
import com.makliftsan.visibility.service.MachineOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor
public class MachineOrderController {

    private final MachineOrderService machineOrderService;

    @GetMapping
    public String listOrders(Model model, Principal principal) {
        String username = principal.getName();
        List<MachineOrder> orders = machineOrderService.getVisibleOrdersForUsername(username);

        model.addAttribute("orders", orders);
        model.addAttribute("username", username);

        return "orders";
    }

    @GetMapping("/new")
    public String newOrderForm(Model model) {
        model.addAttribute("machineOrder", machineOrderService.createEmptyOrder());
        model.addAttribute("visibilityTypes", VisibilityType.values());
        return "order-form";
    }

    @PostMapping
    public String saveOrder(@ModelAttribute MachineOrder machineOrder, Principal principal) {
        machineOrderService.save(machineOrder, principal.getName());
        return "redirect:/orders";
    }
}