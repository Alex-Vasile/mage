package mage.sets;

import mage.cards.ExpansionSet;
import mage.constants.Rarity;
import mage.constants.SetType;

/**
 * @author TheElk801
 */
public final class TarkirDragonstormCommander extends ExpansionSet {

    private static final TarkirDragonstormCommander instance = new TarkirDragonstormCommander();

    public static TarkirDragonstormCommander getInstance() {
        return instance;
    }

    private TarkirDragonstormCommander() {
        super("Tarkir: Dragonstorm Commander", "TDC", ExpansionSet.buildDate(2025, 4, 11), SetType.SUPPLEMENTAL);
        this.hasBasicLands = false;

        cards.add(new SetCardInfo("Teval, the Balanced Scale", 8, Rarity.MYTHIC, mage.cards.t.TevalTheBalancedScale.class));
    }
}
