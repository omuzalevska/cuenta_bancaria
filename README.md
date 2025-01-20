# cuenta_bancaria
This program simulates the functionality of a bank account, supporting two types of accounts: **Savings Account** (`CuentaAhorros`) and **Current Account** (`CuentaCorriente`).

The project is implemented in **Java** using an object-oriented approach.

## Features
1. **Cuenta** (base class for accounts):
   - Deposit money into the account.
   - Withdraw money with balance validation.
   - Calculate monthly interest based on the annual rate.
   - Generate a monthly statement (deducting fees and adding interest).
   - Print account details.

2. **CuentaAhorros** (savings account):
   - Account activity depends on the balance (inactive if less than 10,000).
   - Additional fees for more than 4 withdrawals in a month.

3. **CuentaCorriente** (current account):
   - Supports overdrafts (allows spending beyond the account balance and records debt).

# Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/<your-username>/cuenta-bancaria.git