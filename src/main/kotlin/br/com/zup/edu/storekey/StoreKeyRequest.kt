package br.com.zup.edu.storekey

import br.com.zup.edu.BankAccountType
import br.com.zup.edu.KeyType
import br.com.zup.edu.StoreKeyRequest
import io.micronaut.core.annotation.Introspected
import java.util.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Introspected
data class StoreKeyRequest(
    @field:NotNull val accountType: AccountTypeRequest?,
    @field:Size(max = 77) val keyValue: String?,
    @field:NotNull val keyType: KeyTypeRequest?
) {

    fun toGrpcModel(ownerId: UUID): StoreKeyRequest {
        return StoreKeyRequest
            .newBuilder()
            .setOwnerId(ownerId.toString())
            .setAccountType(accountType?.grpcAttribute ?: BankAccountType.UNRECOGNIZED)
            .setKeyType(keyType?.grpcAttribute ?: KeyType.UNRECOGNIZED)
            .setValue(keyValue ?: "")
            .build()
    }
}
