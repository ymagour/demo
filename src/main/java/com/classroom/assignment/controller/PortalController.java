package com.classroom.assignment.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.classroom.assignment.entity.Weather;
import com.classroom.assignment.service.GreetingService;
import com.classroom.assignment.service.WeatherService;

@Controller
@RequestMapping("/")
public class PortalController {
  private final GreetingService greetingService;
  private final WeatherService weatherService;

  @Autowired
  public PortalController(
      GreetingService greetingService,
      WeatherService weatherService) {
    this.greetingService = greetingService;
    this.weatherService = weatherService;
  }

  @GetMapping()
  public String index(Model model) {
    // 現在の日付
    LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));

    // 日付表示
    model.addAttribute("date", now);
    model.addAttribute("dayOfWeek",
        now.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.JAPAN));

    /**
     * level 1-1 名前表示
     */
    // 名前表示
    model.addAttribute("name", "○○"); // ← ○○を書き換えて名前を表示

    /**
     * level 1-2 天気取得都市の変更
     */
    // 天気
    Weather weather = weatherService.findWeather();
    model.addAttribute("weather", weather);

    /**
     * level 2-1 挨拶の表示
     */
    // 挨拶
    String greeting = "こんにちは";
    model.addAttribute("greeting", greeting);

    return "index";
  }
}
