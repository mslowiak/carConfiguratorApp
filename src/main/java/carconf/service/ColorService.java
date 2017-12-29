package carconf.service;

import carconf.entity.Color;

import java.util.List;

public interface ColorService {
    List<Color> getColors();
    List<Color> getColorsByModelId(int modelId);
}
