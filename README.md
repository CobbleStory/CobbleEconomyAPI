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

## 📦 Dependency (GitHub Packages)

This library is published on **[GitHub Packages](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-gradle-registry)**. To use it in your project, follow these steps:

### 🛠️ **Gradle (Kotlin DSL)**

```kotlin
repositories {
    maven {
        url = uri("https://maven.pkg.github.com/CobbleStory/CobbleEconomyAPI")
        credentials {
            username = project.findProperty("gpr.user") as String? ?: System.getenv("GITHUB_USER")
            password = project.findProperty("gpr.token") as String? ?: System.getenv("GITHUB_TOKEN")
        }
    }
}

dependencies {
    modImplementation("gg.levely.cobblestory:economy-api:1.0.0")
}
```

### 🛠️ **Gradle (Groovy DSL)**

```groovy
repositories {
    maven {
        url = uri("https://maven.pkg.github.com/CobbleStory/CobbleEconomyAPI")
        credentials {
            username = project.findProperty("gpr.user") ?: System.getenv("GITHUB_USER")
            password = project.findProperty("gpr.token") ?: System.getenv("GITHUB_TOKEN")
        }
    }
}

dependencies {
    modImplementation "gg.levely.cobblestory:economy-api:1.0.0"
}
```

### 🔑 **Authentication**
GitHub Packages requires authentication. You need to set up your credentials in your `gradle.properties` or as environment variables:

#### **Option 1: Add to `gradle.properties`**
```properties
gpr.user=your-github-username
gpr.token=your-personal-access-token
```

#### **Option 2: Use Environment Variables**
```sh
export GITHUB_USER=your-github-username
export GITHUB_TOKEN=your-personal-access-token
```

> **Note:** The GitHub token must have `read:packages` permission.

---

## 📜 Usage

---

### 🔄 **Accessing the Economy Provider Directly**
Instead of relying on event-based initialization, you can directly access the economy provider using:

```kotlin
val provider = PlayerEconomyProvider.getInstance()

val playerUUID = UUID.randomUUID()
val economyType = Economy.fromName("money")

val playerEconomy = provider.getEconomy(playerUUID)
playerEconomy.addBalance(economyType, 500.0)

println("New balance: ${playerEconomy.getBalance(economyType)}")
```

⚠️ **Warning:**  
While `PlayerEconomyProvider.getInstance()` provides direct access to the provider, **it is recommended to use the initialization event** (`EconomyEvents.INITIALIZED`) to store an instance of `EconomyProvider` in your project.  
This ensures that the provider is **fully initialized** before usage and avoids potential race conditions or null references.

Example of proper instance storage:

```kotlin
var economyProvider: EconomyProvider? = null

EconomyEvents.INITIALIZED.register { provider ->
    economyProvider = provider
}
```

By following this approach, you ensure that the economy system is properly set up before interacting with it.

---

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
