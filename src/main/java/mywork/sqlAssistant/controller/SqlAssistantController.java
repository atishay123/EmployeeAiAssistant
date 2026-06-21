package mywork.sqlAssistant.controller;


import lombok.RequiredArgsConstructor;
import mywork.sqlAssistant.service.SqlAssistantService;
import org.aspectj.bridge.IMessage;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ai")
@RequiredArgsConstructor
public class SqlAssistantController {

    private final SqlAssistantService service;

    @GetMapping("/ask")
    public String AutomatedResponse(@RequestParam String message){

        return service.ask(message);


    }
}
