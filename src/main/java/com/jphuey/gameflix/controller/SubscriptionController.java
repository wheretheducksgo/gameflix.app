package com.jphuey.gameflix.controller;

import com.jphuey.gameflix.model.Subscription;
import com.jphuey.gameflix.model.User;
import com.jphuey.gameflix.service.SubscriptionService;
import com.jphuey.gameflix.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;
    private final UserRepository userRepository;

    @Autowired
    public SubscriptionController(SubscriptionService subscriptionService,
                                  UserRepository userRepository) {
        this.subscriptionService = subscriptionService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public String mySubscriptions(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        User user = userRepository.findByUsername(userDetails.getUsername()).orElse(null);
        if(user == null) return "redirect:/login";

        model.addAttribute("subscriptions", subscriptionService.getSubscriptionsByUser(user));
        return "subscriptions";
    }

    @PostMapping("/subscribe")
    public String subscribe(@AuthenticationPrincipal UserDetails userDetails,
                            @RequestParam String type) {
        User user = userRepository.findByUsername(userDetails.getUsername()).orElse(null);
        if(user == null) return "redirect:/login";

        Subscription subscription = new Subscription(user, type, LocalDate.now(), LocalDate.now().plusMonths(1), true);
        subscriptionService.subscribeUser(subscription);
        return "redirect:/subscriptions";
    }

    @GetMapping("/cancel/{id}")
    public String cancelSubscription(@PathVariable Long id) {
        subscriptionService.cancelSubscription(id);
        return "redirect:/subscriptions";
    }
}