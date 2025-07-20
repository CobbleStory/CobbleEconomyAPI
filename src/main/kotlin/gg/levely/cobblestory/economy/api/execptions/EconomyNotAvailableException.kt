package gg.levely.cobblestory.economy.api.execptions

import gg.levely.cobblestory.economy.api.Economy

class EconomyNotAvailableException(
    val economy: Economy
) : RuntimeException("Economy '${economy.getName()}' is not available")