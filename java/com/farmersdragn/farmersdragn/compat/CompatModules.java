package com.farmersdragn.farmersdragn.compat;

import java.util.List;

public final class CompatModules {
    public static final CompatModule FARMERS_DELIGHT = new CompatModule("farmersdelight", "Farmer's Delight", true);
    public static final CompatModule DRAGN_LIVESTOCK = new CompatModule("dragnlivestock", "DragN's Overhauled Livestock", true);
    public static final CompatModule DRAGN_PETS = new CompatModule("dragnpets", "DragN's Overhauled Pets", true);
    public static final CompatModule HEARTH_AND_HARVEST = new CompatModule("hearthandharvest", "Hearth and Harvest", false);
    public static final CompatModule BREWIN_AND_CHEWIN = new CompatModule("brewinandchewin", "Brewin' and Chewin'", false);

    public static final List<CompatModule> ALL = List.of(
            FARMERS_DELIGHT,
            DRAGN_LIVESTOCK,
            DRAGN_PETS,
            HEARTH_AND_HARVEST,
            BREWIN_AND_CHEWIN
    );

    private CompatModules() {
    }
}
