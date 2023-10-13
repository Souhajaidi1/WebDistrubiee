package tn.esprit.IaMicroservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.IaMicroservice.Entity.AiModel;
import tn.esprit.IaMicroservice.Service.AiService;

import java.util.List;

@RestController
@RequestMapping("/ai")
public class AiController {
    @Autowired
    private AiService aiService;

    // Implement CRUD operations using AiService

    // Example: Create a new AI model
    @PostMapping("/create")
    public AiModel createAiModel(@RequestBody AiModel aiModel) {
        // Implement logic to create a new AI model using aiService.createAiModel(aiModel)
        return aiService.createAiModel(aiModel);
    }

    // Example: Retrieve an AI model by ID
    @GetMapping("/{id}")
    public AiModel getAiModel(@PathVariable Long id) {
        // Implement logic to retrieve an AI model by ID using aiService.getAiModel(id)
        return aiService.getAiModel(id);
    }

    // Example: Retrieve all AI models
    @GetMapping("/getall")
    public List<AiModel> getAllAiModels() {
        // Implement logic to retrieve all AI models using aiService.getAllAiModels()
        return aiService.getAllAiModels();
    }

    // Example: Delete an AI model by ID
    @DeleteMapping("/delete/{id}")
    public void deleteAiModel(@PathVariable Long id) {
        // Implement logic to delete an AI model by ID using aiService.deleteAiModel(id)
        aiService.deleteAiModel(id);
    }
}
