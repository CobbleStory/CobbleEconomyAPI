package gg.levely.cobblestory.economy.api

interface Economy {

    fun getName(): String

    companion object {

        @JvmStatic
        fun fromName(name: String): Economy {
            return DefaultEconomy(name)
        }

    }

}

data class DefaultEconomy(private val economyName: String) : Economy {

    override fun getName(): String = economyName

}