package carconf.service;

import carconf.entity.EquipmentElement;
import carconf.entity.EquipmentType;

import java.util.List;

public interface EquipmentElementService {
    List<EquipmentElement> getEquipmentElements();
    List<EquipmentElement> getEquipmentElementsByLevelId(int levelId);
}
