package gg.levely.cobblestory.economy.api.execptions

class ExceedsMaximumBalanceException(
    attemptedAmount: Number,
    maxAllowed: Number
) : RuntimeException("Amount $attemptedAmount exceeds maximum balance limit of $maxAllowed")