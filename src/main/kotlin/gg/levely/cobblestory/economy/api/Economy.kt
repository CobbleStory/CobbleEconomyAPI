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

class DefaultEconomy(val economyName: String) : Economy {

    override fun getName(): String = economyName

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DefaultEconomy

        return economyName == other.economyName
    }

    override fun hashCode(): Int {
        return economyName.hashCode()
    }

    override fun toString(): String {
        return "DefaultEconomy(economyName='$economyName')"
    }

}