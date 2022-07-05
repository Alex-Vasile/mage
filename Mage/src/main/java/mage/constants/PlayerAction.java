
package mage.constants;

/**
 * Defines player actions for a game
 *
 * @author LevelX2
 */
public enum PlayerAction {

    PASS_PRIORITY_UNTIL_MY_NEXT_TURN,
    PASS_PRIORITY_UNTIL_TURN_END_STEP,
    PASS_PRIORITY_UNTIL_NEXT_MAIN_PHASE,
    PASS_PRIORITY_UNTIL_NEXT_TURN,
    PASS_PRIORITY_UNTIL_NEXT_TURN_SKIP_STACK,
    PASS_PRIORITY_UNTIL_STACK_RESOLVED,
    PASS_PRIORITY_UNTIL_END_STEP_BEFORE_MY_NEXT_TURN,
    PASS_PRIORITY_CANCEL_ALL_ACTIONS,
    TRIGGER_AUTO_ORDER_ABILITY_FIRST,
    TRIGGER_AUTO_ORDER_NAME_FIRST,
    TRIGGER_AUTO_ORDER_ABILITY_LAST,
    TRIGGER_AUTO_ORDER_NAME_LAST,
    TRIGGER_AUTO_ORDER_RESET_ALL,
    ROLLBACK_TURNS,
    UNDO,
    CONCEDE,
    MANA_AUTO_PAYMENT_ON,
    MANA_AUTO_PAYMENT_OFF,
    MANA_AUTO_PAYMENT_RESTRICTED_ON,
    MANA_AUTO_PAYMENT_RESTRICTED_OFF,
    USE_FIRST_MANA_ABILITY_ON,
    USE_FIRST_MANA_ABILITY_OFF,
    RESET_AUTO_SELECT_REPLACEMENT_EFFECTS,
    REVOKE_PERMISSIONS_TO_SEE_HAND_CARDS,
    REQUEST_PERMISSION_TO_SEE_HAND_CARDS,
    REQUEST_PERMISSION_TO_ROLLBACK_TURN,
    ADD_PERMISSION_TO_SEE_HAND_CARDS,
    ADD_PERMISSION_TO_ROLLBACK_TURN,
    DENY_PERMISSION_TO_ROLLBACK_TURN,
    PERMISSION_REQUESTS_ALLOWED_ON,
    PERMISSION_REQUESTS_ALLOWED_OFF,
    REQUEST_AUTO_ANSWER_ID_YES,
    REQUEST_AUTO_ANSWER_ID_NO,
    REQUEST_AUTO_ANSWER_TEXT_YES,
    REQUEST_AUTO_ANSWER_TEXT_NO,
    REQUEST_AUTO_ANSWER_RESET_ALL,
    CLIENT_DOWNLOAD_SYMBOLS,
    CLIENT_DISCONNECT,
    CLIENT_QUIT_TOURNAMENT,
    CLIENT_QUIT_DRAFT_TOURNAMENT,
    CLIENT_CONCEDE_GAME,
    CLIENT_CONCEDE_MATCH,
    CLIENT_STOP_WATCHING,
    CLIENT_EXIT,
    CLIENT_REMOVE_TABLE,
    CLIENT_DOWNLOAD_CARD_IMAGES,
    CLIENT_RECONNECT,
    CLIENT_REPLAY_ACTION,
    HOLD_PRIORITY,
    UNHOLD_PRIORITY,
    VIEW_LIMITED_DECK,
    VIEW_SIDEBOARD,
    TOGGLE_RECORD_MACRO
}
