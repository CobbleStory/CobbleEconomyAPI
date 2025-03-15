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
        setBalance(economy, amount.toBigDecimal())
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
        addBalance(economy, amount.toBigDecimal())
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
        subtractBalance(economy, amount.toBigDecimal())
    }

    /**
     * Resets the player's balance for the specified economy to zero.
     *
     * @param economy The economy in which to reset the balance.
     */
    fun resetBalance(economy: Economy)

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
        return hasBalance(economy, amount.toBigDecimal())
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

    /**
     * Retrieves all cumulative balances of the player across different economies.
     *
     * @return A map of [Economy] to [BigDecimal] representing all cumulative balances.
     */
    fun getCumulativeBalances(): Map<Economy, BigDecimal>

    /**
     * Retrieves the cumulative balance of the player for a specific economy.
     *
     * @param economy The economy to retrieve the cumulative balance for.
     * @return The cumulative balance as a [BigDecimal].
     */
    fun getCumulativeBalance(economy: Economy): BigDecimal

    /**
     * Resets the cumulative balance of the player for a specific economy to zero.
     *
     * @param economy The economy in which to reset the cumulative balance.
     */
    fun resetCumulativeBalance(economy: Economy)
}
