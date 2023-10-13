package  tn.esprit.IaMicroservice.Service;

import  tn.esprit.IaMicroservice.Entity.AiModel;

import java.util.List;

public interface AiService {
    AiModel createAiModel(AiModel aiModel);
    AiModel getAiModel(Long id);
    List<AiModel> getAllAiModels();
    void deleteAiModel(Long id);
}