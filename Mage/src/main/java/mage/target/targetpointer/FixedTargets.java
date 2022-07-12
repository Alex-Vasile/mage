package mage.target.targetpointer;

import mage.MageObject;
import mage.MageObjectReference;
import mage.abilities.Ability;
import mage.cards.Card;
import mage.cards.Cards;
import mage.constants.Zone;
import mage.game.Game;
import mage.game.permanent.Permanent;
import mage.game.permanent.token.Token;
import mage.players.Player;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author LevelX2
 */
public class FixedTargets extends TargetPointerImpl {

    final ArrayList<MageObjectReference> targets = new ArrayList<>();
    final ArrayList<UUID> targetsNotInitialized = new ArrayList<>();

    private boolean initialized;

    public FixedTargets(UUID targetId) {
        super();

        targetsNotInitialized.add(targetId);
        this.initialized = false;
    }

    public FixedTargets(Cards cards, Game game) {
        super();
        if (cards != null) {
            for (UUID targetId : cards) {
                MageObjectReference mor = new MageObjectReference(targetId, game);
                targets.add(mor);
            }
        }
        this.initialized = true;
    }

    public FixedTargets(Token token, Game game) {
        this(token.getLastAddedTokenIds().stream().map(game::getPermanent).collect(Collectors.toList()), game);
    }

    public FixedTargets(List<Permanent> permanents, Game game) {
        super();

        for (Permanent permanent : permanents) {
            MageObjectReference mor = new MageObjectReference(permanent.getId(), permanent.getZoneChangeCounter(game), game);
            targets.add(mor);
        }
        this.initialized = true;
    }

    public FixedTargets(Set<Card> cards, Game game) {
        super();

        for (Card card : cards) {
            MageObjectReference mor = new MageObjectReference(card.getId(), card.getZoneChangeCounter(game), game);
            targets.add(mor);
        }
        this.initialized = true;
    }

    public FixedTargets(Collection<MageObjectReference> morSet, Game game) {
        super();

        targets.addAll(morSet);
        this.initialized = true;
    }

    private FixedTargets(final FixedTargets targetPointer) {
        super(targetPointer);

        this.targets.addAll(targetPointer.targets);
        this.targetsNotInitialized.addAll(targetPointer.targetsNotInitialized);
        this.initialized = targetPointer.initialized;
    }

    @Override
    public void init(Game game, Ability source) {
        if (!initialized) {
            initialized = true;
            for (UUID targetId : targetsNotInitialized) {
                targets.add(new MageObjectReference(targetId, game.getState().getZoneChangeCounter(targetId), game));
            }
        }
    }

    @Override
    public List<UUID> getTargets(Game game, Ability source) {
        // check target not changed zone
        return targets
                .stream()
                .filter(mor -> mor.zoneCounterIsCurrent(game))
                .map(MageObjectReference::getSourceId)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @Override
    public UUID getFirst(Game game, Ability source) {
        // check target not changed zone
        return targets
                .stream()
                .filter(mor -> mor.zoneCounterIsCurrent(game))
                .map(MageObjectReference::getSourceId)
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(null);
    }

    @Override
    public FixedTargets copy() {
        return new FixedTargets(this);
    }

    /**
     * Returns a fixed target for (and only) the first taget
     *
     * @param game
     * @param source
     * @return
     */
    @Override
    public FixedTarget getFixedTarget(Game game, Ability source) {
        this.init(game, source);
        UUID firstId = getFirst(game, source);
        if (firstId != null) {
            return new FixedTarget(firstId, game.getState().getZoneChangeCounter(firstId));
        }
        return null;
    }

    @Override
    public Permanent getFirstTargetPermanentOrLKI(Game game, Ability source) {
        UUID targetId = null;
        int zoneChangeCounter = Integer.MIN_VALUE;
        if (!targets.isEmpty()) {
            MageObjectReference mor = targets.get(0);
            targetId = mor.getSourceId();
            zoneChangeCounter = mor.getZoneChangeCounter();
        } else if (!targetsNotInitialized.isEmpty()) {
            targetId = targetsNotInitialized.get(0);
        }
        if (targetId != null) {
            Permanent permanent = game.getPermanent(targetId);
            if (permanent != null
                    && (zoneChangeCounter == Integer.MIN_VALUE || permanent.getZoneChangeCounter(game) == zoneChangeCounter)) {
                return permanent;
            }
            MageObject mageObject;
            if (zoneChangeCounter == Integer.MIN_VALUE) {
                mageObject = game.getLastKnownInformation(targetId, Zone.BATTLEFIELD);
            } else {
                mageObject = game.getLastKnownInformation(targetId, Zone.BATTLEFIELD, zoneChangeCounter);
            }
            if (mageObject instanceof Permanent) {
                return (Permanent) mageObject;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        FixedTargets that = (FixedTargets) obj;

        if (!Objects.deepEquals(this.targets, that.targets)) {
            return false;
        }

        return Objects.deepEquals(this.targetsNotInitialized, that.targetsNotInitialized);
    }

    @Override
    public boolean equivalent(Object obj, Game game) {
        if (!super.equivalent(obj, game)) {
            return false;
        }
        FixedTargets that = (FixedTargets) obj;

        if ((this.targets == null ^ that.targets == null)
                || this.targets == null) {
            return false;
        }
        if (this.targets.size() != that.targets.size()) {
            return false;
        }
        for (int i = 0; i < this.targets.size(); i++) {
            MageObjectReference thisMOR = this.targets.get(i);
            MageObjectReference thatMOR = that.targets.get(i);
            if ((thisMOR == null ^ thatMOR == null) || thisMOR == null) {
                return false;
            }
            if (!thisMOR.equivalent(thatMOR, game)) {
                return false;
            }
        }

        if ((this.targetsNotInitialized == null ^ that.targetsNotInitialized == null)
                || this.targetsNotInitialized == null) {
            return false;
        }
        if (this.targetsNotInitialized.size() != that.targetsNotInitialized.size()) {
            return false;
        }
        for (int i = 0; i < this.targetsNotInitialized.size(); i++) {
            Permanent permThis = game.getPermanent(this.targetsNotInitialized.get(i));
            Permanent permThat = game.getPermanent(that.targetsNotInitialized.get(i));
            if (!(permThis == null ^ permThat == null)) {
                return false; // Only one of them is null
            }
            if (permThis != null && !permThis.equivalent(permThat, game)) {
                return false;
            }

            Player playerThis = game.getPlayer(this.targetsNotInitialized.get(i));
            Player playerThat = game.getPlayer(that.targetsNotInitialized.get(i));
            if (!(playerThis == null ^ playerThat == null)) {
                return false; // Only one of them is null
            }
            if (playerThis != null && !playerThis.equals(playerThat)) {
                return false;
            }

            Card cardThis = (Card) game.getCard(this.targetsNotInitialized.get(i));
            Card cardThat = (Card) game.getCard(that.targetsNotInitialized.get(i));
            if (!(cardThis == null ^ cardThat == null)) {
                return false; // Only one is them is null
            }
            if (cardThis != null && !cardThis.equivalent(cardThat, game)) {
                return false;
            }
        }
        final ArrayList<UUID> targetsNotInitialized = new ArrayList<>();

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), targets, targetsNotInitialized, initialized);
    }
}
