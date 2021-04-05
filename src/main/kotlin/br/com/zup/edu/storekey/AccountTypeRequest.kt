package br.com.zup.edu.storekey

import br.com.zup.edu.BankAccountType

enum class AccountTypeRequest(val grpcAttribute: BankAccountType) {
    SAVING(BankAccountType.SAVING),
    CHECKING(BankAccountType.CHECKING),
}
