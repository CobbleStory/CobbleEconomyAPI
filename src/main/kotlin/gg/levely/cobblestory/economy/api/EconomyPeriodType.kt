package gg.levely.cobblestory.economy.api

import java.time.DayOfWeek
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.temporal.TemporalAdjusters

enum class EconomyPeriodType {
    LIFETIME,
    DAILY,
    WEEKLY,
    MONTHLY;


    fun getStartInstant(zone: ZoneId = ZoneId.systemDefault()): Instant? {
        val now = ZonedDateTime.now(zone)

        val start: ZonedDateTime? = when (this) {
            DAILY -> now.toLocalDate().atStartOfDay(zone)
            WEEKLY -> now.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)).toLocalDate().atStartOfDay(zone)
            MONTHLY -> now.withDayOfMonth(1).toLocalDate().atStartOfDay(zone)
            LIFETIME -> return null // Lifetime does not have a start date
        }

        return start?.toInstant()
    }

}