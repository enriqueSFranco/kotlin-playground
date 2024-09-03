package org.tempest.desingPatterns

interface DatabaseConnection {
    fun connect()
}

class OracleConnection(): DatabaseConnection {
    override fun connect() {
        print("Connecting to Oracle...")
    }
}

class MySqlConnection(): DatabaseConnection {
    override fun connect() {
        print("Connecting to MySql...")
    }
}

class PostgreSqlConnection(): DatabaseConnection {
    override fun connect() {
        print("Connecting to Postgre...")
    }
}

class MongoConnection : DatabaseConnection {
    override fun connect() {
        println("Connecting to MongoDB...")
    }
}

object DatabaseConnectionFactory {
    fun createDatabaseConnection(type: String): DatabaseConnection {
        return when(type) {
            "Oracle" -> OracleConnection()
            "MySql" -> MySqlConnection()
            "PostgreSQL" -> PostgreSqlConnection()
            "MongoDB" -> MongoConnection()
            else -> throw IllegalArgumentException("Invalid database type")
        }
    }
}

fun main() {
    val oracleConnection = DatabaseConnectionFactory.createDatabaseConnection("Oracle")
    oracleConnection.connect()
}