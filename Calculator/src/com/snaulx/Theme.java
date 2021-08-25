package com.snaulx;

import java.awt.*;

public record Theme(Color numbColor, Color binOpColor, Color unOpColor, Color textColor) {
    public static final Theme LIGHT_THEME = new Theme(
            Color.LIGHT_GRAY,
            new Color(255, 160, 122),
            new Color(199, 134, 30),
            Color.BLACK);
    public static final Theme DARK_THEME = new Theme(
            Color.DARK_GRAY,
            new Color(14, 40, 122),
            new Color(133, 81, 27),
            Color.WHITE);
}
