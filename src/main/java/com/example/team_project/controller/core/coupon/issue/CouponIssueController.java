package com.example.team_project.controller.core.coupon.issue;

import com.example.team_project.domain.domain.coupons.usercoupon.service.issue.UserCouponIssueService;
import com.example.team_project.domain.domain.coupons.usercoupon.service.issue.UserIssueAbleCouponListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/coupon/issue")
public class CouponIssueController {
    private final UserCouponIssueService userCouponIssueService;
    private final UserIssueAbleCouponListService userIssueAbleCouponListService;

    @GetMapping
    public String get(@SessionAttribute Long userId, Model model) {
        model.addAttribute("couponList", userIssueAbleCouponListService.getList(userId));

        return "thymeleaf/coupon/issue";
    }

    @PostMapping("{couponName}")
    public String post(@SessionAttribute Long userId, @PathVariable String couponName) {
        userCouponIssueService.issue(userId, couponName);
        return "redirect:/main";
    }
}
