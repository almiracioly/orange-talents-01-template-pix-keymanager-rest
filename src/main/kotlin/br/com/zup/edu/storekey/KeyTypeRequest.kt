package br.com.zup.edu.storekey

import br.com.zup.edu.KeyType
import io.micronaut.validation.validator.constraints.EmailValidator

enum class KeyTypeRequest(val grpcAttribute: KeyType) {

    CPF(KeyType.CPF) {
        override fun isValid(keyValue: String?): Boolean {
            TODO("Not yet implemented")
        }
    },
    PHONE(KeyType.PHONE) {
        override fun isValid(keyValue: String?): Boolean {
            if (keyValue.isNullOrBlank()) return false

            return keyValue.matches("^\\+[1-9][0-9]\\d{1,14}\$".toRegex())
        }
    },
    EMAIL(KeyType.EMAIL) {
        override fun isValid(keyValue: String?): Boolean {
            if (keyValue.isNullOrBlank()) return false

            return EmailValidator().run {
                initialize(null)
                this.isValid(keyValue, null)
            }
        }
    },
    RANDOM(KeyType.RANDOM) {
        override fun isValid(keyValue: String?) = keyValue.isNullOrBlank()
    };

    abstract fun isValid(keyValue: String?): Boolean
}
