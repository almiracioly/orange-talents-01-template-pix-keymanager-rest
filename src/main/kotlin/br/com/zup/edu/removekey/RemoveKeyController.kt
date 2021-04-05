package br.com.zup.edu.removekey

import br.com.zup.edu.KeyManagerRemovePixKeyGrpc
import br.com.zup.edu.RemoveKeyRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import java.util.*

@Controller("/api/v1/clientes/{ownerId}")
class RemoveKeyController(private val grpcRemoveKeyClient: KeyManagerRemovePixKeyGrpc.KeyManagerRemovePixKeyBlockingStub) {

    @Delete("/pix/{pixId}")
    fun remove(ownerId: UUID, pixId: UUID): HttpResponse<Any> {
        grpcRemoveKeyClient.removeKey(
            RemoveKeyRequest
                .newBuilder()
                .setOwnerId(ownerId.toString())
                .setPixId(pixId.toString())
                .build()
        )

        return HttpResponse.ok()
    }

}