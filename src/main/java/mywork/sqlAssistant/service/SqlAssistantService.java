package mywork.sqlAssistant.service;



import mywork.sqlAssistant.tools.EmployeeTool;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class SqlAssistantService {


    @Value("classpath:/systemTemplate.st")
    Resource systemTemplate ;

    private final ChatClient client;
    private final EmployeeTool employeeTool;

    public SqlAssistantService(ChatClient.Builder builder , EmployeeTool employeeTool){
        this.client = builder.build();
        this.employeeTool = employeeTool;
    }


    public String ask(String message){
        return client.prompt()
                .system(systemTemplate)
                .user(message)
                .tools(employeeTool)
                .call()
                .content();
    }
}
