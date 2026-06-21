package mywork.sqlAssistant.tools;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EmployeeTool {

    private final EntityManager entityManager;

    @Tool(description = "Fetch employees by city. Returns employee details including name, city and salary.")
    public List<?> fetchEmployee( String sql){
        return entityManager.createNativeQuery(sql).getResultList();


    }



}
