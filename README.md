# Bank Account State Manager

A robust Java implementation of a bank account management system demonstrating the **State** and **Builder** Design Patterns.

## Overview

This project provides a flexible and extensible way to manage different states of a bank account (Normal, Overdrawn, Blocked) and the transitions between them based on specific rules (e.g., balance limits).

## Features

- **State Pattern**: Encapsulates state-specific behaviors (withdraw, deposit) into separate classes (`CompteNormal`, `CompteDecouvert`, `CompteBloque`).
- **Builder Pattern**: Fluent API to configure the `EtatTransitionManager`.
- **Dynamic Transitions**: Rules for changing states are decoupled from the account logic and can be configured dynamically.

## Technologies

- Java 17+
- Maven
- LaTeX (for project documentation)

## Architecture

- `Compte`: The context class.
- `EtatCompte`: The state interface.
- `EtatTransitionManager`: Handles state transitions based on predicates.

## Usage

```java
// Configure the transition manager
EtatTransitionManager manager = new EtatTransitionManager.Builder()
    .addTransition(CompteNormal.class, CompteDecouvert.class, c -> c.getSolde() < 0)
    .addTransition(CompteDecouvert.class, CompteNormal.class, c -> c.getSolde() > 0)
    .build();

// Create an account
Compte account = new Compte(manager);

// Perform operations
account.deposer(1000);
account.retirer(2000); // Might trigger transition to Overdrawn
```
