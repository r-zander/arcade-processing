package de.xielong.arcade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import processing.core.PApplet;

@Data
@AllArgsConstructor(suppressConstructorProperties = true)
@NoArgsConstructor
public class Vector {

    private float x, y;

    public float getLength() {
        return PApplet.sqrt(getSqLength());
    }

    public float getSqLength() {
        return x * x + y * y;
    }
}
