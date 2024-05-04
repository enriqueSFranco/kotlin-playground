package org.tempest.desingPatterns

import org.tempest.desingPatterns.builder.Address
import org.tempest.desingPatterns.builder.Phone

class EmployeeBuilder private constructor(builder: Builder) {
    val id: String = builder.id
    val name: String = builder.name
    val age: Int = builder.age
    val address: Address = builder.address
    val phone: Phone = builder.phone

    class Builder(
        val id: String,
        val name: String,
        val age: Int
    ) {
        lateinit var address: Address
        lateinit var phone: Phone

        fun setAddress(street: String, city: String, zipCode: String, country: String) = apply {
            address = Address(street, city, zipCode, country)
        }

        fun setPhone(countryCode: String, areaCode: String, number: String) = apply {
            phone = Phone(countryCode, areaCode, number)
        }

        fun build() = EmployeeBuilder(this)
    }

    override fun toString(): String {
        return "Employee(id='$id', name='$name', age=$age, address=$address, phone=$phone)"
    }
}