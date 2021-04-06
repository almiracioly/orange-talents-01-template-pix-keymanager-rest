package br.com.zup.edu.getallownerkeys

import br.com.zup.edu.GetAllPixKeysRequest
import br.com.zup.edu.KeyManagerListPixKeysGrpc
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import java.util.*

@Controller("/api/v1/clientes/{ownerId}")
class GetAllOwnerKeysController(private val grpcGetAllKeysClient: KeyManagerListPixKeysGrpc.KeyManagerListPixKeysBlockingStub) {

    @Get("/pix")
    fun getAllKeys(ownerId: UUID): HttpResponse<Any> {
        val grpcResponse = grpcGetAllKeysClient.getAllPixKeys(
            GetAllPixKeysRequest
                .newBuilder()
                .setOwnerId(ownerId.toString())
                .build()
        )

        return HttpResponse.ok(GetAllOwnerKeysRestResponse(grpcResponse))
    }
}