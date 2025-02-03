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
            username = project.findProperty("gpr.user") as String? ?: System.getenv("GITHUB_USERNAME")
            password = project.findProperty("gpr.token") as String? ?: System.getenv("GITHUB_TOKEN")
        }
    }
}

dependencies {
    modImplementation("com.github.cobblestory:economy-api:0.0.3")
}
```

### 🛠️ **Gradle (Groovy DSL)**

```groovy
repositories {
    maven {
        url = uri("https://maven.pkg.github.com/CobbleStory/CobbleEconomyAPI")
        credentials {
            username = project.findProperty("gpr.user") ?: System.getenv("GITHUB_USERNAME")
            password = project.findProperty("gpr.token") ?: System.getenv("GITHUB_TOKEN")
        }
    }
}

dependencies {
    modImplementation "com.github.cobblestory:economy-api:0.0.3"
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
export GITHUB_USERNAME=your-github-username
export GITHUB_TOKEN=your-personal-access-token
```

> **Note:** The GitHub token must have `read:packages` permission.

---

## 📜 Usage

### 📢 Available Events

The API provides **four main events** to interact with player balances.

#### 1️⃣ Economy Initialization
Triggered when the economy system is ready to use.

```kotlin
EconomyEvents.INITIALIZED.register { provider ->
    println("Economy system initialized: $provider")
    
    val testPlayer = UUID.randomUUID()
    val economyType = Economy.fromName("money")
    val playerEconomy = provider.getEconomy(testPlayer)
    
    playerEconomy.setBalance(ecosystemType, 1000.0)
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
