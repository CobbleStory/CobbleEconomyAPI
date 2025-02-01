package gg.levely.cobblestory.economy.api

import java.util.UUID

/**
 * Provides methods to manage and access player economy data.
 */
interface PlayerEconomyProvider {

    /**
     * Retrieves the economy details of a player by their unique ID.
     *
     * @param uniqueId the unique identifier of the player.
     * @return the player's economy details, or `null` if the player does not exist or is not loaded.
     */
    fun getEconomy(uniqueId: UUID): PlayerEconomy?

    /**
     * Retrieves the economy details of a player by their name.
     *
     * @param name the name of the player.
     * @return the player's economy details, or `null` if the player does not exist or is not loaded.
     */
    fun getEconomy(name: String): PlayerEconomy?

    /**
     * Retrieves a list of all loaded player economies.
     *
     * @return a list of {@link PlayerEconomy} representing all currently loaded player economies.
     */
    fun getLoadedEconomies(): List<PlayerEconomy>

    /**
     * Retrieves the rank of a player within a specific economy.
     *
     * @param uniqueId the unique identifier of the player.
     * @param economy the economy to calculate the player's rank within.
     * @return the player's rank in the given economy. A lower rank number indicates a higher position.
     */
    fun getPlayerRank(uniqueId: UUID, economy: Economy): Int

    /**
     * Retrieves a list of the most wealthy players in a given economy.
     *
     * @param economy the economy to evaluate.
     * @param limit the maximum number of players to include in the list.
     * @return a list of player names representing the richest players in the given economy.
     */
    fun getMostRichestPlayers(economy: Economy, limit: Int): List<String>

    /**
     * Retrieves the name of the player at the specified ranking position in a given economy.
     *
     * The ranking is determined by sorting players in descending order based on their balance.
     * A lower index (e.g., `0`) corresponds to the player with the highest balance.
     *
     * @param economy the economy to evaluate.
     * @param index the ranking position of the player to retrieve (0-based index).
     * @return the name of the player at the specified ranking position, or `null` if no such player exists.
     */
    fun getRichestPlayerByIndex(economy: Economy, index: Int): String?

}
