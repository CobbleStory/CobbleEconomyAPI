package gg.levely.cobblestory.economy.api.event

import gg.levely.cobblestory.economy.api.PlayerEconomyProvider

fun interface EconomyInitializedEvent {

    fun onInitialize(playerEconomyProvider: PlayerEconomyProvider)

}