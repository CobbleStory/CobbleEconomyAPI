# 🏦 Multi-Economy API (Fabric 1.21.1)

A Fabric API that allows managing multiple economies dynamically, enabling independent player balances.

## 📌 Features
- Supports **multiple economies** at once.
- Provides **player economy management** (add, subtract, set balance).
- Tracks **richest players** and **player rankings**.
- Uses **Fabric event system** for easy integration.

---

## 🚀 Installation

1. **Ensure Fabric 1.21.1 is installed.**
2. **Add this API as a dependency** to your Fabric project.

---

## 📜 Usage

### 📢 Available Events

The API provides **four main events** to interact with player balances.

#### 1️⃣ Economy Initialization
Triggered when the economy system is ready to use.

```kotlin
EconomyEvents.INITIALIZED.register { provider ->
    println("Economy system initialized: $provider")
}
```

#### 2️⃣ Add Balance
Fired when a balance is **added** to a player's economy.

```kotlin
EconomyEvents.ADD.register { data ->
    println("Added ${data.amount} to ${data.uniqueId}. New balance: ${data.balance}")
}
```

#### 3️⃣ Subtract Balance
Fired when a balance is **subtracted** from a player's economy.

```kotlin
EconomyEvents.SUBTRACT.register { data ->
    println("Subtracted ${data.amount} from ${data.uniqueId}. New balance: ${data.balance}")
}
```

#### 4️⃣ Set Balance
Fired when a player's balance is **explicitly set**.

```kotlin
EconomyEvents.SET.register { data ->
    println("Set balance for ${data.uniqueId} to ${data.balance}")
}
```