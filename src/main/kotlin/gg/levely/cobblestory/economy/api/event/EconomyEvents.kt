package gg.levely.cobblestory.economy.api.event

import gg.levely.cobblestory.economy.api.Economy
import net.fabricmc.fabric.api.event.EventFactory
import java.math.BigDecimal
import java.util.*

/**
 * Object holding all economy-related events.
 * Provides static access to events for adding, subtracting, and setting economy balances.
 */
object EconomyEvents {

    /**
     * Event triggered when a balance is added to a player's economy.
     *
     * Usage:
     * ```
     * EconomyEvents.ADD.register { data ->
     *     println("Added ${data.amount} to ${data.uniqueId} in ${data.economy.name}. New balance: ${data.balance}")
     * }
     * ```
     */
    @JvmStatic
    val ADD = EventFactory.createArrayBacked(
        EconomyAddEvent::class.java
    ) { listeners ->
        EconomyAddEvent { economyData ->
            listeners.forEach {
                it.onAddEconomy(economyData)
            }
        }
    }

    /**
     * Event triggered when a balance is subtracted from a player's economy.
     *
     * Usage:
     * ```
     * EconomyEvents.SUBTRACT.register { data ->
     *     println("Subtracted ${data.amount} from ${data.uniqueId} in ${data.economy.name}. New balance: ${data.balance}")
     * }
     * ```
     */
    @JvmStatic
    val SUBTRACT = EventFactory.createArrayBacked(
        EconomySubtractEvent::class.java
    ) { listeners ->
        EconomySubtractEvent { economyData ->
            listeners.forEach {
                it.onSubtractEconomy(economyData)
            }
        }
    }

    /**
     * Event triggered when a player's economy balance is explicitly set.
     *
     * Usage:
     * ```
     * EconomyEvents.SET.register { data ->
     *     println("Set balance for ${data.uniqueId} in ${data.economy.name} to ${data.balance}")
     * }
     * ```
     */
    @JvmStatic
    val SET = EventFactory.createArrayBacked(
        EconomySetEvent::class.java
    ) { listeners ->
        EconomySetEvent { economyData ->
            listeners.forEach {
                it.onSetEconomy(economyData)
            }
        }
    }

    /**
     * Event triggered when the economy system is initialized.
     *
     * Usage:
     * ```
     * EconomyEvents.INITIALIZED.register { playerEconomyProvider ->
     *     println("Economy system initialized with provider: $playerEconomyProvider")
     * }
     * ```
     */

    @JvmStatic
    val INITIALIZED = EventFactory.createArrayBacked(
        EconomyInitializedEvent::class.java
    ) { listeners ->
        EconomyInitializedEvent { playerEconomyProvider ->
            listeners.forEach {
                it.onInitialize(playerEconomyProvider)
            }
        }
    }
}

/**
 * Listener interface for events triggered when a balance is added to a player's economy.
 */
fun interface EconomyAddEvent {

    /**
     * Called when a balance is added.
     *
     * @param economy The data associated with the add event.
     */
    fun onAddEconomy(economy: EconomyActionData)
}

/**
 * Listener interface for events triggered when a balance is subtracted from a player's economy.
 */
fun interface EconomySubtractEvent {

    /**
     * Called when a balance is subtracted.
     *
     * @param economy The data associated with the subtract event.
     */
    fun onSubtractEconomy(economy: EconomyActionData)
}

/**
 * Listener interface for events triggered when a player's economy balance is explicitly set.
 */
fun interface EconomySetEvent {

    /**
     * Called when a balance is set.
     *
     * @param economy The data associated with the set event.
     */
    fun onSetEconomy(economy: EconomyActionData)
}

/**
 * Data class containing information about an economy action (add, subtract, or set).
 *
 * @property uniqueId The UUID of the player associated with the economy action.
 * @property economy The economy affected by the action (e.g., "Gold", "Diamonds").
 * @property balance The player's new balance after the action.
 * @property amount The amount added, subtracted, or set during the action.
 */
data class EconomyActionData(
    val uniqueId: UUID,
    val economy: Economy,
    val balance: BigDecimal,
    val amount: BigDecimal
)