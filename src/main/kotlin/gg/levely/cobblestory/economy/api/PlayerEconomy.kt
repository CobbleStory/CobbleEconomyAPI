package gg.levely.cobblestory.economy.api

import java.math.BigDecimal
import java.util.*

/**
 * Represents a player economy interface for managing economic data of a player.
 */
interface PlayerEconomy {

    /**
     * Gets the unique identifier of the player.
     *
     * @return the unique identifier (UUID) of the player.
     */
    fun getUniqueId(): UUID

    /**
     * Gets the name of the player.
     *
     * @return the name of the player as a String.
     */
    fun getName(): String

    /**
     * Gets the balance of the player for the specified economy.
     *
     * @param economy the economy to retrieve the balance for.
     * @return the current balance as a [BigDecimal].
     */
    fun getBalance(economy: Economy): BigDecimal

    /**
     * Sets the balance of the player for the specified economy.
     *
     * @param economy the economy to update the balance for.
     * @param amount the new balance to set, as a [BigDecimal].
     */
    fun setBalance(economy: Economy, amount: BigDecimal)

    /**
     * Sets the balance of the player for the specified economy.
     *
     * @param economy the economy to update the balance for.
     * @param amount the new balance to set, as a [Double].
     */
    fun setBalance(economy: Economy, amount: Double) {
        setBalance(economy, BigDecimal.valueOf(amount))
    }

    /**
     * Adds a specified amount to the player's balance for the given economy.
     *
     * @param economy the economy to add balance to.
     * @param amount the amount to add, as a [BigDecimal].
     */
    fun addBalance(economy: Economy, amount: BigDecimal)

    /**
     * Adds a specified amount to the player's balance for the given economy.
     *
     * @param economy the economy to add balance to.
     * @param amount the amount to add, as a [Double].
     */
    fun addBalance(economy: Economy, amount: Double) {
        addBalance(economy, BigDecimal.valueOf(amount))
    }

    /**
     * Subtracts a specified amount from the player's balance for the given economy.
     *
     * @param economy the economy to subtract balance from.
     * @param amount the amount to subtract, as a [BigDecimal].
     */
    fun subtractBalance(economy: Economy, amount: BigDecimal)

    /**
     * Subtracts a specified amount from the player's balance for the given economy.
     *
     * @param economy the economy to subtract balance from.
     * @param amount the amount to subtract, as a [Double].
     */
    fun subtractBalance(economy: Economy, amount: Double) {
        subtractBalance(economy, BigDecimal.valueOf(amount))
    }

    /**
     * Checks if the player has at least the specified balance in the given economy.
     *
     * @param economy the economy to check the balance in.
     * @param amount the amount to compare against, as a [BigDecimal].
     * @return `true` if the player has at least the specified balance, otherwise `false`.
     */
    fun hasBalance(economy: Economy, amount: BigDecimal): Boolean

    /**
     * Checks if the player has at least the specified balance in the given economy.
     *
     * @param economy the economy to check the balance in.
     * @param amount the amount to compare against, as a [Double].
     * @return `true` if the player has at least the specified balance, otherwise `false`.
     */
    fun hasBalance(economy: Economy, amount: Double): Boolean {
        return hasBalance(economy, BigDecimal.valueOf(amount))
    }

    /**
     * Checks if the player has any balance in the specified economy.
     *
     * @param economy the economy to check the balance in.
     * @return `true` if the player has a positive balance, otherwise `false`.
     */
    fun hasBalance(economy: Economy): Boolean

    /**
     * Gets all balances for the player across different economies.
     *
     * @return a map of [Economy] to [BigDecimal] representing all balances.
     */
    fun getBalances(): Map<Economy, BigDecimal>
}
