package carconf.service;

import carconf.entity.EquipmentLevel;

import java.util.List;

public interface EquipmentLevelService {
    List<EquipmentLevel> getEquipmentLevels();
    List<EquipmentLevel> getEquipmentLevelsByModelId(int modelId);
    List<EquipmentLevel> getEquipmentLevelByEquipmentLevelIdAndModelId(int levelId, int modelId);
}
