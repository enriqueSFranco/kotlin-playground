package org.tempest.designPatterns

//Imaginemos que estamos desarrollando un sistema de pago que puede usar
//diferentes métodos de pago, como tarjeta de crédito, PayPal y Bitcoin.
//Queremos poder cambiar el método de pago sin cambiar el código que lo usa.


// Interfaz para la estrategia de pago
interface PaymentStrategy {
    fun pay(amount: Double)
}

// Estrategia concreta para el pago con tarjeta de crédito
class CreditCardStrategy(private val cardNumber: String) : PaymentStrategy {
    override fun pay(amount: Double) {
        println("Paying $$amount with credit card $cardNumber")
    }
}

// Estrategia concreta para el pago con PayPal
class PayPalPayment(private val email: String) : PaymentStrategy {
    override fun pay(amount: Double) {
        println("Paying $$amount with PayPal account $email")
    }
}

// Estrategia concreta para el pago con Bitcoin
class BitCountPayment(private val walletAddress: String) : PaymentStrategy {
    override fun pay(amount: Double) {
        println("Paying $$amount with Bitcoin wallet $walletAddress")
    }
}

// Contexto que usa la estrategia de pago
class ShoppingCart(private var paymentStrategy: PaymentStrategy) {
    fun update(paymentStrategy: PaymentStrategy) {
        this.paymentStrategy = paymentStrategy
    }

    fun checkout(amount: Double) {
        paymentStrategy.pay(amount)
    }
}

fun main() {
    val shoppingCart = ShoppingCart(CreditCardStrategy("1234-5678-9876-5432"))
    shoppingCart.checkout(35_500.00)

    shoppingCart.update(PayPalPayment("kirito@gmail.com"))
    shoppingCart.checkout(400.00)

    shoppingCart.update(BitCountPayment("1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa"))
    shoppingCart.checkout(300.0)
}