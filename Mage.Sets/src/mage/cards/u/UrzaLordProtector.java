package mage.cards.u;

import mage.MageInt;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.condition.Condition;
import mage.abilities.condition.common.MeldCondition;
import mage.abilities.costs.mana.GenericManaCost;
import mage.abilities.decorator.ConditionalOneShotEffect;
import mage.abilities.effects.common.MeldEffect;
import mage.abilities.effects.common.cost.SpellsCostReductionControllerEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Rarity;
import mage.constants.SubType;
import mage.constants.SuperType;
import mage.filter.FilterCard;
import mage.filter.predicate.Predicates;

import java.util.UUID;

/**
 * @author TheElk801
 */
public final class UrzaLordProtector extends CardImpl {

    private static final FilterCard filter = new FilterCard("artifact, instant, and sorcery spells");

    static {
        filter.add(Predicates.or(
                CardType.ARTIFACT.getPredicate(),
                CardType.INSTANT.getPredicate(),
                CardType.SORCERY.getPredicate()
        ));
    }

    private static final Condition condition = new MeldCondition("The Mightstone and Weakstone");

    public UrzaLordProtector(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{1}{W}{U}");

        this.addSuperType(SuperType.LEGENDARY);
        this.subtype.add(SubType.HUMAN);
        this.subtype.add(SubType.ARTIFICER);
        this.power = new MageInt(2);
        this.toughness = new MageInt(4);

        // Artifact, instant, and sorcery spells you cast cost {1} less to cast.
        this.addAbility(new SimpleStaticAbility(new SpellsCostReductionControllerEffect(filter, 1)));

        // {7}: If you both own and control Urza, Lord Protector and an artifact named The Mightstone and Weakstone, exile them, then meld them into Urza, Planeswalker. Activate only as a sorcery.
        this.addAbility(new SimpleActivatedAbility(new ConditionalOneShotEffect(
                new MeldEffect(
                        "The Mightstone and Weakstone",
                        new UrzaPlaneswalker(
                                ownerId,
                                new CardSetInfo(
                                        "Urza, Planeswalker", setInfo.getExpansionSetCode(),
                                        "238b", Rarity.MYTHIC
                                )
                        )
                ), condition, "If you both own and control {this} and an artifact named " +
                "The Mightstone and Weakstone, exile them, then meld them into Urza, Planeswalker"
        ), new GenericManaCost(7)));
    }

    private UrzaLordProtector(final UrzaLordProtector card) {
        super(card);
    }

    @Override
    public UrzaLordProtector copy() {
        return new UrzaLordProtector(this);
    }
}
