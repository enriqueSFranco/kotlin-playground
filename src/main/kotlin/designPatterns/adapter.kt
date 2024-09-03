package org.tempest.desingPatterns

/*
    El patrón de diseño Adapter, también conocido como Wrapper, es un patrón estructural que permite la colaboración
    entre interfaces incompatibles. Este patrón convierte la interfaz de una clase en otra interfaz que el cliente espera.
    En otras palabras, permite que las clases trabajen juntas cuando de otro modo sería imposible
    debido a sus interfaces incompatibles.
*/

// Interfaz existente
interface Employee {
    fun getFullName(): String
}

// Clase existente
class OldEmployee(private val firstName: String, private val lastName: String): Employee {
    override fun getFullName(): String {
        return "$firstName $lastName"
    }
}

// Nueva interfaz requerida
interface NewEmployee {
    fun fullName(): String
}

// Adaptador
class EmployeeAdapter(private val oldEmploye: OldEmployee): NewEmployee {
    override fun fullName(): String {
        return oldEmploye.getFullName()
    }
}

/*
* Un ejemplo más avanzado relacionado con un sistema de gestión de pagos en una aplicación.
* Supongamos que estamos desarrollando una aplicación de comercio electrónico que utiliza diferentes proveedores de
* pasarelas de pago para procesar transacciones. Cada proveedor de pasarela de pago tiene su propia interfaz de cliente.
* Para mantener la flexibilidad y la independencia del proveedor, podemos utilizar el patrón Adapter para adaptar las
* diversas interfaces de los proveedores de pasarela de pago a una interfaz común en nuestra aplicación.
* */

// Interfaz común para todas las pasarelas de pago
interface PaymentGateway {
    suspend fun processPayment(amount: Int): String
}

// Pasarela de pago de PayPal
class PayPalClient(private val apiKey: String) {
    suspend fun sendPayment(amount: Int): String {
        // delay(1000)
        return "PayPal payment of $$amount processed successfully"
    }
}

// Adaptador para PayPal
class PayPalAdapter(private val payPalClient: PayPalClient): PaymentGateway {
    override suspend fun processPayment(amount: Int): String {
        val amountInCent = amount * 100
        return payPalClient.sendPayment(amountInCent)
    }
}

class StripeClient(private val secreteKey: String) {
    suspend fun createCharge(amount: Int): String {
        // Lógica para crear un cargo con Stripe
        // delay(1000) Simulando una operación de red
        return "Stripe charge of $$amount created successfully"
    }
}

class StripeAdapter(private val stripeClient: StripeClient): PaymentGateway {
    override suspend fun processPayment(amount: Int): String {
        val amountInCent = amount * 100
        return stripeClient.createCharge(amountInCent)
    }
}

fun processPaymentWithGateway(paymentGateway: PaymentGateway, amount: Int) {
//    runBloking {
//        val result = paymentGateway.processPayment(amount)
//        println(result)
//    }
}

fun main() {
    val oldEmployee = OldEmployee("enrique", "sfranco")
    val adapter = EmployeeAdapter(oldEmployee)
    println(adapter.fullName())

    // EJEMPLO DE LA PASARELA DE PAGO
    val paypalClient = PayPalClient("paypal_api_key")
    val stripeClient = StripeClient("stripe_secret_key")

    val paypalAdapter = PayPalAdapter(paypalClient)
    val stripeAdapter = StripeAdapter(stripeClient)

    // Procesar un pago utilizando PayPal
    processPaymentWithGateway(paypalAdapter, 100)

    // Procesar un pago utilizando Stripe
    processPaymentWithGateway(stripeAdapter, 150)
}