package  tn.esprit.IaMicroservice.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  tn.esprit.IaMicroservice.Entity.AiModel;
import  tn.esprit.IaMicroservice.Repository.AiRepository;

import java.util.List;
@Service
public class AiServiceImpl implements AiService {

    @Autowired
    private AiRepository aiRepository;

    // Implement the service methods using AiRepository

    // Example: Create a new AI model
    public AiModel createAiModel(AiModel aiModel) {
        // Implement logic to save the AI model using aiRepository.save(aiModel)
        return aiRepository.save(aiModel);
    }

    // Example: Retrieve an AI model by ID
    public AiModel getAiModel(Long id) {
        // Implement logic to retrieve the AI model using aiRepository.findById(id).orElse(null)
        return aiRepository.findById(id).orElse(null);
    }

    // Example: Retrieve all AI models
    public List<AiModel> getAllAiModels() {
        // Implement logic to retrieve all AI models using aiRepository.findAll()
        return aiRepository.findAll();
    }

    // Example: Delete an AI model by ID
    public void deleteAiModel(Long id) {
        // Implement logic to delete the AI model using aiRepository.deleteById(id)
        aiRepository.deleteById(id);
    }
}


