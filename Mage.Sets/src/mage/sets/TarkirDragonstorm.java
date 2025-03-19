package mage.sets;

import mage.cards.ExpansionSet;
import mage.constants.Rarity;
import mage.constants.SetType;

/**
 * @author TheElk801
 */
public final class TarkirDragonstorm extends ExpansionSet {

    private static final TarkirDragonstorm instance = new TarkirDragonstorm();

    public static TarkirDragonstorm getInstance() {
        return instance;
    }

    private TarkirDragonstorm() {
        super("Tarkir: Dragonstorm", "TDM", ExpansionSet.buildDate(2025, 4, 11), SetType.EXPANSION);
        this.blockName = "Tarkir: Dragonstorm"; // for sorting in GUI
        this.hasBasicLands = false; // temporary

        cards.add(new SetCardInfo("Agent of Kotis", 36, Rarity.COMMON, mage.cards.a.AgentOfKotis.class));
        cards.add(new SetCardInfo("Barrensteppe Siege", 171, Rarity.RARE, mage.cards.b.BarrensteppeSiege.class));
        cards.add(new SetCardInfo("Bloodfell Caves", 250, Rarity.COMMON, mage.cards.b.BloodfellCaves.class));
        cards.add(new SetCardInfo("Blossoming Sands", 251, Rarity.COMMON, mage.cards.b.BlossomingSands.class));
        cards.add(new SetCardInfo("Craterhoof Behemoth", 138, Rarity.MYTHIC, mage.cards.c.CraterhoofBehemoth.class));
        cards.add(new SetCardInfo("Devoted Duelist", 104, Rarity.COMMON, mage.cards.d.DevotedDuelist.class));
        cards.add(new SetCardInfo("Dismal Backwater", 254, Rarity.COMMON, mage.cards.d.DismalBackwater.class));
        cards.add(new SetCardInfo("Dracogenesis", 105, Rarity.MYTHIC, mage.cards.d.Dracogenesis.class));
        cards.add(new SetCardInfo("Dragonback Lancer", 9, Rarity.COMMON, mage.cards.d.DragonbackLancer.class));
        cards.add(new SetCardInfo("Forest", 285, Rarity.LAND, mage.cards.basiclands.Forest.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Inevitable Defeat", 194, Rarity.RARE, mage.cards.i.InevitableDefeat.class));
        cards.add(new SetCardInfo("Island", 273, Rarity.LAND, mage.cards.basiclands.Island.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Jungle Hollow", 258, Rarity.COMMON, mage.cards.j.JungleHollow.class));
        cards.add(new SetCardInfo("Mountain", 275, Rarity.LAND, mage.cards.basiclands.Mountain.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Mox Jasper", 246, Rarity.MYTHIC, mage.cards.m.MoxJasper.class));
        cards.add(new SetCardInfo("Narset, Jeskai Waymaster", 209, Rarity.RARE, mage.cards.n.NarsetJeskaiWaymaster.class));
        cards.add(new SetCardInfo("Plains", 272, Rarity.LAND, mage.cards.basiclands.Plains.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Rally the Monastery", 19, Rarity.UNCOMMON, mage.cards.r.RallyTheMonastery.class));
        cards.add(new SetCardInfo("Roiling Dragonstorm", 55, Rarity.UNCOMMON, mage.cards.r.RoilingDragonstorm.class));
        cards.add(new SetCardInfo("Rugged Highlands", 265, Rarity.COMMON, mage.cards.r.RuggedHighlands.class));
        cards.add(new SetCardInfo("Scoured Barrens", 267, Rarity.COMMON, mage.cards.s.ScouredBarrens.class));
        cards.add(new SetCardInfo("Shiko, Paragon of the Way", 223, Rarity.MYTHIC, mage.cards.s.ShikoParagonOfTheWay.class));
        cards.add(new SetCardInfo("Skirmish Rhino", 224, Rarity.UNCOMMON, mage.cards.s.SkirmishRhino.class));
        cards.add(new SetCardInfo("Smile at Death", 24, Rarity.MYTHIC, mage.cards.s.SmileAtDeath.class));
        cards.add(new SetCardInfo("Stormplain Detainment", 28, Rarity.COMMON, mage.cards.s.StormplainDetainment.class));
        cards.add(new SetCardInfo("Stormscale Scion", 123, Rarity.MYTHIC, mage.cards.s.StormscaleScion.class));
        cards.add(new SetCardInfo("Swamp", 274, Rarity.LAND, mage.cards.basiclands.Swamp.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Swiftwater Cliffs", 268, Rarity.COMMON, mage.cards.s.SwiftwaterCliffs.class));
        cards.add(new SetCardInfo("Thornwood Falls", 269, Rarity.COMMON, mage.cards.t.ThornwoodFalls.class));
        cards.add(new SetCardInfo("Tranquil Cove", 270, Rarity.COMMON, mage.cards.t.TranquilCove.class));
        cards.add(new SetCardInfo("Voice of Victory", 33, Rarity.RARE, mage.cards.v.VoiceOfVictory.class));
        cards.add(new SetCardInfo("Wind-Scarred Crag", 271, Rarity.COMMON, mage.cards.w.WindScarredCrag.class));
    }
}
